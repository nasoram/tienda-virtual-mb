package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.mb.client.entity.OfyFrame;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("order")
public interface OrderService extends RemoteService {
	
	List<OfyFrame> listAllItemsServer() throws IllegalArgumentException;
}
