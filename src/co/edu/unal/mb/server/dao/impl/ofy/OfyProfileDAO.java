package co.edu.unal.mb.server.dao.impl.ofy;

import static co.edu.unal.mb.service.ofy.OfyService.ofy;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import co.edu.unal.mb.client.dao.IProfileDAO;
import co.edu.unal.mb.server.model.impl.ofy.OfyProfile;
import co.edu.unal.mb.shared.model.IProfile;

public class OfyProfileDAO implements IProfileDAO{

	public void save( final IProfile profile ) {
		ofy().save().entity( profile ).now();
	}

	public IProfile fetchByUserName( final String username ) {
		Key<OfyProfile> key = Key.create( OfyProfile.class, username );
		return ofy().load().key( key ).now();
	}

	public List<IProfile> fetchAllProfiles() {
		Query<OfyProfile> q = ofy().load().type( OfyProfile.class );
		return new LinkedList<IProfile>( q.list() );
	}

	public boolean isEmpty() {
		Query<OfyProfile> q = ofy().load().type( OfyProfile.class );
		return q.limit( 1 ).list().isEmpty();
	}

	public boolean changePassword(IProfile profile, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
