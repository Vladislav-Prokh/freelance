package DK.ua.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DK.ua.Models.Shop.Product;
import DK.ua.Repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRep;
	
	public List<Product> findAllProductInBD(){
		return productRep.findAll();
	}
	
	public void saveProduct(Product product) {
		productRep.save(product);
	}
	
	public List<Product> findAllProductOfCurrentShop(Long id){
		return productRep.findByIdOfShop(id);
	}
	
	
}
