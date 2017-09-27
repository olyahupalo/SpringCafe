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

import ua.entity.Cuisine;
import ua.model.request.ReservationTableRequest;
import ua.model.request.UserCommentRequest;
import ua.service.ReservationTableService;

@Controller
@RequestMapping("/tablereservation")
@SessionAttributes("tablereservation")
public class ReservationTableController {
	
	private final ReservationTableService service;
	
	@Autowired
	public ReservationTableController(ReservationTableService service) {
		super();
		this.service = service;
	}
	
	@ModelAttribute("tablereservation")
	public ReservationTableRequest getForm() {
		return new ReservationTableRequest();
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("tables", service.findTablesByCafeId(id));
		return "tablereservation";
	}
	
	@PostMapping
	public String save(@ModelAttribute("tablereservation") ReservationTableRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafe";
	}
	

}
