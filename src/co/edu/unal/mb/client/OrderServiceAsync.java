package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.unal.mb.client.entity.OfyFrame;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface OrderServiceAsync {
	
	void listAllItemsServer(AsyncCallback<List<OfyFrame>> callback) throws IllegalArgumentException;
}
