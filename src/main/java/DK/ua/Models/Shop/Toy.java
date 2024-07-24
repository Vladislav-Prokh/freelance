package DK.ua.Models.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "Toys")
public class Toy extends Zoo {

	@Column
	private String Company;
	@Column
	private String DesignedFor;

	public Toy(Long idOfShop,String name, float price, String color, float weight,String codeOfProduct, String company,
			String designedFor) {
		super(idOfShop,name, price, color, weight ,codeOfProduct);
		Company = company;
		DesignedFor = designedFor;
	}
	
	public Toy() {
		super();
	}

	public Toy(Long idOfShop, String name, float price, String color, float weight, String codeOfProduct) {
		super(idOfShop, name, price, color, weight, codeOfProduct);
	}
	
}
