package co.edu.unal.mb.client.dao;

import java.util.List;

import co.edu.unal.mb.shared.model.IOrder;

public interface IOrderDAO {
	
	void save( IOrder order );
	
	IOrder fetchById( long id );
	
	List<IOrder> fetchAllOrders();
	
	boolean isEmpty();
	
}
