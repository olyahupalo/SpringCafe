package ua.model.filter;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.List;

public class MealFilter {
	private static final Pattern INT_PATTERN = Pattern.compile("^\\s*[0-9]{1,10}\\s*$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");

	private String title = "";
	
	private String minPrice = "";
	
	private String maxPrice = "";
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private List<Integer> cuisinesIds = new ArrayList<>();
	
	private List<Integer> ingredientsIds = new ArrayList<>();
	
	private List<Integer> cafesIds = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.maxWeight = maxWeight;
	}

	public List<Integer> getCuisinesIds() {
		return cuisinesIds;
	}

	public void setCuisinesIds(List<Integer> cuisinesIds) {
		this.cuisinesIds = cuisinesIds;
	}

	public List<Integer> getIngredientsIds() {
		return ingredientsIds;
	}

	public void setIngredientsIds(List<Integer> ingredientsIds) {
		this.ingredientsIds = ingredientsIds;
	}

	public List<Integer> getCafesIds() {
		return cafesIds;
	}

	public void setCafesIds(List<Integer> cafesIds) {
		this.cafesIds = cafesIds;
	}



	
	
	
	

}
