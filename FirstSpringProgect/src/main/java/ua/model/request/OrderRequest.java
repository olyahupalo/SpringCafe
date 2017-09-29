package ua.model.request;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Meal;

public class OrderRequest {
	
	private Integer id;
	
	private List<Meal> meals = new ArrayList<>();
	
	private ua.entity.Table table;
	
	private String status = "ACCEPTED";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public ua.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.entity.Table table) {
		this.table = table;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
