package co.edu.unal.mb.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.mb.client.entity.OfyProfile;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("register")
public interface RegisterService extends RemoteService {
	
	String sendRegisterProfileServer(OfyProfile profile) throws IllegalArgumentException;
}
