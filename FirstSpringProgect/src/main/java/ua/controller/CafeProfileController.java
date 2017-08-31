package ua.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.model.request.CafeRequest;
import ua.service.CafeIndexService;



@Controller
@RequestMapping("/profile")
@SessionAttributes("profile")
public class CafeProfileController {

	private final CafeIndexService service;

	public CafeProfileController(CafeIndexService service) {
		super();
		this.service = service;
	}
	
	@ModelAttribute("profile")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping
	public String show(Model model, Principal principal) {
		model.addAttribute("cafes", service.findAllViewsbyLogin(principal.getName()));
		return "profile";
	}
	
	
	
}
