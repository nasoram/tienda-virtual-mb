package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.mb.client.entity.Frame;
import co.edu.unal.mb.client.entity.OfyFrame;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("admin")
public interface AdminService extends RemoteService {
	
	String sendSaveItemServer(OfyFrame frame) throws IllegalArgumentException;
	String sendUpdateItemServer(OfyFrame frame) throws IllegalArgumentException;
	List<OfyFrame> listItemsServer() throws IllegalArgumentException;
}
