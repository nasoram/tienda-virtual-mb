package co.edu.unal.mb.server;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.edu.unal.mb.client.OrderService;
import co.edu.unal.mb.client.entity.OfyFrame;
import co.edu.unal.mb.client.entity.OfyOrder;
import co.edu.unal.mb.client.entity.OfyProfile;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class OrderServiceImpl extends RemoteServiceServlet implements OrderService {
	
	Objectify ofy;
	
	@Override
	public void init( ServletConfig sc )
	{
		try
		{
			super.init( sc );
			
			ObjectifyService.register( OfyFrame.class );
			ObjectifyService.register( OfyOrder.class );
			ObjectifyService.register( OfyProfile.class );
			ofy = ObjectifyService.factory().begin();
		}
		catch ( ServletException e )
		{
			e.printStackTrace();
		}
	}

	public List<OfyFrame> listAllItemsServer() throws IllegalArgumentException {
		return ObjectifyService.ofy().load().type(OfyFrame.class).list();
	}
}
