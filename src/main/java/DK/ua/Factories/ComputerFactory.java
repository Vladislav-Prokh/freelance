package DK.ua.Factories;

import DK.ua.Models.Shop.Computer;
import DK.ua.Models.Shop.Product;

public class ComputerFactory extends Factory {

	@Override
	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct) {

		return new Computer(idOfShop, name, price, color, weight, codeOfProduct);
	}

	public Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct, String string, String string2, String string3, String string4) {
		
		return  new Computer(idOfShop, name, price, color, weight, codeOfProduct, string, string2, string3, string4);
	}



}
