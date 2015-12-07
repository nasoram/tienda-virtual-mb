package co.edu.unal.mb.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import co.edu.unal.mb.client.form.AdminForm;
import co.edu.unal.mb.client.form.LoginForm;
import co.edu.unal.mb.client.form.OrderForm;
import co.edu.unal.mb.client.form.ProfileForm;
import co.edu.unal.mb.client.form.RecoveryForm;
import co.edu.unal.mb.client.form.RegisterForm;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	@UiField Label labelHomepage;
	@UiField Label labelOrder;
	@UiField Label labelProfile;
	@UiField Label labelLogin;
	@UiField Label labelRegister;
	@UiField Label labelRecovery;
	@UiField Label labelAdmin;

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("labelHomepage")
	void onLabelHomepageClick(ClickEvent event) {
		Limpiar();
		DOM.getElementById("content").setAttribute("background-color", "transparent");
		DOM.getElementById("homepage").setAttribute("class", "current_page_item");
		
		RootPanel.get("wpost").clear();
	}
	@UiHandler("labelOrder")
	void onLabelOrderClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("content").setAttribute("background-color", "#ffffff");
		DOM.getElementById("order").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new OrderForm());
		RootPanel.get("wpost").add(post);
		
	}
	@UiHandler("labelProfile")
	void onLabelProfileClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("content").setAttribute("background-color", "transparent");
		DOM.getElementById("profile").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new ProfileForm());
		RootPanel.get("wpost").add(post);
	}
	@UiHandler("labelLogin")
	void onLabelLoginClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("login").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new LoginForm());
		RootPanel.get("wpost").add(post);
	}
	@UiHandler("labelRegister")
	void onLabelRegisterClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("register").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new RegisterForm());
		RootPanel.get("wpost").add(post);
	}
	@UiHandler("labelRecovery")
	void onLabelRecoveryClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("recovery").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new RecoveryForm());
		RootPanel.get("wpost").add(post);
	}
	@UiHandler("labelAdmin")
	void onLabelAdminClick(ClickEvent event) {
		Limpiar();
		RootPanel.get("wpost").clear();
		DOM.getElementById("admin").setAttribute("class", "current_page_item");
		
		Post post = new Post();
		post.setWidgetPanel(new AdminForm());
		RootPanel.get("wpost").add(post);
	}
	void Limpiar(){
		DOM.getElementById("homepage").setAttribute("class", "");
		DOM.getElementById("order").setAttribute("class", "");
		DOM.getElementById("profile").setAttribute("class", "");
		DOM.getElementById("login").setAttribute("class", "");
		DOM.getElementById("register").setAttribute("class", "");
		DOM.getElementById("recovery").setAttribute("class", "");
		DOM.getElementById("admin").setAttribute("class", "");
	}
}
