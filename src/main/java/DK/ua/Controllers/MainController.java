package DK.ua.Controllers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import DK.ua.Models.User;
import DK.ua.Models.Shop.Computer;
import DK.ua.Models.Shop.Feed;
import DK.ua.Models.Shop.Product;
import DK.ua.Models.Shop.Shop;
import DK.ua.Repositories.ProductRepository;
import DK.ua.Services.AdvService;
import DK.ua.Services.ProductService;
import DK.ua.Services.ShopService;
import DK.ua.Services.UserServiceImpl;


@Controller
public class MainController {
	
	@Autowired
	private UserServiceImpl userServ;
	
	@Autowired 
	ShopService shopService;
	
	@Autowired
	ProductService ProdService;
	
	@Autowired
	AdvService advertService;
	
	//home page

	@GetMapping("/")
	public String default_page(Model model) {
		main(model,null);
		return "main/shop";
	}
	@GetMapping("/home")
	public String main(Model model, @RequestParam(value = "amount", required = false) String amount) {
		if(amount != null) {
			int indexOfFirstSpace = amount.indexOf(" ");
			float amou = Float.parseFloat(amount.substring(1, indexOfFirstSpace)) ;
		
			model.addAttribute("Advertistments",advertService.findAllMoreThan(amou));
			return "main/shop";
		}
		else {
			model.addAttribute("Advertistments",advertService.findAll());
			return "main/shop";
		}
	}
	
	
	// ======
		
	@GetMapping("/login")
	public String getLogin(@RequestParam(value = "error", required = false) String error,
	                       @RequestParam(value = "logout", required = false) String logout,
	                        Model model) {
	        model.addAttribute("error", error != null);
	        model.addAttribute("logout", logout != null);
	        return "Auth/login";
	    }
	
	@GetMapping("/give_add")
	public String add_adv(Model model) {
		model.addAttribute("UserId",getAuthUser().getId());
		return "main/form_for_adding_adv";
	}

	@GetMapping("/myaccount")
	public String myacc(Model model) {

		User user = getAuthUser();

		model.addAttribute("authUser", user);
		model.addAttribute("authUserID", user.getId());
		
		return"main/myaccount";
	}

	
	//Work with shops
	@GetMapping("/allShops")
	public String ShowAllShops(Model model) {
		
		ArrayList<Shop> ListOfAllShop =  (ArrayList<Shop>) shopService.findAllShopsInDb();
		ArrayList<String> listOfTypesShop =  new ArrayList<>(); 
		
		for(Shop shop : ListOfAllShop){
			listOfTypesShop.add(shopService.findTypeOfShopById(shop.getIdOftypeOfShop()));
		}
		
		User user = getAuthUser();
		if(user!=null)
			model.addAttribute("authUserID", user.getId());
		model.addAttribute("Shops", ListOfAllShop);
		model.addAttribute("TypesOfShops", listOfTypesShop);
		
		
		return "main/AllShops";
	}
	
	@GetMapping("/allShops/{id}")
	public String ShowConcreteShop(@PathVariable("id") Long id,Model model) {
		
		Optional<Shop> shop = Optional.ofNullable(shopService.findShopById(id).get());
		model.addAttribute("IsShopOfCurrentClient", null);	
		
		if(getAuthUser()!=null && getAuthUser().getId() ==  shop.get().getUserID()) 
			model.addAttribute("IsShopOfCurrentClient", true);
		
		model.addAttribute("IdOfShop",id);
		model.addAttribute("TypeOfShop", shopService.findShopById(id).get().getIdOftypeOfShop());
		model.addAttribute("Products",ProdService.findAllProductOfCurrentShop(id));

		return "main/ConcreteShop";
	}
	
	@GetMapping("/MyShops/{id}")
	public String ShowShopsConcreteUser(Model model,@PathVariable("id") Long id) {
		
		ArrayList<Shop> ListOfAllShopByUser =  (ArrayList<Shop>) shopService.findAllShopByUserID(id);
		model.addAttribute("Shops",ListOfAllShopByUser );
		
		ArrayList<String> listOfTypesShop =  new ArrayList<>(); 
		
		
		for(Shop shop : ListOfAllShopByUser ){
			listOfTypesShop.add(shopService.findTypeOfShopById(shop.getIdOftypeOfShop()));
		}
		model.addAttribute("TypesOfShops", listOfTypesShop);
		
		User user = getAuthUser();
		model.addAttribute("authUserID", user.getId());
		
		return "main/AllShops";
	}
	
	//==========
	private User getAuthUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User authuser =  userServ.findUserByEmail(auth.getName());
		return authuser;	
	}
	
	

	
}
