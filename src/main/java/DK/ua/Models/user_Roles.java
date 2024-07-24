package DK.ua.Models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user_roles")
public class user_Roles {
	
	@Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name="roles_id")
    private Long rolesId;
	
    public Long getUser_id() {
		return userId;
	}
	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}
	public Long getRoles_id() {
		return rolesId;
	}
	public void setRoles_id(Long roles_id) {
		this.rolesId = roles_id;
	}
	public user_Roles(Long user_id, Long roles_id) {
		super();
		this.userId = user_id;
		this.rolesId = roles_id;
	}
	public user_Roles() {
		super();
	}


	
}
