package co.edu.unal.mb.server.dao.impl.sql;

import static co.edu.unal.mb.client.sql.SqlService.getDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.edu.unal.mb.client.dao.IFrameDAO;
import co.edu.unal.mb.client.guice.sql.SqlModelModule;
import co.edu.unal.mb.shared.model.IFrame;
import co.edu.unal.mb.shared.model.IModelFactory;

public class SqlFrameDAO implements IFrameDAO{

	public void save(IFrame frame) {
		getDB().execute("INSERT INTO frame VALUES ('" + frame.getId() + 
				"', '" + frame.getFramePrice() + "', '" + frame.getDescription() + "')");
	}

	public IFrame fetchById(long id) {
		IFrame frame = null;
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM frame WHERE id = '" + id);
			if ( rs.next() ) {
				Injector injector = Guice.createInjector( new SqlModelModule() );
				IModelFactory factory = injector.getInstance( IModelFactory.class );
				frame = factory.createFrame(Long.parseLong(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(3));
			}
			return frame;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frame;
	}
	
	public List<IFrame> fetchAllFrames() {
		ArrayList<IFrame> result = new ArrayList<IFrame>();
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM frame");
			Injector injector = Guice.createInjector( new SqlModelModule() );
			IModelFactory factory = injector.getInstance( IModelFactory.class );
			IFrame frame = null;
			while ( rs.next() ) {
				frame = factory.createFrame(Long.parseLong(rs.getString(1)), Integer.parseInt(rs.getString(2)), rs.getString(3));
				result.add(frame);
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
			rs = getDB().query("SELECT * FROM frame");
			if ( rs.next() ) empty = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empty;
	}

}
