package DK.ua.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DK.ua.Models.User;
import DK.ua.Services.UserServiceImpl;



@Controller
public class AdminController {
	
	@Autowired
	private UserServiceImpl userServ;
	
	@GetMapping("/admin")
	public String show_admin_panel(Model model) {
		model.addAttribute("Users", userServ.findAllUsers());
		return "Admin/admin_page";
	}
	

	@PostMapping("/admin/delete-user")
	public String delete_user(@RequestParam(required = true, defaultValue = "" ) Long userId) {
		userServ.deleteById(userId);
		return "redirect:/admin";
	}
	
	
	@PostMapping("/admin/give_admin")
	public String give_right_admin(@RequestParam(required = true, defaultValue = "" ) Long userId) {
		try {
		Long id_of_admin_role_in_db = 2L;
		userServ.give_rights(userId, id_of_admin_role_in_db);
		}
		catch(Exception e) {
			
		}
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/delete_admin")
	public String delete_right_admin(@RequestParam(required = true, defaultValue = "" ) Long userId) {
		try {
		Long id_of_admin_role_in_db = 2L;
		userServ.delete_rights(userId, id_of_admin_role_in_db);
		}
		catch(Exception e) {
			
		}
		return "redirect:/admin";
	}
	
	
	
	@PostMapping("/admin")
	public String find_user(@RequestParam("email") String email, Model model) {
		User user = userServ.findUserByEmail(email);
		
		if(user == null) {
			model.addAttribute("UserNotFoundException","Пользователь не найден");
		}
		else {
			model.addAttribute("Users", user);
		}		
			
		return "Admin/admin_page";
	}
}
