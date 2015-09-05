package com.knuthp.vaadin.springboot;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.login.SimpleLoginView;
import com.knuthp.vaadin.springboot.mvp.calculator.MvpCalculatorViewImpl;
import com.knuthp.vaadin.springboot.mvp.ruter.LineListViewImpl;
import com.knuthp.vaadin.springboot.mvp.ruter.PlaceListViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Title("Vaadin springboot")
@Theme("valo")
@SpringUI
public class MyVaadinUI extends UI {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(MyVaadinUI.class);
	@Autowired
	private SpringViewProvider viewProvider;
	private Label userName = new Label();

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.setSpacing(true);
		setContent(root);

		final CssLayout navigationBar = new CssLayout();
		navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.addComponent(createNavigationButton("View scoped view",
				ViewScopedView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("UI Scoped View",
				UIScopedView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("MVP Calculator",
				MvpCalculatorViewImpl.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("Place List",
				PlaceListViewImpl.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("Line List",
				LineListViewImpl.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("Login",
				SimpleLoginView.VIEW_NAME));
		root.addComponent(navigationBar);

		final Panel viewContainer = new Panel();
		viewContainer.setSizeFull();
		root.addComponent(viewContainer);
		root.setExpandRatio(viewContainer, 1.0f);

		Navigator navigator = new Navigator(this, viewContainer);
		navigator.addProvider(viewProvider);

		VaadinSession.getCurrent().addRequestHandler(new RequestHandler() {

			@Override
			public boolean handleRequest(VaadinSession session,
					VaadinRequest request, VaadinResponse response)
					throws IOException {
				String user = (String) session.getAttribute("user");
				MDC.put("user", user);
				userName.setValue("Welcome " + user);
				return false;
			}
		});
		root.addComponent(userName);
	}

	private Component createNavigationButton(String caption, String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(event -> getUI().getNavigator().navigateTo(
				viewName));
		return button;
	}
}
