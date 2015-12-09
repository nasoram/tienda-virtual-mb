package co.edu.unal.mb.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.unal.mb.client.entity.OfyProfile;

public interface RegisterServiceAsync {
	
	void sendRegisterProfileServer(OfyProfile profile, AsyncCallback<String> callback) throws IllegalArgumentException;
}
