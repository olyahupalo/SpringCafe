package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Meal;
import ua.entity.Order;
import ua.entity.Table;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("SELECT m FROM Meal m JOIN m.cafe c WHERE c.id=?1")
	List<Meal> findAllMealsByCafeId(Integer id);
	
	@Query("SELECT t FROM Table t JOIN t.cafe c WHERE c.id=?1 AND t.isFree = false")
	List<Table> findAllTablesByCafeId(Integer id);
	
	@Query("SELECT m.title FROM Meal m JOIN m.orders o WHERE o.id=?1")
	List<String> findAllMealsByOrderId(Integer id);
	
	@Query("SELECT DISTINCT o FROM Order o JOIN FETCH o.table LEFT JOIN FETCH o.meals WHERE o.id=?1")
	Order findOneRequest(Integer id);
	
}
