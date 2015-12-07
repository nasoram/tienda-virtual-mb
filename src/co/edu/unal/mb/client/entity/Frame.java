package co.edu.unal.mb.client.entity;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Frame implements Serializable{
	
	public Frame(){}
	
	public Frame(Long id, int frameprice, String description) {
		super();
		this.id = id;
		this.frameprice = frameprice;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getFramePrice() {
		return frameprice;
	}
	
	public void setFramePrice(int frameprice) {
		this.frameprice = frameprice;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id;
	@Persistent
	int frameprice;
	@Persistent
	String description;
	
}
