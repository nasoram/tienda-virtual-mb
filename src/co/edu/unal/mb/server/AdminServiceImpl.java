package co.edu.unal.mb.server;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.LoadResult;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.edu.unal.mb.client.AdminService;
import co.edu.unal.mb.client.entity.OfyFrame;
import co.edu.unal.mb.client.entity.OfyOrder;
import co.edu.unal.mb.client.entity.OfyProfile;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AdminServiceImpl extends RemoteServiceServlet implements AdminService {
	
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

	public String sendSaveItemServer(OfyFrame frame) throws IllegalArgumentException {
		Key<OfyFrame> stored = storeOfyFrame(frame);
		String result;
		
		if (stored == null) result = "FAILED";
		else result = "STORED";
		
		return result;
		
	}
	
	public String sendUpdateItemServer(OfyFrame frame) throws IllegalArgumentException {
		OfyFrame loaded = loadOfyFrame( frame.id );
		String result;
		
		if (loaded == null) result = "ID NOT FOUND";
		else result = sendSaveItemServer(frame);
		
		return result;
		
	}
	
	public List<OfyFrame> listItemsServer() throws IllegalArgumentException {
		return ofy.load().type(OfyFrame.class).list();
	}
	
	protected Key<OfyFrame> storeOfyFrame(OfyFrame frame) {
		return ofy.save().entity( frame ).now();
	}

	protected OfyFrame loadOfyFrame( Long id ) {
		LoadResult<OfyFrame> r = ofy.load().type( OfyFrame.class ).id( id );
		return r.now();
	}

	protected static OfyFrame createOfyFrame( Long id, int frameprice, String description ) {
		OfyFrame frame = new OfyFrame();
		frame.id = id;
		frame.frameprice = frameprice;
		frame.description = description;
		return frame;
	}

}
