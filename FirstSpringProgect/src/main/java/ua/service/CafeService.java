package ua.service;

import java.util.List;

import ua.model.view.CafeView;
import ua.model.request.CafeRequest;

public interface CafeService{
	
	List<String> findAllTimes();

	List<CafeView> findAllViews();

	void save(CafeRequest request);
	
	void delete(Integer id);
	
	CafeRequest findOne(Integer id);
	
	}
