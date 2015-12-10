package co.edu.unal.mb.client.form;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

import co.edu.unal.mb.client.OrderService;
import co.edu.unal.mb.client.OrderServiceAsync;
import co.edu.unal.mb.client.entity.OfyFrame;

public class CatalogForm extends Composite {

	private OrderServiceAsync orderService = GWT.create(OrderService.class);
	
	private AbsolutePanel absolutePanel;
	private Label messagesLabel;
	private HTMLPanel titlePanel;
	private FlexTable framesTable;
	private List<OfyFrame> frames;
	
	public CatalogForm() {
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("550px", "440px");
		messagesLabel = new Label();
		
		absolutePanel.add(messagesLabel, 10, 0);
		messagesLabel.setSize("530px", "60px");
		messagesLabel.setStyleName("messageInfoLabel");
		messagesLabel.setText("Bienvenido Admin!");
		titlePanel = new HTMLPanel("<div id='paneltitle'>Catalogo</div>");
		absolutePanel.add(titlePanel, 199, 66);
		
		framesTable = new FlexTable();
		absolutePanel.add(framesTable, 10, 116);
		framesTable.setSize("530px", "88px");
		
		framesTable.setText(0, 0, "ID");
		framesTable.setText(0, 1, "DESCRIPCION");
		framesTable.setText(0, 2, "PRECIO");
		
		framesTable.getRowFormatter().addStyleName(0, "framesListHeader");
		
		fillFramesList();
	    
	}
	
	public void fillFramesList() {
		orderService.listAllItemsServer(new AsyncCallback<List<OfyFrame>>() {
			
			String rpcResult;

			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				rpcResult = "Remote Procedure Call - Failure\n" 
							+ "Error al obtener lista de items.";
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
					frames.add(result.get(i));
					framesTable.setText(i, 0, ""+frames.get(i).id);
					framesTable.setText(i, 1, frames.get(i).description);
					framesTable.setText(i, 2, ""+frames.get(i).frameprice);
					framesTable.getCellFormatter().addStyleName(i, 2, "framesListPriceColumn");
				}
				
			}
		});
	}
}
