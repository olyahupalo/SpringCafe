package ua.controller;

import javax.validation.Valid;

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

import ua.entity.OpenClose;
import ua.service.OpenCloseService;
import ua.validation.flag.OpenCloseFlag;

@Controller
@RequestMapping("/admin/openclose")
@SessionAttributes("openclose")
public class AdminOpenCloseController {

	private final OpenCloseService service;

	public AdminOpenCloseController(OpenCloseService service) {
		super();
		this.service = service;
	}
	
	@ModelAttribute("openclose")
	public OpenClose getForm() {
		return new OpenClose();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("opencloses", service.findAll());
		return "openclose";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/openclose";
	}
	
	@PostMapping
	public String save(@ModelAttribute("openclose") @Validated(OpenCloseFlag.class) OpenClose openclose, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors())return show(model);
		service.save(openclose);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("openclose", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/openclose";
	}
	
}
