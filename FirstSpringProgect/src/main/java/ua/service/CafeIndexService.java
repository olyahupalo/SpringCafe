package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;

public interface CafeIndexService {

	List<CafeIndexView> findAllViews();
	
	List<CafeIndexView> findAllViewsbyLogin(String login);
	
	Page<CafeIndexView> findAll(CafeFilter filter, Pageable pageable);
	
	
}

