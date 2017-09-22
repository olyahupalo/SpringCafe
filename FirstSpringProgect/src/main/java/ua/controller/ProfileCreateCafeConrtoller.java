package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CafeRequest;
import ua.model.request.FileRequest;
import ua.service.CafeService;
import ua.validation.flag.CafeFlag;

@Controller
@RequestMapping("/profile/createcafe")
@SessionAttributes("createcafe")
public class ProfileCreateCafeConrtoller {
	
	private final CafeService service;
	
	@Autowired
	public ProfileCreateCafeConrtoller(CafeService service) {
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
	public String save(@ModelAttribute("createcafe") @Validated(CafeFlag.class) CafeRequest request, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile/createcafe";
	}
}
