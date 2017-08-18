package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name="_table")
public class Table extends AbstractEntity{

	public Table() {
	}
	
	public Table(int countOfPeople, boolean isFree) {
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
	}
	
	private int countOfPeople;
	
	private boolean isFree;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
}
