package ua.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueIngredient;
import ua.validation.annotation.UniqueCuisine;
import ua.validation.flag.CafeFlag;
import ua.validation.flag.CuisineFlag;
import ua.validation.flag.IngredientsFlag;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{

	@UniqueCuisine(message="Така кухня вже існує в БД", groups=CuisineFlag.class)
	@UniqueIngredient(message="Такий інгредієнт вже існує в БД", groups=IngredientsFlag.class)
	@NotBlank(message="Це поле має бути заповненим", groups= {CuisineFlag.class, IngredientsFlag.class, CafeFlag.class})
	@Pattern(regexp = "^[A-Z][a-zA-Z0-9]+| *$", message="Назва має починатись з великої букви", groups= {CuisineFlag.class, IngredientsFlag.class, CafeFlag.class})
	private String name;

	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}