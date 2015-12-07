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
public class RecoveryForm extends Composite {
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
	private TextBox idTextBox;
	private TextBox emailTextBox;
	
	private Label usernameLabel;
	private Label idLabel;
	private Label emailLabel;
	
	private Button saveButton;
	private Label messagesLabel;
	private AbsolutePanel absPanel;
	private HTMLPanel titlePanel;
	
	public RecoveryForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "321px");
		messagesLabel = new Label();
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		
		titlePanel = new HTMLPanel("<div id='paneltitle'>Recuperacion de<BR>Contrasena</div>");
		absolutePanel.add(titlePanel, 151, 66);
		
		usernameTextBox = new TextBox();
		idTextBox = new TextBox();
		emailTextBox = new TextBox();
		
		usernameLabel = new Label("Nombre de usuario:");
		idLabel = new Label("Identificacion:");
		emailLabel = new Label("Correo electronico:");
		
		saveButton = new Button("Registrarse");
		saveButton.setText("Recuperar");
		absPanel = new AbsolutePanel();
		
		absPanel.add(usernameLabel, 0, 0);
		absPanel.add(usernameTextBox, 0, 18);
		absPanel.add(idLabel, 0, 58);
		absPanel.add(idTextBox, 0, 76);
		absPanel.add(emailLabel, 235, 0);
		absPanel.add(emailTextBox, 235, 18);
		saveButton.addStyleName("btn btn-default");
		absPanel.add(saveButton, 281, 76);
		absolutePanel.add(absPanel, 56, 160);
		absPanel.setSize("438px", "128px");
		
		// Listen for mouse events on the Add button.
	    saveButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        sendRecovery();
	      }
	    });
	    
	    // Listen for keyboard events in the username box.
	    usernameTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          sendRecovery();
	        }
	      }
	    });
	    	    
	    // Listen for keyboard events in the id box.
	    idTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          sendRecovery();
	        }
	      }
	    });
	    	    
	    // Listen for keyboard events in the email box.
	    emailTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          sendRecovery();
	        }
	      }
	    });
	}
	
	//Guardar perfil
	private void sendRecovery() {
		final String username = usernameTextBox.getText().toUpperCase().trim();
		final String id = idTextBox.getText().toUpperCase().trim();
		final String email = emailTextBox.getText();
		
		String validationError;
		
		if (!FieldVerifier.isValidUsername(username)) {
			validationError = "'" + username + "' no es un nombre de usuario valido.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		if (!FieldVerifier.isValidId(id)) {
			validationError = "'" + id + "' no es una identificacion valida.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		if (!FieldVerifier.isValidEmail(email)) {
			validationError = "'" + email + "' no es una dirección de correo valida.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		String textToServer = usernameTextBox.getText() + idTextBox.getText() + emailTextBox.getText();
		
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
