package co.edu.unal.mb.server.model.impl.ofy;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import co.edu.unal.mb.shared.model.IOrder;

@Entity
@Index
public class OfyOrder implements IOrder{
	
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
	
	public int getLensesPrice() {
		return lensesprice;
	}
	
	public void setLensesPrice(int lensesprice) {
		this.lensesprice = lensesprice;
	}
	
	@Id 
	private Long id;
	private int frameprice;
	private int lensesprice;

}
