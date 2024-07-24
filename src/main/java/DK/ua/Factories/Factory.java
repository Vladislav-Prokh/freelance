package DK.ua.Factories;

import DK.ua.Models.Shop.Product;

public abstract class Factory {

	public abstract Product createProduct(Long idOfShop, String name, float price, String color, float weight,
			String codeOfProduct);
	
	
}
