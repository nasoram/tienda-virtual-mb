package co.edu.unal.mb.client.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import co.edu.unal.mb.client.AdminService;
import co.edu.unal.mb.client.AdminServiceAsync;
import co.edu.unal.mb.shared.FieldVerifier;
import co.edu.unal.mb.shared.StringHelper;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginForm extends Composite {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final AdminServiceAsync greetingService = GWT.create(AdminService.class);

	private AbsolutePanel absolutePanel;
	
	private TextBox usernameTextBox;
	private PasswordTextBox passwordTextBox;
	
	private Label usernameLabel;
	private Label passwordLabel;
	
	private Button loginButton;
	private Label messagesLabel;
	private AbsolutePanel absPanel;
	private HTMLPanel registerlink;
	
	public LoginForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "256px");
		messagesLabel = new Label();
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		
		usernameTextBox = new TextBox();
		passwordTextBox = new PasswordTextBox();
		
		usernameLabel = new Label("Nombre de usuario:");
		passwordLabel = new Label("Contrasena:");
		
		loginButton = new Button("Iniciar sesion");
		absPanel = new AbsolutePanel();
		
		absPanel.add(usernameLabel, 0, 0);
		absPanel.add(usernameTextBox, 0, 18);
		absPanel.add(passwordLabel, 0, 58);
		absPanel.add(passwordTextBox, 0, 76);
		passwordTextBox.setSize("159px", "16px");
		
		registerlink = new HTMLPanel("<div id='linking'><p>Aun no eres cliente?<BR>Registrate y haz tu pedido!<BR><a href='#'>Haz clic aqui!</a>.</p></div>");
		absPanel.add(registerlink, 246, 34);
		registerlink.setSize("163px", "112px");
		loginButton.addStyleName("btn btn-default");
		absPanel.add(loginButton, 40, 110);
		absolutePanel.add(absPanel, 56, 66);
		absPanel.setSize("438px", "157px");
		
		// Listen for mouse events on the Add button.
	    loginButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        login();
	      }
	    });
	    
	    // Listen for keyboard events in the username box.
	    usernameTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          login();
	        }
	      }
	    });
	    	    
	    // Listen for keyboard events in the password box.
	    passwordTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          login();
	        }
	      }
	    });
	}
	
	//Guardar perfil
	private void login() {
		final String username = usernameTextBox.getText().toUpperCase().trim();
		
		String validationError;
		
		if (!FieldVerifier.isValidUsername(username)) {
			validationError = "'" + username + "' no es un nombre de usuario valido.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		//TODO passwords
		
//		String textToServer = usernameTextBox.getText();
//		
//		greetingService.sendSaveItemServer(textToServer, new AsyncCallback<String>() {
//			
//			String rpcResult;
//			
//			public void onFailure(Throwable caught) {
//				// Show the RPC error message to the user
//				rpcResult = "Remote Procedure Call - Failure\n" + SERVER_ERROR;
//				messagesLabel.setStyleName("messageErrorLabel");
//				messagesLabel.setText(rpcResult);
//				Window.alert(rpcResult);
//			}
//
//			public void onSuccess(String result) {
//				rpcResult = "Remote Procedure Call - SUCCESS\n" + result;
//				messagesLabel.setStyleName("messageSuccessLabel");
//				messagesLabel.setText(rpcResult);
//				Window.alert(rpcResult);
//			}
//		});
		
	}
}
