package DK.ua.Models.Shop;




public class Electronic extends Product {
	
	public Electronic( Long idOfShop,String name, float price, String color, float weight,String codeOfProduct) {
		super(idOfShop, name, price, color, weight, codeOfProduct);
	}

	public Electronic() {
		super();
	}
}
