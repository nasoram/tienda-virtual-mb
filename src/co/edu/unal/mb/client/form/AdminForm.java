package co.edu.unal.mb.client.form;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import co.edu.unal.mb.client.AdminService;
import co.edu.unal.mb.client.AdminServiceAsync;
import co.edu.unal.mb.client.entity.Frame;
import co.edu.unal.mb.client.entity.OfyFrame;
import co.edu.unal.mb.shared.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AdminForm extends Composite {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private AdminServiceAsync adminService = GWT.create(AdminService.class);
	
	private AbsolutePanel absolutePanel;

	private TextBox priceTextBox;
	private TextBox newIdTextBox;
	private TextBox newPriceTextBox;
	private TextArea itemDescTextArea;
	private TextArea textArea;
	
	private Label priceFrameLabel;
	private Label descFrameLabel;
	private Label idFrameLabel;
	private Label lblAgregar;
	private Label lblId;
	private Label lblPrecio;
	private Label lblDescripcion;
	
	private ListBox frames;
	private Button updateButton;
	private Button btnAgregar;
	private Label messagesLabel;
	private VerticalPanel itemPanel;
	private VerticalPanel specsPanel;
	private HorizontalPanel orderNoPanel;
	private HorizontalPanel namePanel;
	private HorizontalPanel framePanel;
	private AbsolutePanel newItemPanel;
	private HTMLPanel titlePanel;
	
	public AdminForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "440px");
		messagesLabel = new Label();
		
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		titlePanel = new HTMLPanel("<div id='paneltitle'>Edicion de<BR>items</div>");
		absolutePanel.add(titlePanel, 199, 66);

		priceTextBox = new TextBox();
		itemDescTextArea = new TextArea();
		
		priceFrameLabel = new Label("Precio:");
		descFrameLabel = new Label("Descripcion:");
		updateButton = new Button("Pedir");
		updateButton.setText("Guardar");
		itemPanel = new VerticalPanel();
		specsPanel = new VerticalPanel();
		orderNoPanel = new HorizontalPanel();
		
		itemPanel.add(specsPanel);
		idFrameLabel = new Label("Id:");
		
		frames = new ListBox();
		
		framePanel = new HorizontalPanel();
		specsPanel.add(framePanel);
		framePanel.setWidth("332px");
		framePanel.add(idFrameLabel);
		framePanel.add(frames);
		framePanel.setCellHorizontalAlignment(frames, HasHorizontalAlignment.ALIGN_RIGHT);
		frames.setVisibleItemCount(1);
		specsPanel.add(orderNoPanel);
		orderNoPanel.setWidth("332px");
		orderNoPanel.add(priceFrameLabel);
		orderNoPanel.add(priceTextBox);
		orderNoPanel.setCellHorizontalAlignment(priceTextBox, HasHorizontalAlignment.ALIGN_RIGHT);
		
		namePanel = new HorizontalPanel();
		specsPanel.add(namePanel);
		namePanel.setWidth("331px");
		namePanel.add(descFrameLabel);
		namePanel.add(itemDescTextArea);
		namePanel.setCellHorizontalAlignment(itemDescTextArea, HasHorizontalAlignment.ALIGN_RIGHT);
		itemDescTextArea.setWidth("216px");
		
		createDummyFrames();
//		fillFramesList();
	    
		// Listen for mouse events on the Add button.
	    updateButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        saveItem();
	      }
	    });
	    
	    absolutePanel.add(itemPanel, 10, 160);
	    itemPanel.setSize("337px", "114px");
	    absolutePanel.add(updateButton, 405, 217);
	    
	    newItemPanel = new AbsolutePanel();
	    absolutePanel.add(newItemPanel, 10, 280);
	    newItemPanel.setSize("431px", "123px");
	    
	    lblAgregar = new Label("Agregar");
	    newItemPanel.add(lblAgregar, 0, 0);
	    
	    newIdTextBox = new TextBox();
	    newItemPanel.add(newIdTextBox, 32, 24);
	    
	    lblId = new Label("Id:");
	    newItemPanel.add(lblId, 0, 24);
	    
	    lblPrecio = new Label("Precio:");
	    newItemPanel.add(lblPrecio, 211, 24);
	    
	    newPriceTextBox = new TextBox();
	    newItemPanel.add(newPriceTextBox, 258, 24);
	    
	    lblDescripcion = new Label("Descripcion:");
	    newItemPanel.add(lblDescripcion, 10, 64);
	    
	    textArea = new TextArea();
	    newItemPanel.add(textArea, 88, 64);
	    textArea.setSize("317px", "36px");
	    
	    btnAgregar = new Button("Agregar");
	    
	 // Listen for mouse events on the Add button.
	    btnAgregar.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        createItem();
	      }
	    });
	    
	    absolutePanel.add(btnAgregar, 447, 320);
	    
	    Button btnActualizar = new Button("Actualizar");
	 // Listen for mouse events on the Add button.
	    btnActualizar.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        fillFramesList();
	      }
	    });
	    absolutePanel.add(btnActualizar, 353, 160);
	    
	}
	
	//Crear item
	private void createItem() {
		
		final Long newId = Long.parseLong(newIdTextBox.getText());
		final int newPrice = Integer.parseInt(newPriceTextBox.getText());
		final String newDesc = textArea.getText();
		
		if (newId == 0 || newId == null || newPrice == 0 || newDesc == "" || newDesc == null) {
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText("Todos los campos son requeridos.");
			Window.alert("Todos los campos son requeridos.");
			return;
		}
		
		OfyFrame frame = new OfyFrame(newId, newPrice, newDesc);
		
		adminService.sendSaveItemServer(frame, new AsyncCallback<String>() {
			
			String rpcResult;
			
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				rpcResult = "Remote Procedure Call - Failure\n" + SERVER_ERROR;
				messagesLabel.setStyleName("messageErrorLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
			}

			public void onSuccess(String result) {
				rpcResult = "Remote Procedure Call - SUCCESS\n" + result;
				messagesLabel.setStyleName("messageSuccessLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
			}
		});
		
	}
	
	//Guardar item
	private void saveItem() {
		
		OfyFrame frame = new OfyFrame(Long.parseLong(priceTextBox.getText()), Integer.parseInt(newPriceTextBox.getText()), frames.getItemText(frames.getSelectedIndex()));
		
		adminService.sendUpdateItemServer(frame, new AsyncCallback<String>() {
			
			String rpcResult;
			
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				rpcResult = "Remote Procedure Call - Failure\n" + SERVER_ERROR;
				messagesLabel.setStyleName("messageErrorLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
			}

			public void onSuccess(String result) {
				rpcResult = "Remote Procedure Call - SUCCESS\n" + result;
				messagesLabel.setStyleName("messageSuccessLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
			}
		});
		
	}
	
	public void createDummyFrames() {
		frames.addItem("RayBan");
	    frames.addItem("Police");
	    frames.addItem("Ginebra");
	    frames.addItem("Gabbiana");
	    frames.addItem("Fazio");
	    frames.addItem("Miraflex");
	}
	
	public void fillFramesList() {
		adminService.listItemsServer(new AsyncCallback<List<OfyFrame>>() {
			
			String rpcResult;

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				rpcResult = "Remote Procedure Call - Failure\n" + SERVER_ERROR;
				messagesLabel.setStyleName("messageErrorLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
				
			}

			public void onSuccess(List<OfyFrame> result) {
				rpcResult = "Remote Procedure Call - SUCCESS\n";
				messagesLabel.setStyleName("messageSuccessLabel");
				messagesLabel.setText(rpcResult);
				Window.alert(rpcResult);
				
				frames.clear();
				
				for (int i = 0; i < result.size(); i++) {
					frames.addItem(result.get(i).getDescription());
				}
				
			}
		});
	}
}
