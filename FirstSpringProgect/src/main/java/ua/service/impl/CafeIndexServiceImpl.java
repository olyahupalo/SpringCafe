package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.repository.CafeIndexRepository;
import ua.repository.CafeFilterRepositoty;
import ua.service.CafeIndexService;

@Service
public class CafeIndexServiceImpl implements CafeIndexService{

	private final CafeIndexRepository repository;
	
	private final CafeFilterRepositoty filterRepository;

	public CafeIndexServiceImpl(CafeIndexRepository repository, CafeFilterRepositoty filterRepository) {
		super();
		this.repository = repository;
		this.filterRepository = filterRepository;
	}

	@Override
	public List<CafeIndexView> findAllViews() {
		return repository.findAllViews();
	}

	@Override
	public List<CafeIndexView> findAllViewsbyLogin(String login) {
		return repository.findAllViewsbyLogin(login);
	}

	@Override
	public Page<CafeIndexView> findAll(CafeFilter filter, Pageable pageable) {
		return filterRepository.findAll(filter, pageable);
	}

}
