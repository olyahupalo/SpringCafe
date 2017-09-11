package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Meal;
import ua.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer>{

	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();
	
	@Query("SELECT c.name FROM Cafe c")
	List<String> findAllCafes();
	
	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();
	
	@Query("SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight, cafe.name, cafe.id) FROM Meal m JOIN m.cuisine c JOIN m.cafe cafe")
	List<MealView> findAllViews();
	
	@Query(value = "SELECT new ua.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight, cafe.name, cafe.id) FROM Meal m JOIN m.cuisine c JOIN m.cafe cafe",
			countQuery = "SELECT count(m.id) FROM Meal m JOIN m.cuisine c JOIN m.cafe cafe")
	Page<MealView> findAllViews(Pageable pageable);
	
	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m WHERE m.id=?1")
	List<String> findAllIngredientsByMealId(Integer id);
	
	@Query("SELECT DISTINCT m FROM Meal m JOIN FETCH m.cuisine LEFT JOIN FETCH m.ingredients WHERE m.id=?1")
	Meal findOneRequest(Integer id);
}
