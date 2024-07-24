package DK.ua.Services;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import DK.ua.Dto.UserRegistrationDto;
import DK.ua.Models.Role;
import DK.ua.Models.User;
import DK.ua.Models.user_Roles;
import DK.ua.Repositories.UserRepository;
import DK.ua.Repositories.user_roles_repository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private user_roles_repository user_role_rep;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		   User userFromDB = userRepository.findByEmail(registrationDto.getEmail());
	        registrationDto.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
	        registrationDto.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
	        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),registrationDto.getRoles());
	        userRepository.save(user);
	        return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public boolean deleteById(Long userId) {
		 try{
			 userRepository.deleteById(userId);
			 user_role_rep.deleteById(userId);
		 }
		 catch(Exception e) {
			 return false;
		 }
		 return true;
	}

	public Optional<User> findById(Long id) {
		try {
		return userRepository.findById(id);
		}
		catch(Exception ex) {
			return Optional.ofNullable(new User());
		}
	}
	
	@Transactional
	public boolean give_rights(Long user_id,Long roles_id) {
	
		  try {
			  user_Roles us = new user_Roles(user_id,roles_id);
			  user_role_rep.save(us);
		  
		  }
		  catch(Exception ex) {
			  return false;
		  }

		return true;
	}

	public void delete_rights(Long userId, Long id_of_admin_role_in_db) {
		  try {
			  
			  user_role_rep.removeByUserIdAndRolesId(userId, id_of_admin_role_in_db);
		
		  }
		  catch(Exception ex) {
			  System.out.print(ex);
		  }

	
	}

}
