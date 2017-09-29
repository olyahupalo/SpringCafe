package ua.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.filter.MealFilter;
import ua.model.request.MealRequest;
import ua.service.CafeService;
import ua.service.MealService;

@Controller
@RequestMapping("/meal")
@SessionAttributes("meal")
public class MealController {

	private final MealService service;
	
	private final CafeService service2;
	
	@Autowired
	public MealController(MealService service, CafeService service2) {
		super();
		this.service = service;
		this.service2 = service2;
	}
	
	@ModelAttribute("meal")
	public MealRequest getForm() {
		return new MealRequest();
	}
	
	@ModelAttribute("mealFilter")
	public MealFilter getFilter() {
		return new MealFilter();
	}

	@GetMapping
	public String show(Model model, Principal principal, @ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("cuisines", service.findAllCuisines());
		if(principal!=null) model.addAttribute("cafes", service2.findAllViews(principal.getName()));
		model.addAttribute("meals", service.findAll(filter, pageable));
		return "meal";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/meal";
	}
	
	@PostMapping
	public String save(@ModelAttribute("meal") @Valid MealRequest request, BindingResult br, Model model, Principal principal, SessionStatus status, @ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		if(br.hasErrors()) return show(model, principal, filter, pageable);
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, Principal principal, @ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("meal", service.findOne(id));
		return show(model, principal, filter, pageable);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/meal";
	}
}
