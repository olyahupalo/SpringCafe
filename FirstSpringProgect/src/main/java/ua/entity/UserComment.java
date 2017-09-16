package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="_userComment")
public class UserComment extends AbstractEntity{

	private String commentTxt;
	
	private String email;

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
