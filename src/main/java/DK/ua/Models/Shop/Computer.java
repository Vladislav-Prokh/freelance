package DK.ua.Models.Shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Computers")
public class Computer extends Electronic {
	@Column(name = "Processor")
	protected String proccessor;
	@Column(name = "GPU")
	protected String GPU;
	@Column(name = "RAM")
	protected String RAM;
	@Column(name = "HDD")
	protected String HDD;

	public Computer( Long idOfShop, String name, float price, String color, float weight, String codeOfProduct, String proccessor, String gPU,
			String rAM, String hDD ) {
		super(idOfShop,name, price, color, weight,codeOfProduct);
		this.proccessor = proccessor;
		GPU = gPU;
		RAM = rAM;
		HDD = hDD;
	}

	public Computer( Long idOfShop,String name, float price, String color, float weight,String codeOfProduct) {
		super(idOfShop,name, price, color, weight, codeOfProduct);
	}
	
	public Computer() {
		super();
	}

	public String getProccessor() {
		return proccessor;
	}

	public String getGPU() {
		return GPU;
	}

	public String getRAM() {
		return RAM;
	}

	public String getHDD() {
		return HDD;
	}
	
	
}
