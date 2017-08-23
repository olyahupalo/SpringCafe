package ua.service;

import java.util.List;

import ua.entity.Cafe;
import ua.model.view.CafeView;

public interface CafeService{

	List<CafeView> findAllViews();

	void save(Cafe cafe);
	
	void delete(Integer id);
	
	}
