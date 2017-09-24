package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.repository.CafeRepository;
import ua.validation.annotation.UniqueCafe;

public class CafeValidator  implements ConstraintValidator<UniqueCafe, String>{

	private final CafeRepository repository;
	
	public CafeValidator(CafeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueCafe constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		return !repository.existsByName(value);
	}

}
