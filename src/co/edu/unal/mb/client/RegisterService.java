package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.mb.client.entity.Frame;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("admin")
public interface RegisterService extends RemoteService {
	
	String sendSaveItemServer(Frame frame) throws IllegalArgumentException;
	String sendUpdateItemServer(Frame frame) throws IllegalArgumentException;
	List<Frame> listItemsServer() throws IllegalArgumentException;
}
