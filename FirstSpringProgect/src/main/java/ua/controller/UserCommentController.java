package ua.controller;

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
import ua.entity.UserComment;
import ua.model.request.UserCommentRequest;
import ua.service.UserCommentService;

@Controller
@RequestMapping("/comment")
@SessionAttributes("comment")
public class UserCommentController {

	private final UserCommentService service;
	private  Integer cafeId;
	
	@ModelAttribute("comment")
	public UserCommentRequest getForm() {
		return new UserCommentRequest();
	}
	
	@Autowired
	public UserCommentController(UserCommentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model){
		cafeId = id;
		System.out.println(cafeId+" "+ id);
		return "comment";
	}
	
	@PostMapping
	public String save(@ModelAttribute("comment") UserCommentRequest request, SessionStatus status) {
		service.save(request, cafeId);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafe";
	}
	
}
