package co.edu.unal.mb.server.dao.impl.sql;

import static co.edu.unal.mb.client.sql.SqlService.getDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.edu.unal.mb.client.dao.IProfileDAO;
import co.edu.unal.mb.client.guice.sql.SqlModelModule;
import co.edu.unal.mb.shared.model.IModelFactory;
import co.edu.unal.mb.shared.model.IProfile;

public class SqlProfileDAO implements IProfileDAO{

	public void save(IProfile profile) {
		getDB().execute("INSERT INTO profile VALUES ('" + profile.getUsername() + 
				"', '" + profile.getName() + "', '" + profile.getId() + "', '" + profile.getEmail() + 
				"', '" + profile.getContact() + "', '" + profile.getPassword() + "')");
	}
	
	public boolean changePassword(IProfile profile, String password) {
		int res = getDB().execute("UPDATE profile SET password='" + password +"' WHERE username='" + profile.getUsername());
		return res != -1;
	}

	public IProfile fetchByUserName(String username) {
		IProfile profile = null;
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM profile WHERE username = '" + username);
			if ( rs.next() ) {
				Injector injector = Guice.createInjector( new SqlModelModule() );
				IModelFactory factory = injector.getInstance( IModelFactory.class );
				profile = factory.createProfile(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), 
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
			return profile;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profile;
	}

	public List<IProfile> fetchAllProfiles() {
		ArrayList<IProfile> result = new ArrayList<IProfile>();
		ResultSet rs;
		try {
			rs = getDB().query("SELECT * FROM profile");
			Injector injector = Guice.createInjector( new SqlModelModule() );
			IModelFactory factory = injector.getInstance( IModelFactory.class );
			IProfile profile = null;
			while ( rs.next() ) {
				profile = factory.createProfile(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), 
						rs.getString(4), rs.getString(5), rs.getString(6));
				result.add(profile);
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
			rs = getDB().query("SELECT * FROM profile");
			if ( rs.next() ) empty = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empty;
	}

}
