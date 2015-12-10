package co.edu.unal.mb.client.form;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Homepage extends Composite {

//	private AdminServiceAsync adminService = GWT.create(AdminService.class);
	
	private AbsolutePanel absolutePanel;
	private HTMLPanel catalogImg;
	private HTMLPanel orderImg;
	private HTMLPanel profileImg;
	private HTMLPanel catalogTxt;
	private HTMLPanel orderTxt;
	private HTMLPanel profileTxt;
	
	public Homepage() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "805px");
		catalogImg = new HTMLPanel("<div class='image'>"
				+ "<a href='#'><img class='img' src='/img/catalogo.png' alt=''></a></div>");
		absolutePanel.add(catalogImg, 10, 10);
		
		orderImg = new HTMLPanel("<div class='image'>"
				+ "<a href='#'><img class='img' src='/img/pedir.png' alt=''></a></div>");
		absolutePanel.add(orderImg, 336, 289);
		orderImg.setSize("190px", "34px");
		
		profileImg = new HTMLPanel("<div class='image'>"
				+ "<a href='#'><img class='img' src='/img/perfil.png' alt=''></a></div>");
		absolutePanel.add(profileImg, 10, 582);
		profileImg.setSize("190px", "34px");
		
		catalogTxt = new HTMLPanel("<div class='desctitle'>Catalogo</div>"
				+ "<div class='descript'>Visita nuestro catalogo\nde monturas</div>");
		absolutePanel.add(catalogTxt, 301, 10);
		catalogTxt.setSize("208px", "136px");
		
		orderTxt = new HTMLPanel("<div class='desctitle'>Ordena tus anteojos</div>"
				+ "<div class='descript'>Elige tu montura\ny tus lentes</div>");
		absolutePanel.add(orderTxt, 26, 289);
		orderTxt.setSize("201px", "200px");
		
		profileTxt = new HTMLPanel("<div class='desctitle'>Mi perfil</div>"
				+ "<div class='descript'>Administra tu\nperfil</div>");
		absolutePanel.add(profileTxt, 319, 582);
		profileTxt.setSize("190px", "177px");

	    
//	    Button btnActualizar = new Button("Actualizar");
//	 // Listen for mouse events on the Add button.
//	    btnActualizar.addClickHandler(new ClickHandler() {
//	      public void onClick(ClickEvent event) {
//	        fillFramesList();
//	      }
//	    });
//	    absolutePanel.add(btnActualizar, 353, 160);
	    
	}
	
//	//Crear item
//	private void createItem() {
//		
//		final Long newId = Long.parseLong(newIdTextBox.getText());
//		final int newPrice = Integer.parseInt(newPriceTextBox.getText());
//		final String newDesc = textArea.getText();
//		
//		if (newId == 0 || newId == null || newPrice == 0 || newDesc == "" || newDesc == null) {
//			messagesLabel.setStyleName("messageWarningLabel");
//			messagesLabel.setText("Todos los campos son requeridos.");
//			Window.alert("Todos los campos son requeridos.");
//			return;
//		}
//		
//		OfyFrame frame = new OfyFrame();
//		frame.id = newId;
//		frame.frameprice = newPrice;
//		frame.description = newDesc;
//		
//		adminService.sendSaveItemServer(frame, new AsyncCallback<String>() {
//			
//			String rpcResult;
//			
//			public void onFailure(Throwable caught) {
//				// Show the RPC error message to the user
//				rpcResult = "Remote Procedure Call - Failure\n" 
//							+ "Error al crear nuevo item.";
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
//		
//	}
}
