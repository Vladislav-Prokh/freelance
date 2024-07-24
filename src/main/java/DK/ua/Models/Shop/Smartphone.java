package DK.ua.Models.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Smartphones")
public class Smartphone extends Electronic {

	
	@Column(name = "model")
	protected String model;
	@Column(name = "diagonal")
	protected float diagonal;
	@Column(name = "proccessor")
	protected String processor;
	
	public  Smartphone (Long idOfShop,String name, float price, String color,float weight,String codeOfProduct,String model, float diagonal, String processor) {
		super(idOfShop,name,price,color,weight,codeOfProduct);
		this.model = model;
		this.diagonal = diagonal;
		this.processor = processor;
	}
	
	public  Smartphone () {
		super();
	}

	public Smartphone(Long idOfShop, String name, float price, String color, float weight, String codeOfProduct) {
		super(idOfShop, name, price, color, weight, codeOfProduct);
	}
	
	
}
