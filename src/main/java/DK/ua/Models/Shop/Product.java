package DK.ua.Models.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;


@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Product {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "idOfProduct")
	protected Long idOfProduct;
	
	@Column(name = "idOfShop")
	protected Long idOfShop;
	
	@Column(name = "Product_name")
	protected String name;
	@Column(name = "price")
	protected float price;
	@Column(name = "color")
	protected String color;
	@Column(name = "weight")
	protected float weight;
	
	@Column(name = "code")
	protected String codeOfProduct;
	

	
	public Product(Long idOfShop, String name, float price, String color, float weight, String codeOfProduct) {
		super();
		this.idOfShop = idOfShop;
		this.name = name;
		this.price = price;
		this.color = color;
		this.weight = weight;
		this.codeOfProduct = codeOfProduct;
	}
	public Product() {
		super();
	}
	public Long getIdOfProduct() {
		return idOfProduct;
	}
	public String getCodeOfProduct() {
		return codeOfProduct;
	}
	public void setIdOfProduct(Long idOfProduct) {
		this.idOfProduct = idOfProduct;
	}
	public Long getIdOfShop() {
		return idOfShop;
	}
	public void setIdOfShop(Long idOfShop) {
		this.idOfShop = idOfShop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

	
	
}
