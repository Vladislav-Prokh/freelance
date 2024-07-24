package DK.ua.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import DK.ua.Dto.UserRegistrationDto;
import DK.ua.Models.User;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	
}
