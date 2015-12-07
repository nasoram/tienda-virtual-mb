package co.edu.unal.mb.server.dao.impl.ofy;

import static co.edu.unal.mb.service.ofy.OfyService.ofy;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import co.edu.unal.mb.client.dao.IOrderDAO;
import co.edu.unal.mb.server.model.impl.ofy.OfyOrder;
import co.edu.unal.mb.shared.model.IOrder;

public class OfyOrderDAO implements IOrderDAO{

	public void save( final IOrder order ) {
		ofy().save().entity( order ).now();
	}

	public IOrder fetchById( final long id ) {
		Key<OfyOrder> key = Key.create( OfyOrder.class, id );
		return ofy().load().key( key ).now();
	}

	public List<IOrder> fetchAllOrders() {
		Query<OfyOrder> q = ofy().load().type( OfyOrder.class );
		return new LinkedList<IOrder>( q.list() );
	}

	public boolean isEmpty() {
		Query<OfyOrder> q = ofy().load().type( OfyOrder.class );
		return q.limit( 1 ).list().isEmpty();
	}

}
