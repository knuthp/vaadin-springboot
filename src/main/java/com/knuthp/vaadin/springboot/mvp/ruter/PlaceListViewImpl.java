package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@ViewScope
@SpringView(name = PlaceListViewImpl.VIEW_NAME)
public class PlaceListViewImpl extends VerticalLayout implements PlaceListView,
		View {
	public static final String VIEW_NAME = "PlaceList";
	public final Table table;
	private final BeanContainer<String, Place> placeBeans;

	@Autowired
	public PlaceListViewImpl(Presenter<PlaceListView> presenter) {
		// setSizeFull();
		placeBeans = new BeanContainer<String, Place>(Place.class);
		placeBeans.setBeanIdProperty("id");

		table = new Table("Ruter stoppesteder", placeBeans);
		table.setSizeFull();
		table.setPageLength(100);
		addComponent(table);
		setHeight(100, Unit.PERCENTAGE);

		presenter.setView(this);

	}

	@Override
	public void init(List<Place> placeList) {
		placeBeans.addAll(placeList);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
