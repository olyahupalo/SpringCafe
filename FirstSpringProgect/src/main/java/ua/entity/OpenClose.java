package ua.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import ua.validation.flag.CuisineFlag;
import ua.validation.flag.IngredientsFlag;
import ua.validation.flag.OpenCloseFlag;

@Entity
@Table(name="open_close")
public class OpenClose extends AbstractEntity{

	@OneToMany(mappedBy="open")
	private List<Cafe> openedCafes = new ArrayList<>();
	
	@OneToMany(mappedBy="close")
	private List<Cafe> closedCafes = new ArrayList<>();
	
	//@Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]", message="Невірний формат часу", groups= {OpenCloseFlag.class})
	@NotNull(message="Невірний формат часу")
	private LocalTime time;
	
	public OpenClose(LocalTime time) {
		this.time = time;
	}

	public OpenClose() {
	}

	public List<Cafe> getOpenedCafes() {
		return openedCafes;
	}

	public void setOpenedCafes(List<Cafe> openedCafes) {
		this.openedCafes = openedCafes;
	}

	public List<Cafe> getClosedCafes() {
		return closedCafes;
	}

	public void setClosedCafes(List<Cafe> closedCafes) {
		this.closedCafes = closedCafes;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
}
