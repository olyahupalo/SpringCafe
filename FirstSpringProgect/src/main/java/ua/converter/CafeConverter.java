package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Cafe;
import ua.repository.CafeRepository;

@Component
public class CafeConverter implements Converter<String, Cafe> {
	
	private final CafeRepository repository;

	public CafeConverter(CafeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Cafe convert(String arg0) {
		return repository.findByName(arg0);
	}
}
