package co.edu.unal.mb.client.entity;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@SuppressWarnings("serial")
@Entity
public class OfyProfile implements Serializable {
	
	@Id public String username;
	public String name;
	public int id;
	public String email;
	public String contact;
	public String password;
	
	public OfyProfile() {}
	
	public OfyProfile(String username, String name, int id, String email, String contact, String password) {
		super();
		this.username = username;
		this.name = name;
		this.id = id;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getContact() {
//		return contact;
//	}
//
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//	
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
}
