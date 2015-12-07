package co.edu.unal.mb.client.guice.ofy;

import com.google.inject.AbstractModule;

import co.edu.unal.mb.client.dao.IFrameDAO;
import co.edu.unal.mb.client.dao.IOrderDAO;
import co.edu.unal.mb.client.dao.IProfileDAO;
import co.edu.unal.mb.server.dao.impl.ofy.OfyFrameDAO;
import co.edu.unal.mb.server.dao.impl.ofy.OfyOrderDAO;
import co.edu.unal.mb.server.dao.impl.ofy.OfyProfileDAO;
import co.edu.unal.mb.server.model.impl.ofy.OfyFrame;
import co.edu.unal.mb.server.model.impl.ofy.OfyOrder;
import co.edu.unal.mb.server.model.impl.ofy.OfyProfile;
import co.edu.unal.mb.shared.model.IFrame;
import co.edu.unal.mb.shared.model.IOrder;
import co.edu.unal.mb.shared.model.IProfile;

public class OfyModelModule extends AbstractModule{

	@Override
	protected void configure() {
	//Encadena interfaces con las clases que las van a usar
		
		//Frame
		bind( IFrame.class ).to( OfyFrame.class );
		bind( IFrameDAO.class ).to( OfyFrameDAO.class );
//		bind( IFrameModelFactory.class ).to( FrameModelFactoryImpl.class );
		
		//Order
		bind( IOrder.class ).to( OfyOrder.class );
		bind( IOrderDAO.class ).to( OfyOrderDAO.class );
//		bind( IOrderModelFactory.class ).to( OrderModelFactoryImpl.class );
				
		//Profile
		bind( IProfile.class ).to( OfyProfile.class );
		bind( IProfileDAO.class ).to( OfyProfileDAO.class );
//		bind( IProfileModelFactory.class ).to( ProfileModelFactoryImpl.class );
		
	}

}
