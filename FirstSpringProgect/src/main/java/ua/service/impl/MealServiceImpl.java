package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Meal;
import ua.model.filter.MealFilter;
import ua.model.request.MealRequest;
import ua.model.view.MealView;
import ua.repository.MealFilterRepository;
import ua.repository.MealRepository;
import ua.service.MealService;

@Service
public class MealServiceImpl implements MealService{

	private final MealRepository repository;
	
	private final MealFilterRepository filterRepository;

	public MealServiceImpl(MealRepository repository, MealFilterRepository filterRepository) {
		super();
		this.repository = repository;
		this.filterRepository = filterRepository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}
	
	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafes();
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllViews() {
		List<MealView> views = repository.findAllViews();
		views.forEach(this::loadIngredients);
		return views;
	}
	
	private void loadIngredients(MealView view) {
		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void save(MealRequest request) {
		Meal meal = new Meal();
		meal.setCuisine(request.getCuisine());
		meal.setCafe(request.getCafe());
		meal.setDescription(request.getDescription());
		meal.setId(request.getId());
		meal.setIngredients(request.getIngredients());
		meal.setPhotoUrl(request.getPhotoUrl());
		meal.setPrice(new BigDecimal(request.getPrice()));
		meal.setTitle(request.getTitle());
		meal.setVersion(request.getVersion());
		meal.setWeight(Integer.valueOf(request.getWeight()));
		repository.save(meal);
	}

	@Override
	public MealRequest findOne(Integer id) {
		Meal meal = repository.findOneRequest(id);
		MealRequest request = new MealRequest();
		request.setCuisine(meal.getCuisine());
		request.setCafe(meal.getCafe());
		request.setDescription(meal.getDescription());
		request.setId(meal.getId());
		request.setIngredients(meal.getIngredients());
		request.setPhotoUrl(meal.getPhotoUrl());
		request.setPrice(String.valueOf(meal.getPrice()));
		request.setTitle(meal.getTitle());
		request.setVersion(meal.getVersion());
		request.setWeight(String.valueOf(meal.getWeight()));
		request.setCafeId(meal.getCafe().getId());
		return request;
	}

	@Override
	public Page<MealView> findAll(MealFilter filter, Pageable pageable) {
		return filterRepository.findAll(filter, pageable);
	}

	@Override
	public List<Integer> findAllCuisinesIds() {
		return repository.findAllCuisinesIds();
	}

	@Override
	public List<Integer> findAllCafesIds() {
		return repository.findAllCuisinesIds();
	}

	@Override
	public List<Integer> findAllIngredientsIds() {
		return repository.findAllIngredientsIds();
	}

}
