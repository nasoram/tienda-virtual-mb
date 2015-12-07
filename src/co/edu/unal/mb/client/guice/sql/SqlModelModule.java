package co.edu.unal.mb.client.guice.sql;

import com.google.inject.AbstractModule;

import co.edu.unal.mb.client.dao.IFrameDAO;
import co.edu.unal.mb.client.dao.IOrderDAO;
import co.edu.unal.mb.client.dao.IProfileDAO;
import co.edu.unal.mb.server.dao.impl.sql.SqlFrameDAO;
import co.edu.unal.mb.server.dao.impl.sql.SqlOrderDAO;
import co.edu.unal.mb.server.dao.impl.sql.SqlProfileDAO;
import co.edu.unal.mb.server.model.impl.sql.SqlFrame;
import co.edu.unal.mb.server.model.impl.sql.SqlOrder;
import co.edu.unal.mb.server.model.impl.sql.SqlProfile;
import co.edu.unal.mb.shared.model.IFrame;
import co.edu.unal.mb.shared.model.IOrder;
import co.edu.unal.mb.shared.model.IProfile;

public class SqlModelModule extends AbstractModule{

	@Override
	protected void configure() {
	//Encadena interfaces con las clases que las van a usar
		
		//Frame
		bind( IFrame.class ).to( SqlFrame.class );
		bind( IFrameDAO.class ).to( SqlFrameDAO.class );
//		bind( IFrameModelFactory.class ).to( FrameModelFactoryImpl.class );
		
		//Order
		bind( IOrder.class ).to( SqlOrder.class );
		bind( IOrderDAO.class ).to( SqlOrderDAO.class );
//		bind( IOrderModelFactory.class ).to( OrderModelFactoryImpl.class );
				
		//Profile
		bind( IProfile.class ).to( SqlProfile.class );
		bind( IProfileDAO.class ).to( SqlProfileDAO.class );
//		bind( IProfileModelFactory.class ).to( ProfileModelFactoryImpl.class );
		
	}

}
