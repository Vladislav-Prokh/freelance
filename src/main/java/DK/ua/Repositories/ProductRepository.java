package DK.ua.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DK.ua.Models.Shop.Product;


public interface  ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByIdOfShop(Long id);

}
