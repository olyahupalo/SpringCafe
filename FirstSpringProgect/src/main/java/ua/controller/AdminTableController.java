package ua.controller;

import java.security.Principal;

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

import ua.entity.Table;
import ua.service.CafeService;
import ua.service.TableService;

@Controller
@RequestMapping("/admin/table")
@SessionAttributes("table")
public class AdminTableController {
	
	private final TableService service;
	
	private final CafeService service2;

	@Autowired
	public AdminTableController(TableService service, CafeService service2) {
		super();
		this.service = service;
		this.service2 = service2;
	}
//	public AdminTableController(TableService service) {
//		this.service = service;
//	}
	
	
	@ModelAttribute("table")
	public Table getForm() {
		return new Table();
	}
	

	@GetMapping
	public String show(Model model, Principal principal){
		model.addAttribute("tables", service.findAll());
		model.addAttribute("cafes", service2.findAllViews(principal.getName()));
		return "table";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/table";
	}
	
	@PostMapping
	public String save(@ModelAttribute("table") Table table, SessionStatus status) {
		service.save(table);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, Principal principal) {
		model.addAttribute("table", service.findOne(id));
		return show(model, principal);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/table";
	}

}
