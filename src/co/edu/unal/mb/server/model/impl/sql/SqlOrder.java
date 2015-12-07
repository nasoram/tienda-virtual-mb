package co.edu.unal.mb.server.model.impl.sql;

import co.edu.unal.mb.shared.model.IOrder;

public class SqlOrder implements IOrder{

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
	
	private Long id;
	private int frameprice;
	private int lensesprice;
	
}
