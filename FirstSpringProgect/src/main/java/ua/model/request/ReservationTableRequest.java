package ua.model.request;

import java.time.LocalDateTime;

public class ReservationTableRequest {
	
	private Integer id;
	
	private String email;
	
	private String name;
	
	private String phone;
	
	private LocalDateTime time;
	
	private ua.entity.Table table;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public ua.entity.Table getTable() {
		return table;
	}

	public void setTable(ua.entity.Table table) {
		this.table = table;
	}
	
	
}
