package ua.controller;


import java.security.Principal;

import javax.sql.rowset.serial.SerialArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.MealRequest;
import ua.service.CafeService;
import ua.service.MealService;

@Controller
@RequestMapping("/profile/meal")
@SessionAttributes("meal")
public class CafeMealController {

	private final MealService service;
	
	private final CafeService service2;
	
	@Autowired
	public CafeMealController(MealService service, CafeService service2) {
		super();
		this.service = service;
		this.service2 = service2;
	}
	
	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}

	@GetMapping
	public String show(Model model, Principal principal) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("cuisines", service.findAllCuisines());
		model.addAttribute("cafes", service2.findAllViews(principal.getName()));
		model.addAttribute("meals", service.findAllViews());
		return "meal";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/profile/meal";
	}
	
	@PostMapping
	public String save(@ModelAttribute("meal") MealRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, Principal principal) {
		model.addAttribute("meal", service.findOne(id));
		return show(model, principal);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile/meal";
	}
}
