package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;
import ua.service.OpenCloseService;
@Service
public class OpenCloseServiceImpl extends CrudServiceImpl<OpenClose, Integer> implements OpenCloseService{
	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository repository) {
		super(repository);
	}

}
