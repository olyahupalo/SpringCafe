package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.OpenClose;
import ua.model.filter.SimpleFilter;

public interface OpenCloseService extends CrudService<OpenClose, Integer>{

	Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter);
	
}
