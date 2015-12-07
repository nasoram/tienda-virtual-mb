package co.edu.unal.mb.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MB2 implements EntryPoint {

	public void onModuleLoad() {
		Menu menu = new Menu();
		
		RootPanel.get("wmenu").add(menu);
	}
}