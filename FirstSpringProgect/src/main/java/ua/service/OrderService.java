package ua.service;

import java.util.List;

import ua.entity.Order;
import ua.entity.Meal;
import ua.entity.Table;
import ua.model.request.OrderRequest;

public interface OrderService extends CrudService<Order, Integer>{
	
	List<Meal> findAllMealsByCafeId(Integer id);
	
	List<Table> findAllTablesByCafeId(Integer id);
	
	OrderRequest findOneRequest(Integer id);
	
	void save(OrderRequest request);
	
	Integer cafeId(Integer id);
	
}
