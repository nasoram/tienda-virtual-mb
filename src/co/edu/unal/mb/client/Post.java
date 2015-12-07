package co.edu.unal.mb.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Post extends Composite {

	private static PostUiBinder uiBinder = GWT.create(PostUiBinder.class);
	@UiField HTMLPanel htmlPanel;

	interface PostUiBinder extends UiBinder<Widget, Post> {
	}

	public Post() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void setWidgetPanel(Widget widget){
		htmlPanel.add(widget);
	}

}
