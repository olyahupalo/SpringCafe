package ua.model.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import ua.entity.Meal;
import ua.entity.OpenClose;
import ua.entity.Table;
import ua.entity.User;
import ua.validation.annotation.UniqueCafe;
import ua.validation.flag.CafeFlag;
import ua.validation.flag.CuisineFlag;
import ua.validation.flag.IngredientsFlag;

public class CafeRequest {

	private Integer id;
	
	private String rate;
	
	@NotBlank(message="Це поле має бути заповненим")
	@Pattern(regexp = "^[A-Z][a-zA-Z0-9]+| *$", message="Назва має починатись з великої букви")
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	@NotBlank(message="Це поле має бути заповненим")
	private String address;
	
	@NotBlank(message="Це поле має бути заповненим")
	private String fullDescription;
	
	@NotBlank(message="Це поле має бути заповненим")
	private String shortDescription;
	
	@NotBlank(message="Це поле має бути заповненим")
	private String type;
	
	@NotBlank(message="Це поле має бути заповненим")
	@Pattern(regexp = "[0-9]{13}", message="This field must have 13 numers!")
	private String phone;
	
	@NotBlank(message="Це поле має бути заповненим")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message="Wrong email")
	private String email;
	
	private OpenClose open;
	
	private OpenClose close;
	
	private User user;
	
	private MultipartFile file;
	
	private List<Meal> meals =  new ArrayList<>(); 
	
	private List<Table> tables =  new ArrayList<>(); 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OpenClose getOpen() {
		return open;
	}

	public void setOpen(OpenClose open) {
		this.open = open;
	}

	public OpenClose getClose() {
		return close;
	}

	public void setClose(OpenClose close) {
		this.close = close;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	
	
}
