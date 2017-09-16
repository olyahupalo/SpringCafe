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

import ua.entity.Cuisine;
import ua.model.filter.SimpleFilter;
import ua.service.CuisineService;
import ua.validation.flag.CuisineFlag;

@Controller
@RequestMapping("/admin/cuisine")
@SessionAttributes("cuisine")
public class AdminCuisineController {

	private final CuisineService service;
	
	@Autowired
	public AdminCuisineController(CuisineService service) {
		this.service = service;
	}
	
	@ModelAttribute("cuisine")
	public Cuisine getForm() {
		return new Cuisine();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("cuisines", service.findAll(pageable, filter));
		if(service.findAll(pageable, filter).hasContent()) return "cuisine";
		else return "redirect:/admin/cuisine"+Params.buildParamsForShow(pageable, filter);
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		service.delete(id);
		return "redirect:/admin/cuisine"+Params.buildParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("cuisine") @Validated(CuisineFlag.class) Cuisine cuisine, SessionStatus status, BindingResult br, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) {
			System.out.println("HAS ERRORS");
			return show(model, pageable, filter);
		}
		service.save(cuisine);
		return cancel(status, pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("cuisine", service.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		status.setComplete();
		return "redirect:/admin/cuisine"+Params.buildParams(pageable, filter);
	}
	

}