package co.edu.unal.mb.server.dao.impl.ofy;

import static co.edu.unal.mb.service.ofy.OfyService.ofy;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import co.edu.unal.mb.client.dao.IFrameDAO;
import co.edu.unal.mb.server.model.impl.ofy.OfyFrame;
import co.edu.unal.mb.shared.model.IFrame;

//@Singleton
public class OfyFrameDAO implements IFrameDAO{

	public void save( final IFrame frame ) {
		ofy().save().entity( frame ).now();
	}
	
	public IFrame fetchById( final long id ) {
		Key<OfyFrame> key = Key.create( OfyFrame.class, id );
		return ofy().load().key( key ).now();
	}

	public List<IFrame> fetchAllFrames() {
		Query<OfyFrame> q = ofy().load().type( OfyFrame.class );
		return new LinkedList<IFrame>( q.list() );
	}

	public boolean isEmpty() {
		Query<OfyFrame> q = ofy().load().type( OfyFrame.class );
		return q.limit( 1 ).list().isEmpty();
	}

}
