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
import ua.service.CafeService;



@Controller
@RequestMapping("/profile")
@SessionAttributes("profile")
public class ProfileController {

	private final CafeIndexService service;
	
	private final CafeService service2;

	
	public ProfileController(CafeIndexService service, CafeService service2) {
		super();
		this.service = service;
		this.service2 = service2;
	}

	@ModelAttribute("profile")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping
	public String show(Model model, Principal principal) {
		model.addAttribute("cafes", service.findAllViewsbyLogin(principal.getName()));
//		model.addAttribute("cafes", service.findAllViews());
		return "profile";
	}
	
//	@GetMapping("/cafe/{id}")
//	public String showOne(@PathVariable Integer id, Model model, Principal principal) {
//		model.addAttribute("cafe", service2.findOne(id));
//		return show(model, principal);
//	}
	
}
