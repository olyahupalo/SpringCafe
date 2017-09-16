package ua.controller;

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

import ua.entity.UserComment;
import ua.model.request.CafeRequest;
import ua.service.CafeIndexService;
import ua.service.CafeService;
import ua.service.UserCommentService;
import ua.validation.flag.CafeFlag;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("cafe")
public class CafeController {

	private final CafeService service;
	private final CafeIndexService service2;
	private final UserCommentService commentService;

	public CafeController(CafeService service, CafeIndexService service2, UserCommentService commentService) {
		this.service = service;
		this.service2 = service2;
		this.commentService = commentService;
	}

	@ModelAttribute("cafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@ModelAttribute("comment")
	public UserComment getCommentForm() {
		return new UserComment();
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("cafe", service.findOne(id));
		model.addAttribute("times", service.findAllTimes());
		model.addAttribute("meals", service.findAllMeals());
		model.addAttribute("tables", service.findAllTables());
		model.addAttribute("comments", commentService.findAll());
		return "cafe";
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("allcafes", service2.findAllViews());
		return "allcafes";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/profile";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cafe") @Validated(CafeFlag.class) CafeRequest request, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		service.save(request);
		return cancel(status);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile";
	}
}
