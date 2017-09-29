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

import ua.model.request.OrderRequest;
import ua.service.OrderService;

@Controller
@RequestMapping("/cafe/{id}/order")
@SessionAttributes("order")
public class OrderController {

	private final OrderService service;

	public OrderController(OrderService service) {
		super();
		this.service = service;
	}
	
	@ModelAttribute("order")
	public OrderRequest getForm() {
		return new OrderRequest();
	}
	
	@GetMapping
	public String showOrder(@PathVariable Integer id, Model model) {
		model.addAttribute("meals", service.findAllMealsByCafeId(id));
		model.addAttribute("tables", service.findAllTablesByCafeId(id));
		model.addAttribute("orders", service.findAll());
		model.addAttribute("cafeId", service.cafeId(id));
		return "order";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/cafe/{id}/order";
	}
	
	@PostMapping
	public String save(@ModelAttribute("order") OrderRequest request, Model model, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	


	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafe/{id}/order";
	}
	
	
	
}
