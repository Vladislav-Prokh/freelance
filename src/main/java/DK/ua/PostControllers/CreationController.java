package DK.ua.PostControllers;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import DK.ua.Services.FileUploadUtil;

import DK.ua.Factories.ComputerFactory;
import DK.ua.Factories.FeedFactory;
import DK.ua.Factories.SmartphoneFactory;
import DK.ua.Factories.ToyFactory;
import DK.ua.Models.User;

import DK.ua.Models.Shop.Product;
import DK.ua.Models.Shop.Shop;
import DK.ua.Models.model_of_product.Category_of_product;
import DK.ua.Models.model_of_product.SubCategory;
import DK.ua.Models.model_of_product.advert;
import DK.ua.Repositories.ShopRepository;
import DK.ua.Services.AdvService;
import DK.ua.Services.ProductService;
import DK.ua.Services.UserServiceImpl;



@Controller
public class CreationController {
	
	@Autowired
	private UserServiceImpl userServ;
	
	@Autowired
	ShopRepository sj;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AdvService advertService;
	
	
	@PostMapping(value= "/create-shop")
	public String createShop(@RequestParam("name") String name,@RequestParam("selectTypeID") Long TypeID  ) {
		
		Shop shop = new Shop(name,getIdOfAuthUser(),TypeID);
		sj.save(shop);
		return "redirect:/home";
		
	}
	
	@PostMapping(value= "/create-product")
	public String createProduct(@RequestParam("select-type-product") String ConcreteProduct,
			@RequestParam("name") String name,@RequestParam("price") float price,
			@RequestParam("select-color") String color,	@RequestParam("weight") float weight,
			@RequestParam("IdOfShop") Long IdOfShop,
			@RequestParam("product-param") String ... param) {
			
		Product product = new Product();
		
		switch(ConcreteProduct) {
		
			case "PC": 
				ComputerFactory PcFactory = new ComputerFactory();
				product  = PcFactory.createProduct(IdOfShop, name, price, color, weight, ConcreteProduct,param[0], param[1], param[2], param[3]);
				break;
			
			case "SmartPhone":
				SmartphoneFactory SmartPhoneFactory = new SmartphoneFactory();
				product = SmartPhoneFactory.createProduct(IdOfShop, name, price, color, weight, ConcreteProduct, param[0],param[1] , param[2]); 
				break;
			
			case "Feed": 
				FeedFactory feedFactory = new FeedFactory();
				product = feedFactory.createProduct(IdOfShop, name, price, color, weight, ConcreteProduct, param[0], param[1]);
				break;
			
			case "Toy": 
				ToyFactory toyFactory = new ToyFactory();
				product = toyFactory.createProduct(IdOfShop, name, price, color, weight, ConcreteProduct, param[0], param[1]);
				break;

		}
		
		productService.saveProduct(product);
		
		return "redirect:/allShops/"+IdOfShop;
		
	}
	
	@PostMapping(value= "/create-adv")
	public String createAdv(@RequestParam("name") String name,@RequestParam("price") double price,@RequestParam("Category") Long Category,
			@RequestParam("subCategory") Long subCategory,@RequestParam("location") String location,@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("@mail") String mail,@RequestParam("desc") String desc,@RequestParam("UserId") Long UserID,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		
		Category_of_product category = new Category_of_product(Category);
		SubCategory sub = new SubCategory(subCategory);
		
		advert adv = new advert(UserID,category,sub, name, desc ,price, mail,location, phoneNumber);
		
		LocalDate now =  LocalDate.now();
		
		adv.setDataOfPublication(now);
		
		
  	  String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
       
  	  String uploadDir = "src/main/images/"; //+ savedTopic.getId();
  	  
  	  adv.setImage(uploadDir+fileName);
         
       advertService.save(adv);

       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		
	   return "redirect:/home";
	}
	

	
	private Long getIdOfAuthUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user =  userServ.findUserByEmail(auth.getName());
		return user.getId();
		

	}
}
