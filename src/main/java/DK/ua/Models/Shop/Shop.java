package DK.ua.Models.Shop;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shops")
public class Shop {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_of_shop")
	private Long id_of_shop;
	@Column
	private String name;
	@Column(name = "id_of_user")
	private Long userID;
	@Column
	private Long IdOftypeOfShop;
	
	
	public Shop(String name, Long id_of_user, Long idOftypeOfShop) {
		super();
		this.name = name;
		this.userID = id_of_user;
		IdOftypeOfShop = idOftypeOfShop;
	}

	public Long getIdOftypeOfShop() {
		return IdOftypeOfShop;
	}

	public Shop() {
		super();
	}

	public String getName() {
		return name;
	}

	public Long getId_of_shop() {
		return id_of_shop;
	}

	public Long getUserID() {
		return userID;
	}


	
}
