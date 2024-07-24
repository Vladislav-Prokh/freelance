package DK.ua.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import DK.ua.Repositories.TypeOfShopRep;

@Entity
@Table(name = "TypeOfShop")
public class TypeOfShop {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	
	
	public TypeOfShop(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public TypeOfShop() {
		super();
	}


	
	
	
}
