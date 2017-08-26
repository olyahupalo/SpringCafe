package ua.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;

@Component
public class OpenCloseConverter implements Converter<String, OpenClose>{

	private final OpenCloseRepository repository;

	public OpenCloseConverter(OpenCloseRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public OpenClose convert(String arg0) {
		return repository.findByTime(LocalTime.parse(arg0));
	}
	
	
}
