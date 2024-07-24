package DK.ua.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DK.ua.Models.User;
import DK.ua.Models.Shop.Shop;

@Repository
public interface  ShopRepository extends JpaRepository<Shop, Long>{
	public List<Shop> findByuserID(Long IdofUse);
	
}