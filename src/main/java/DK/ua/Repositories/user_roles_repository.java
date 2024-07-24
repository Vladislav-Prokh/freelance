package DK.ua.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import DK.ua.Models.user_Roles;

public interface user_roles_repository extends JpaRepository<user_Roles, Long> {
	@Transactional
	public void removeByUserIdAndRolesId(Long userId, Long rolesId);
}
