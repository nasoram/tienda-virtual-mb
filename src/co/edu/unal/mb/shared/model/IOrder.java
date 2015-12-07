package co.edu.unal.mb.shared.model;

public interface IOrder {
	
	Long getId();
	void setId( Long id );
	
	int getFramePrice();
	void setFramePrice( int frameprice );

	int getLensesPrice();
	void setLensesPrice( int lensesprice );

}
