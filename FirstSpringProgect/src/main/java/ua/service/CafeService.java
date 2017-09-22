package ua.service;

import java.util.List;

import ua.model.view.CafeView;
import ua.model.request.CafeRequest;
import ua.model.request.FileRequest;

public interface CafeService{
	
	List<String> findAllTimes();
	
	List<String> findAllMeals();
	
	List<Integer> findAllTables();

//	List<CafeView> findAllViews();
	List<CafeView> findAllViews(String email);

	void save(CafeRequest request, FileRequest fileRequest);
	
	void delete(Integer id);
	
	CafeRequest findOne(Integer id);
	
	}
