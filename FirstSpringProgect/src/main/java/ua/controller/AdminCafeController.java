package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CafeService;

@Controller
@RequestMapping("/admin/cafe")
public class AdminCafeController {
	
	private final CafeService service;

	@Autowired
	public AdminCafeController(CafeService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("cafes", service.findAllViews());
		return "cafe";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/cafe";
	}
	
	

}
