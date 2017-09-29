package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Order;
import ua.entity.Meal;
import ua.entity.Status;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.repository.OrderRepository;
import ua.service.OrderService;
@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Integer> implements OrderService{
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository, OrderRepository orderRepository) {
		super(repository);
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Meal> findAllMealsByCafeId(Integer id) {
		return orderRepository.findAllMealsByCafeId(id);
	}

	@Override
	public List<Table> findAllTablesByCafeId(Integer id) {
		return orderRepository.findAllTablesByCafeId(id);
	}

	@Override
	public void save(OrderRequest request) {
		Order order = new Order();
		order.setStatus(Status.valueOf(request.getStatus()));
		order.setTable(request.getTable());
		order.setMeals(request.getMeals());
		orderRepository.save(order);
	}
	
	@Override
	public OrderRequest findOneRequest(Integer id) {
		Order order = orderRepository.findOneRequest(id);
		OrderRequest request = new OrderRequest();
		request.setStatus(order.getStatus().toString());
		request.setMeals(order.getMeals());
		request.setTable(order.getTable());
		return request;
	}

	@Override
	public Integer cafeId(Integer id) {
		return id;
	}

	

	
}
