package co.edu.unal.mb.server.dao.impl.sql;

import static co.edu.unal.mb.client.sql.SqlService.getDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.edu.unal.mb.client.dao.IOrderDAO;
import co.edu.unal.mb.client.guice.sql.SqlModelModule;
import co.edu.unal.mb.shared.model.IModelFactory;
import co.edu.unal.mb.shared.model.IOrder;

public class SqlOrderDAO implements IOrderDAO{

	public void save(IOrder order) {
		getDB().execute("INSERT INTO order VALUES ('" + order.getId() + 
				"', '" + order.getFramePrice() + "', '" + order.getLensesPrice() + "')");
	}

	public IOrder fetchById(long id) {
		IOrder order = null;
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM order WHERE id = '" + id);
			if ( rs.next() ) {
				Injector injector = Guice.createInjector( new SqlModelModule() );
				IModelFactory factory = injector.getInstance( IModelFactory.class );
				order = factory.createOrder(Long.parseLong(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)));
			}
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public List<IOrder> fetchAllOrders() {
		ArrayList<IOrder> result = new ArrayList<IOrder>();
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM order");
			Injector injector = Guice.createInjector( new SqlModelModule() );
			IModelFactory factory = injector.getInstance( IModelFactory.class );
			IOrder order = null;
			while ( rs.next() ) {
				order = factory.createOrder(Long.parseLong(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)));
				result.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean isEmpty() {
		boolean empty = true;
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM order");
			if ( rs.next() ) empty = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empty;
	}

}
