package co.edu.unal.mb.client.entity;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@SuppressWarnings("serial")
@Entity
public class OfyFrame implements Serializable {
	
	@Id public Long id;
	public int frameprice;
	public String description;
	
	public OfyFrame() {super();}
	
	public OfyFrame(Long id, int frameprice, String description) {
		super();
		this.id = id;
		this.frameprice = frameprice;
		this.description = description;
	}
	
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public int getFramePrice() {
//		return frameprice;
//	}
//	
//	public void setFramePrice(int frameprice) {
//		this.frameprice = frameprice;
//	}
//	
//	public String getDescription() {
//		return description;
//	}
//	
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
}
