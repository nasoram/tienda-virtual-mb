package co.edu.unal.mb.server.model.impl.sql;

import co.edu.unal.mb.shared.model.IFrame;

public class SqlFrame implements IFrame{
	
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
	
	private Long id;
	private int frameprice;
	private String description;
	
}
