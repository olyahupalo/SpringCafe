package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("message", "Hallo");
		return "index";
	}
	
	@GetMapping("/admin")
	public String index(){
		return "admin";
	}
	
}
