package DK.ua.Factories;

import DK.ua.Models.Shop.Product;
import DK.ua.Models.Shop.Toy;

public class ToyFactory extends Factory {

	@Override
	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct) {
		return new Toy(idOfShop, name, price, color, weight, codeOfProduct);
	}

	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct, String string, String string2) {
		return new Toy(idOfShop, name, price, color, weight, codeOfProduct,string,string2);
	}
	
	
}
