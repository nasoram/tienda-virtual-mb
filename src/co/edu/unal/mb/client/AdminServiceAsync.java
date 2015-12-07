package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.unal.mb.client.entity.Frame;
import co.edu.unal.mb.client.entity.OfyFrame;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AdminServiceAsync {
	
	void sendSaveItemServer(OfyFrame frame, AsyncCallback<String> callback) throws IllegalArgumentException;
	void sendUpdateItemServer(OfyFrame frame, AsyncCallback<String> callback) throws IllegalArgumentException;
	void listItemsServer(AsyncCallback<List<OfyFrame>> callback) throws IllegalArgumentException;
}
