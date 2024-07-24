package DK.ua.Models.model_of_product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category_of_product {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_of_category")
	private Long id_of_category;
	@Column
	private String name;
	public Category_of_product(Long id_of_category) {
		super();
		this.id_of_category = id_of_category;
	}
	public Category_of_product() {
		super();
	}
	
	

}
