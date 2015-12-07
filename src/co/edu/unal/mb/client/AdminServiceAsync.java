package co.edu.unal.mb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.unal.mb.client.entity.Frame;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AdminServiceAsync {
	
	void sendSaveItemServer(Frame frame, AsyncCallback<String> callback) throws IllegalArgumentException;
	void sendUpdateItemServer(Frame frame, AsyncCallback<String> callback) throws IllegalArgumentException;
	void listItemsServer(AsyncCallback<List<Frame>> callback) throws IllegalArgumentException;
}
