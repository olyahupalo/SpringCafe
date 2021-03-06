package ua.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="userComment")
public class UserComment extends AbstractEntity{

	private String commentTxt;
	
	private String email;
	
	private LocalDateTime time;
	
	private Integer cafeId;
	
	private Integer replyId;
	
	

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getCafeId() {
		return cafeId;
	}

	public void setCafeId(Integer cafeId) {
		this.cafeId = cafeId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getCommentTxt() {
		return commentTxt;
	}

	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
