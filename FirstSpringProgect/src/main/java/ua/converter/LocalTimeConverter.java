package ua.converter;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalTimeConverter implements Converter<String, LocalTime>{

	@Override
	public LocalTime convert(String arg0) {
		try {
			return LocalTime.parse(arg0);
		} catch (Exception e) {
			return null;
		}

		
	}

}
