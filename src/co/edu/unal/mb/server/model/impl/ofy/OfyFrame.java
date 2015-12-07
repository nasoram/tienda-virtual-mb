package co.edu.unal.mb.server.model.impl.ofy;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import co.edu.unal.mb.shared.model.IFrame;

@Entity
public class OfyFrame implements IFrame{
	
	public OfyFrame(Long id, int frameprice, String description) {
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
	
	@Id 
	private Long id;
	private int frameprice;
	private String description;
	
}
