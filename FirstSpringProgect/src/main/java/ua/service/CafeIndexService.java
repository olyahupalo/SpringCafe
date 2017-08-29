package ua.service;

import java.util.List;

import ua.model.view.CafeIndexView;

public interface CafeIndexService {

	List<CafeIndexView> findAllViews();
	
}
