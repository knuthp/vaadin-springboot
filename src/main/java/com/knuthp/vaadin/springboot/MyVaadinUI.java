package com.knuthp.vaadin.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.calculator.MvpCalculatorViewImpl;
import com.knuthp.vaadin.springboot.mvp.ruter.LineListViewImpl;
import com.knuthp.vaadin.springboot.mvp.ruter.PlaceListViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Title("Vaadin springboot")
@Theme("valo")
@SpringUI
public class MyVaadinUI extends UI {
	private static final long serialVersionUID = 1L;
	// we can use either constructor autowiring or field autowiring
	@Autowired
	private SpringViewProvider viewProvider;

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
		root.addComponent(navigationBar);

		final Panel viewContainer = new Panel();
		viewContainer.setSizeFull();
		root.addComponent(viewContainer);
		root.setExpandRatio(viewContainer, 1.0f);

		Navigator navigator = new Navigator(this, viewContainer);
		navigator.addProvider(viewProvider);
	}

	private Component createNavigationButton(String caption, String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(event -> getUI().getNavigator().navigateTo(
				viewName));
		return button;
	}
}
