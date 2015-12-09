package co.edu.unal.mb.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.LoadResult;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import co.edu.unal.mb.client.RegisterService;
import co.edu.unal.mb.client.entity.OfyOrder;
import co.edu.unal.mb.client.entity.OfyProfile;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RegisterServiceImpl extends RemoteServiceServlet implements RegisterService {
	
	Objectify ofy;
	
	@Override
	public void init( ServletConfig sc )
	{
		try
		{
			super.init( sc );
			
			ObjectifyService.register( OfyProfile.class );
			ObjectifyService.register( OfyOrder.class );
			ObjectifyService.register( OfyProfile.class );
			ofy = ObjectifyService.factory().begin();
		}
		catch ( ServletException e )
		{
			e.printStackTrace();
		}
	}

	public String sendRegisterProfileServer(OfyProfile profile) throws IllegalArgumentException {
		Key<OfyProfile> stored = storeOfyFrame(profile);
		String result;
		
		if (stored == null) result = "FAILED";
		else result = "STORED";
		
		return result;
		
	}
	
	public String sendUpdateItemServer(OfyProfile profile) throws IllegalArgumentException {
		OfyProfile loaded = loadOfyProfile( profile.username);
		String result;
		
		if (loaded == null) result = "USER NOT FOUND";
		else result = sendRegisterProfileServer(profile);
		
		return result;
		
	}
	
	protected Key<OfyProfile> storeOfyFrame(OfyProfile profile) {
		return ofy.save().entity( profile ).now();
	}

	protected OfyProfile loadOfyProfile( String username ) {
		LoadResult<OfyProfile> r = ofy.load().type( OfyProfile.class ).id( username );
		return r.now();
	}

	protected static OfyProfile createOfyProfile( String username, String name, int id, String email, String contact, String password ) {
		OfyProfile profile = new OfyProfile();
		profile.username = username;
		profile.name = name;
		profile.id = id;
		profile.email = email;
		profile.contact = contact;
		profile.password = password;
		return profile;
	}

}
