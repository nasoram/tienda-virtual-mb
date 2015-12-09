package co.edu.unal.mb.client.entity;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@SuppressWarnings("serial")
@Entity
@Index
public class OfyOrder implements Serializable{
	
	@Id public Long id;
	public int frameprice;
	public int lensesprice;
	
//	public OfyOrder() {}
//
//	public OfyOrder(Long id, int frameprice, int lensesprice) {
//		super();
//		this.id = id;
//		this.frameprice = frameprice;
//		this.lensesprice = lensesprice;
//	}
//
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
//	public int getLensesPrice() {
//		return lensesprice;
//	}
//	
//	public void setLensesPrice(int lensesprice) {
//		this.lensesprice = lensesprice;
//	}
	
}
