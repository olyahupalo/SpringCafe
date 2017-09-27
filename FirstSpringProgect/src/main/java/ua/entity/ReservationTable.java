package ua.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservationTable")
public class ReservationTable extends AbstractEntity{

	private String email;
	
	private String Name;
	
	private String phone;
	
	private LocalDateTime time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ua.entity.Table table;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
