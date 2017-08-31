package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CafeRequest;
import ua.service.CafeService;

@Controller
@RequestMapping("/profile/createcafe")
@SessionAttributes("createcafe")
public class CafeCreateCafeConrtoller {
	
	private final CafeService service;
	
	@Autowired
	public CafeCreateCafeConrtoller(CafeService service) {
		super();
		this.service = service;
	}

	@ModelAttribute("createcafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("times", service.findAllTimes());
		return "createcafe";
	}
	
	@PostMapping
	public String save(@ModelAttribute("createcafe") CafeRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile/createcafe";
	}
}
