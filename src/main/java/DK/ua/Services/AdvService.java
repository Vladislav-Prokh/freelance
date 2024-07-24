package DK.ua.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DK.ua.Models.model_of_product.advert;
import DK.ua.Repositories.AdvertRepository;

@Service
public class AdvService {

	@Autowired
	AdvertRepository advertRep;
	
	public List<advert> findAll(){
		return advertRep.findAll();
	}
	
	
	public boolean save(advert adv) {
		if(advertRep.save(adv) != null)
			return true;
		else
			return false;
		
	}
	
	public List<advert> findAllMoreThan(float price){
		return advertRep.findByPriceGreaterThan((double)price);
	}
}
