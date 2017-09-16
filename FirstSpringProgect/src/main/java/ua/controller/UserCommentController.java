package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Table;
import ua.entity.UserComment;
import ua.service.UserCommentService;

@Controller
@RequestMapping("/comment")
@SessionAttributes("comment")
public class UserCommentController {

	private final UserCommentService service;
	
	@ModelAttribute("comment")
	public UserComment getForm() {
		return new UserComment();
	}
	
	@Autowired
	public UserCommentController(UserCommentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model){
		return "comment";
	}
	
	@PostMapping
	public String save(@ModelAttribute("comment") UserComment comment, SessionStatus status) {
		service.save(comment);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafe";
	}
	
}
