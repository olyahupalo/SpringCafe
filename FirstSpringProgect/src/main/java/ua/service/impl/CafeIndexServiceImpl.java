package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.model.view.CafeIndexView;
import ua.repository.CafeIndexRepository;
import ua.service.CafeIndexService;

@Service
public class CafeIndexServiceImpl implements CafeIndexService{

	private final CafeIndexRepository repository;
	
	public CafeIndexServiceImpl(CafeIndexRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<CafeIndexView> findAllViews() {
		return repository.findAllViews();
	}

}
