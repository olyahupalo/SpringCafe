package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Ingredient;
import ua.model.filter.SimpleFilter;
import ua.service.IngredientService;
import ua.validation.flag.IngredientsFlag;

@Controller
@RequestMapping("/admin/ingredient")
@SessionAttributes("ingredient")
public class AdminIngredientController {
	
	private final IngredientService service;
	
	@Autowired
	public AdminIngredientController(IngredientService service) {
		this.service = service;
	}
	
	@ModelAttribute("ingredient")
	public Ingredient getForm() {
		return new Ingredient();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("ingredients", service.findAll(pageable, filter));
		if((service.findAll(pageable, filter).hasContent())||(pageable.getPageNumber()==0)) return "ingredient";
		else return "redirect:/admin/ingredient"+Params.buildParamsForShow(pageable, filter);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		service.delete(id);
		return "redirect:/admin/ingredient"+Params.buildParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("ingredient") @Validated(IngredientsFlag.class) Ingredient ingredient, BindingResult br, SessionStatus status, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors())return show(model, pageable, filter);
		service.save(ingredient);
		return cancel(status, pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("ingredient", service.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/ingredient"+Params.buildParams(pageable, filter);
	}
	
}
