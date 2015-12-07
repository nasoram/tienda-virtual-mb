package co.edu.unal.mb.client.dao;

import java.util.List;

import co.edu.unal.mb.shared.model.IProfile;

public interface IProfileDAO {
	
	void save( IProfile profile );
	
	boolean changePassword( IProfile profile, String password );
	
	IProfile fetchByUserName( String username );
	
	List<IProfile> fetchAllProfiles();
	
	boolean isEmpty();
	
}
