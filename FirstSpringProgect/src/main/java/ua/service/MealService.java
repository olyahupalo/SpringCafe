package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.MealFilter;
import ua.model.request.MealRequest;
import ua.model.view.MealView;

public interface MealService {

	List<String> findAllCuisines();
	
	List<String> findAllCafes();
	
	List<String> findAllIngredients();
	
	List<Integer> findAllCuisinesIds();
	
	List<Integer> findAllCafesIds();
	
	List<Integer> findAllIngredientsIds();
	
	List<MealView> findAllViews();
	
	void save(MealRequest request);
	
	MealRequest findOne(Integer id);
	
	void delete(Integer id);
	
	Page<MealView> findAll(MealFilter filter, Pageable pageable);
}