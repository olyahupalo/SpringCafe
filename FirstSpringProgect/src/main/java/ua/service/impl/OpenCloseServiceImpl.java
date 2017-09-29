package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;
import ua.repository.OpenCloseRepository;
import ua.service.OpenCloseService;
@Service
public class OpenCloseServiceImpl extends CrudServiceImpl<OpenClose, Integer> implements OpenCloseService{
	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository repository) {
		super(repository);
	}

	@Override
	public Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
