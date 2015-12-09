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
public class ProfileForm extends Composite {
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
	private TextBox nameTextBox;
	private TextBox idTextBox;
	private TextBox emailTextBox;
	private TextBox contactTextBox;
	private PasswordTextBox passwordTextBox;
	private PasswordTextBox newPasswordTextBox;
	private PasswordTextBox confirmPasswordTextBox;
	
	private Label usernameLabel;
	private Label nameLabel;
	private Label idLabel;
	private Label emailLabel;
	private Label contactLabel;
	private Label passwordLabel;
	private Label newPasswordLabel;
	private Label confirmPasswordLabel;
	
	private Button saveButton;
	private Label messagesLabel;
	private AbsolutePanel absPanel;
	private HTMLPanel titlePanel;
	
	public ProfileForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "432px");
		messagesLabel = new Label();
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		messagesLabel.setStyleName("messageInfoLabel");
		messagesLabel.setText("Modifica tus datos personales");
		
		titlePanel = new HTMLPanel("<div id='paneltitle'>Mi perfil</div>");
		absolutePanel.add(titlePanel, 218, 66);
		
		usernameTextBox = new TextBox();
		nameTextBox = new TextBox();
		idTextBox = new TextBox();
		emailTextBox = new TextBox();
		contactTextBox = new TextBox();
		passwordTextBox = new PasswordTextBox();
		newPasswordTextBox = new PasswordTextBox();
		confirmPasswordTextBox = new PasswordTextBox();
		
		usernameLabel = new Label("Nombre de usuario:");
		nameLabel = new Label("Nombre:");
		idLabel = new Label("Identificacion:");
		emailLabel = new Label("Correo electronico:");
		contactLabel = new Label("Numero de contacto:");
		passwordLabel = new Label("Contrasena:");
		newPasswordLabel = new Label("Nueva contrasena");
		confirmPasswordLabel = new Label("Confirme nueva contrasena:");
		
		saveButton = new Button("Guardar cambios");
		absPanel = new AbsolutePanel();
		
		absPanel.add(usernameLabel, 0, 0);
		absPanel.add(usernameTextBox, 0, 18);
		absPanel.add(nameLabel, 0, 57);
		absPanel.add(nameTextBox, 0, 75);
		absPanel.add(idLabel, 0, 115);
		absPanel.add(idTextBox, 0, 133);
		absPanel.add(emailLabel, 0, 167);
		absPanel.add(emailTextBox, 0, 185);
		absPanel.add(contactLabel, 0, 219);
		absPanel.add(contactTextBox, 0, 237);
		absPanel.add(passwordLabel, 249, 0);
		absPanel.add(passwordTextBox, 249, 18);
		absPanel.add(newPasswordLabel, 249, 50);
		absPanel.add(newPasswordTextBox, 249, 68);
		absPanel.add(confirmPasswordLabel, 249, 100);
		absPanel.add(confirmPasswordTextBox, 249, 118);
		saveButton.addStyleName("btn btn-default");
		absPanel.add(saveButton, 270, 167);
		absolutePanel.add(absPanel, 56, 116);
		absPanel.setSize("438px", "280px");
		
		// Listen for mouse events on the Add button.
	    saveButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        saveProfile();
	      }
	    });
	    
	    	    // Listen for keyboard events in the username box.
	    	    usernameTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the name box.
	    	    nameTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the id box.
	    	    idTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the email box.
	    	    emailTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the contact box.
	    	    contactTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the password box.
	    	    passwordTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	    	    
	 // Listen for keyboard events in the confirm password box.
	    	    confirmPasswordTextBox.addKeyDownHandler(new KeyDownHandler() {
	    	      public void onKeyDown(KeyDownEvent event) {
	    	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	    	          saveProfile();
	    	        }
	    	      }
	    	    });
	}
	
	//Guardar perfil
	private void saveProfile() {
		final String username = usernameTextBox.getText().toUpperCase().trim();
		final String name = nameTextBox.getText().toUpperCase().trim();
		final String id = idTextBox.getText().toUpperCase().trim();
		
		//TODO passwords
		
		String validationError;
		
		if (!FieldVerifier.isValidUsername(username)) {
			validationError = "'" + username + "' no es un nombre de usuario valido.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		if (!FieldVerifier.isValidName(name)) {
			validationError = "'" + name + "' no es un nombre valido.";
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
		
		//TODO passwords
		
		String textToServer = StringHelper.assembleProfile(
				usernameTextBox.getText(),
				nameTextBox.getText(),
				idTextBox.getText(),
				emailTextBox.getText(),
				contactTextBox.getText(),
				passwordTextBox.getText());
		
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
