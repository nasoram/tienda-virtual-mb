package co.edu.unal.mb.server;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.edu.unal.mb.client.AdminService;
import co.edu.unal.mb.client.entity.Frame;
import co.edu.unal.mb.client.entity.FrameEndpoint;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AdminServiceImpl extends RemoteServiceServlet implements AdminService {
	
	FrameEndpoint frameep = new FrameEndpoint();
	
//	public void init( ServletConfig sc )
//	{
//		try
//		{
//			super.init( sc );
//			
//			ObjectifyService.register( Frame.class );
//			Objectify ofy = ObjectifyService.factory().begin();
//		}
//		catch ( ServletException e )
//		{
//			e.printStackTrace();
//		}
//	}

	public String sendSaveItemServer(Frame frame) throws IllegalArgumentException {
		
		frameep.insertFrame(frame);
		return frameep.toString();
	}
	
	public String sendUpdateItemServer(Frame frame) throws IllegalArgumentException {
	
		frameep.updateFrame(frame);
		return frameep.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<Frame> listItemsServer() throws IllegalArgumentException {
		
		return (List<Frame>) frameep.listFrame(null, null);
	}

}
