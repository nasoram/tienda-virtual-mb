package co.edu.unal.mb.shared.model;

public interface IProfile {
	
	String getUsername();
	void setUsername( String username );
	
	String getName();
	void setName( String name );

	int getId();
	void setId( int id );
	
	String getEmail();
	void setEmail( String email );
	
	String getContact();
	void setContact( String contact );
	
	String getPassword();
	void setPassword( String password );

}
