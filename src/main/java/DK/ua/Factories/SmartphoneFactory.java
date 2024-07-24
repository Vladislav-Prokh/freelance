package DK.ua.Factories;

import DK.ua.Models.Shop.Product;
import DK.ua.Models.Shop.Smartphone;

public class SmartphoneFactory extends Factory{

	@Override
	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct) {
		return new Smartphone(idOfShop, name, price, color, weight, codeOfProduct);
	}

	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct, String string, String string2, String string3) {
		
		return new Smartphone(idOfShop, name, price, color, weight, codeOfProduct, string,  Float.parseFloat(string2), string3);
	}

}
