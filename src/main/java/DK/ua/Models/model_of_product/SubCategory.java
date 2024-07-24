package DK.ua.Models.model_of_product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SubCategory")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_of_SubCategory")
	private Long id_of_SubCategory;
	@Column
	private String name;
	public SubCategory(Long id_of_SubCategory) {
		super();
		this.id_of_SubCategory = id_of_SubCategory;
	}
	public SubCategory() {
		super();
	}


	
	
}
