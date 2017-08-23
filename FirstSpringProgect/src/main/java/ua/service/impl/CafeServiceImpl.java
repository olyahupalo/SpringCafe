package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Cafe;
import ua.entity.Meal;
import ua.entity.Table;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	private final CafeRepository repository;

	public CafeServiceImpl(CafeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<CafeView> findAllViews() {
		return repository.findAllViews();
	}

	@Override
	public void save(Cafe cafe) {
		repository.save(cafe);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	


	
	
}