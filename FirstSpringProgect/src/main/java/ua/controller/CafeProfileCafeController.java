package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CafeRequest;
import ua.service.CafeService;

@Controller
@RequestMapping("/profile/cafe")
@SessionAttributes("cafe")
public class CafeProfileCafeController {

	private final CafeService service;

	public CafeProfileCafeController(CafeService service) {
		super();
		this.service = service;
	}
	
	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("cafe", service.findOne(id));
		model.addAttribute("times", service.findAllTimes());
		return "cafe";
	}
	
	@GetMapping
	public String show() {
		return "cafe";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/profile";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cafe") CafeRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile";
	}
}
