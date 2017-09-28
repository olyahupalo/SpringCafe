package ua.validation.validator;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.OpenCloseRepository;
import ua.validation.annotation.UniqueOpenClose;

@Component
public class OpenCloseValidator implements ConstraintValidator<UniqueOpenClose, LocalTime>{

	private final OpenCloseRepository repository;
	
	
	public OpenCloseValidator(OpenCloseRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public void initialize(UniqueOpenClose arg0) {
		
	}


	@Override
	public boolean isValid(LocalTime arg0, ConstraintValidatorContext arg1) {
		return repository.findByTime(arg0)==null;
	}

}
