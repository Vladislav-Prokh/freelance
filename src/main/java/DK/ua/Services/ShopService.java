package DK.ua.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DK.ua.Models.TypeOfShop;
import DK.ua.Models.Shop.Shop;
import DK.ua.Repositories.ShopRepository;
import DK.ua.Repositories.TypeOfShopRep;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRep;
	@Autowired
	TypeOfShopRep typeRep;
	
	
	public void saveShopToDb(Shop shop) {
		shopRep.save(shop);
	}
	
	public List<Shop> findAllShopsInDb(){
		return shopRep.findAll();
	}
	
	public String findTypeOfShopById(Long id) {
		Optional<TypeOfShop> type = typeRep.findById(id);
		return type.get().getName();
	}
	
	public List<Shop> findAllShopByUserID(Long UserId){
		return shopRep.findByuserID(UserId);
	}
	
	public Optional<Shop> findShopById(Long id) {
		return shopRep.findById(id);
	}
	
	public Long findIdOfOwnerOfShopBySHopId(Long id) {
		Optional<Shop> shop = shopRep.findById(id);
		return  shop.get().getUserID();
			
	
	}
	
	
}
