package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import ua.entity.Type;;

public class CafeFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^\\s*[0-9]{1,10}\\s*$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");

	private String name = "";
	
	private String minRate = "";
	
	private String maxRate = "";
	
	private List<Type> types = new ArrayList<>();
	
	private String minOpen = "";
	
	private String maxOpen = "";
	
	private String minClsoe = "";
	
	private String maxClose = "";
	
	private String minCount = "";
	
	private String maxCount  = "";
	
	private List<Integer> mealsIds  = new ArrayList<>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		if(DECIMAL_PATTERN.matcher(minRate).matches())
		this.minRate = minRate;
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		if(DECIMAL_PATTERN.matcher(maxRate).matches())
		this.maxRate = maxRate;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public String getMinOpen() {
		return minOpen;
	}

	public void setMinOpen(String minOpen) {
		this.minOpen = minOpen;
	}

	public String getMaxOpen() {
		return maxOpen;
	}

	public void setMaxOpen(String maxOpen) {
		this.maxOpen = maxOpen;
	}

	public String getMinClsoe() {
		return minClsoe;
	}

	public void setMinClsoe(String minClsoe) {
		this.minClsoe = minClsoe;
	}

	public String getMaxClose() {
		return maxClose;
	}

	public void setMaxClose(String maxClose) {
		this.maxClose = maxClose;
	}

	public String getMinCount() {
		return minCount;
	}

	public void setMinCount(String minCount) {
		System.out.println(INT_PATTERN.matcher(minCount).matches());
		if(INT_PATTERN.matcher(minCount).matches())
		this.minCount = minCount;
	}

	public String getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(String maxCount) {
		if(INT_PATTERN.matcher(maxCount).matches())
		this.maxCount = maxCount;
	}

	public List<Integer> getMealsIds() {
		return mealsIds;
	}

	public void setMealsIds(List<Integer> mealsIds) {
		this.mealsIds = mealsIds;
	}
	
	
	
	
	

}
