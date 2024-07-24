package DK.ua.Models.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Feeds")
public class Feed extends Zoo{

	@Column
	private String Company;
	@Column
	private String DesignedFor;
	
	public Feed(Long idOfShop,String name, float price, String color, float weight, String codeOfProduct, String company,
			String designedFor) {
		super(idOfShop,name, price, color, weight,codeOfProduct );
		Company = company;
		DesignedFor = designedFor;
	}

	
	
	public Feed(Long idOfShop, String name, float price, String color, float weight, String codeOfProduct) {
		super(idOfShop, name, price, color, weight, codeOfProduct);
	}



	public Feed() {
		super();
	}

	
}
