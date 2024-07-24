package DK.ua.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DK.ua.Models.model_of_product.advert;

public interface AdvertRepository extends JpaRepository<advert,Long> {

	
	public List<advert> findByPriceGreaterThan(double amount);
}
