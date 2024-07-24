package DK.ua.Models.model_of_product;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advertisements")
public  class advert {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_of_user")
	private Long id_of_user;
	
	@OneToOne
	@JoinColumn(name = "id_category_of_product", foreignKey= @ForeignKey (name = "id_of_category"))
	private Category_of_product id_category_of_product;
	
	@OneToOne
	@JoinColumn(name = "id_SubCategory_of_product", foreignKey= @ForeignKey (name = "id_of_SubCategory"))
	private SubCategory id_SubCategory_of_product;
	
	@Column(name = "short_name")
	private String short_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="image")
	private String image;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name = "data_of_publication")
	private LocalDate DataOfPublication;


	

	public advert(Long id_of_user, Category_of_product id_category_of_product,
			SubCategory  id_SubCategory_of_product, String short_name, String description, double price,
			 String email, String location, String phonenumber) {
		super();
		this.id_of_user = id_of_user;
		this.id_category_of_product = id_category_of_product;
		this.id_SubCategory_of_product = id_SubCategory_of_product;
		this.short_name = short_name;
		this.description = description;
		this.price = price;
		this.email = email;
		this.location = location;
		this.phonenumber = phonenumber;
	}

	public advert() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Long getId_of_user() {
		return id_of_user;
	}

	public Category_of_product getId_category_of_product() {
		return id_category_of_product;
	}

	public SubCategory getId_SubCategory_of_product() {
		return id_SubCategory_of_product;
	}

	public String getShort_name() {
		return short_name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getDataOfPublication() {
		return DataOfPublication;
	}

	public void setDataOfPublication(LocalDate dataOfPublication) {
		DataOfPublication = dataOfPublication;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
