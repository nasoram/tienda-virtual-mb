package co.edu.unal.mb.client.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import co.edu.unal.mb.client.AdminService;
import co.edu.unal.mb.client.AdminServiceAsync;
import co.edu.unal.mb.client.RX;
import co.edu.unal.mb.shared.FieldVerifier;
import co.edu.unal.mb.shared.StringHelper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OrderForm extends Composite {
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

	private TextBox orderIdTextBox;
	private TextBox nameTextBox;
	
	private Label orderIdLabel;
	private Label nameLabel;
	private Label frameLabel;
	private Label lensesLabel;
	private Label filtersLabel;
	
	private ListBox frames;
	private RadioButton farview;
    private RadioButton closeview;
    private CheckBox multifocal;
    private RadioButton bifocal;
    private RadioButton progressive;
    private CheckBox polycarbonate;
    private CheckBox trivex;
    private RadioButton uv;
    private RadioButton transitions;
    private RadioButton ar;
    private RadioButton futurex;
	private Button saveButton;
	private Label messagesLabel;
	private VerticalPanel vertPanel;
	private HorizontalPanel lensesPanel;
	private VerticalPanel lensesRXPanel;
	private VerticalPanel lensesFiltersPanel;
	private VerticalPanel specsPanel;
	private HorizontalPanel orderNoPanel;
	private HTMLPanel titlePanel;
	
	public OrderForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "460px");
		messagesLabel = new Label();
		
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		titlePanel = new HTMLPanel("<div id='paneltitle'>Realizar pedido</div>");
		absolutePanel.add(titlePanel, 162, 66);

		orderIdTextBox = new TextBox();
		nameTextBox = new TextBox();
		
		orderIdLabel = new Label("Recibo:");
		nameLabel = new Label("Nombre Cliente:");
		frameLabel = new Label("Montura:");
		lensesLabel = new Label("Lentes:");
		filtersLabel = new Label("Tratamientos:");
		
		frames = new ListBox();
		farview = new RadioButton("vision", "Vision de Lejos");
	    closeview = new RadioButton("vision", "Vision de cerca");
	    multifocal = new CheckBox("Multifocal");
	    bifocal = new RadioButton("multifocal", "Bifocal");
	    progressive = new RadioButton("multifocal", "Progresivo");
	    polycarbonate = new CheckBox("Policarbonato");
	    trivex = new CheckBox("Trivex");
	    uv = new RadioButton("uvprotect", "UV");
	    transitions = new RadioButton("uvprotect", "Transitions");
	    ar = new RadioButton("film", "AR");
	    futurex = new RadioButton("film", "Futurex");
		saveButton = new Button("Pedir");
		vertPanel = new VerticalPanel();
		lensesPanel = new HorizontalPanel();
		lensesRXPanel = new VerticalPanel();
		lensesFiltersPanel = new VerticalPanel();
		specsPanel = new VerticalPanel();
		orderNoPanel = new HorizontalPanel();
		
		vertPanel.add(specsPanel);
		specsPanel.add(orderNoPanel);
		orderNoPanel.setWidth("332px");
		orderNoPanel.add(orderIdLabel);
		orderNoPanel.add(orderIdTextBox);
		orderNoPanel.setCellHorizontalAlignment(orderIdTextBox, HasHorizontalAlignment.ALIGN_RIGHT);
		
		HorizontalPanel namePanel = new HorizontalPanel();
		specsPanel.add(namePanel);
		namePanel.setWidth("331px");
		namePanel.add(nameLabel);
		namePanel.add(nameTextBox);
		namePanel.setCellHorizontalAlignment(nameTextBox, HasHorizontalAlignment.ALIGN_RIGHT);
		nameTextBox.setWidth("216px");
		
		HorizontalPanel framePanel = new HorizontalPanel();
		specsPanel.add(framePanel);
		framePanel.setWidth("332px");
		framePanel.add(frameLabel);
		framePanel.add(frames);
		framePanel.setCellHorizontalAlignment(frames, HasHorizontalAlignment.ALIGN_RIGHT);
		frames.setVisibleItemCount(1);
		
		createDummyFrames();
		
		farview.setChecked(true);
		bifocal.setEnabled(false);
    	progressive.setEnabled(false);
		multifocal.setValue(false);
		lensesRXPanel.setSpacing(10);
		lensesRXPanel.add(lensesLabel);
		lensesRXPanel.setCellHorizontalAlignment(lensesLabel, HasHorizontalAlignment.ALIGN_CENTER);
		lensesLabel.setWidth("52px");
		lensesRXPanel.add(multifocal);
		
		// Hook up a handler to find out when it's clicked.
	    multifocal.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        if(!((CheckBox) event.getSource()).getValue()){
	        	bifocal.setEnabled(false);
	        	progressive.setEnabled(false);
	        	farview.setEnabled(true);
	        	closeview.setEnabled(true);
	        } else {
	        	farview.setEnabled(false);
	        	closeview.setEnabled(false);
	        	bifocal.setEnabled(true);
	        	progressive.setEnabled(true);
	        }
	      }
	    });
		lensesRXPanel.add(farview);
	    lensesRXPanel.add(closeview);
	    lensesRXPanel.add(bifocal);
	    lensesRXPanel.add(progressive);
	    
		lensesPanel.add(lensesRXPanel);
		lensesFiltersPanel.setSpacing(10);
		lensesFiltersPanel.setBorderWidth(0);
		
		//tratamientos
		lensesFiltersPanel.add(filtersLabel);
		lensesFiltersPanel.setCellHorizontalAlignment(filtersLabel, HasHorizontalAlignment.ALIGN_CENTER);
		lensesFiltersPanel.add(polycarbonate);
		lensesFiltersPanel.add(uv);
		lensesFiltersPanel.add(transitions);
		lensesFiltersPanel.add(ar);
		lensesFiltersPanel.add(futurex);
		lensesFiltersPanel.add(trivex);
		
		lensesPanel.add(lensesFiltersPanel);
		lensesPanel.setCellHorizontalAlignment(lensesFiltersPanel, HasHorizontalAlignment.ALIGN_RIGHT);
		lensesFiltersPanel.setWidth("139px");
		
		vertPanel.add(lensesPanel);
		lensesPanel.setWidth("332px");
	    
		
		// Listen for mouse events on the Add button.
	    saveButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        createOrder();
	      }
	    });
	    absolutePanel.add(vertPanel, 88, 116);
	    absolutePanel.add(saveButton, 426, 205);
	    
	}
	
	//Guardar perfil
	private void createOrder() {
		final String name = nameTextBox.getText().toUpperCase().trim();
		final String orderid = orderIdTextBox.getText().toUpperCase().trim();
		final String selectedframe = frames.getItemText(frames.getSelectedIndex());
		final RX formula = new RX(farview, closeview, bifocal, progressive, polycarbonate, uv, ar, trivex, futurex, transitions);
		final int lensesprice = formula.calculateLensesPrice();
		
		//TODO passwords
		
		String validationError;
		
		if (!FieldVerifier.isValidName(name)) {
			validationError = "'" + name + "' no es un nombre valido.";
			messagesLabel.setStyleName("messageWarningLabel");
//			messagesLabel.getElement().setInnerHTML(validationError);
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		if (!FieldVerifier.isValidOrderId(orderid)) {
			validationError = "'" + orderid + "' no es una identificacion valida.";
			messagesLabel.setStyleName("messageWarningLabel");
			messagesLabel.setText(validationError);
			Window.alert(validationError);
			return;
		}
		
		String textToServer = StringHelper.assembleOrder(
				nameTextBox.getText(),
				orderIdTextBox.getText(),
				selectedframe,
				lensesprice);
		
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
	
	public void createDummyFrames() {
		frames.addItem("RayBan");
	    frames.addItem("Police");
	    frames.addItem("Ginebra");
	    frames.addItem("Gabbiana");
	    frames.addItem("Fazio");
	    frames.addItem("Miraflex");
	}
}
