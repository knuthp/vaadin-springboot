package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.knuthp.vaadin.springboot.mvp.ruter.PlaceListView.PlaceListViewListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.UI;

@SpringComponent
@VaadinSessionScope
public class PlaceListPresenter implements Presenter<PlaceListView>,
		PlaceListViewListener {
	private static final Logger LOG = LoggerFactory
			.getLogger(PlaceListPresenter.class);

	private PlaceListView view;
	private PlaceList placeList;

	@Override
	public void setView(PlaceListView view) {
		this.view = view;
		List<PlaceLight> list = placeList.getPlaceList();
		LOG.info("Init view with list of size={}", list.size());
		view.init(list);
		view.addListener(this);
	}

	@Autowired
	public PlaceListPresenter(PlaceList placeList) {
		this.placeList = placeList;
	}

	@Override
	public void selectionChanged(String id) {
		if (id != null) {
			LOG.info("Changing to place id={}", id);
			UI.getCurrent().getNavigator().navigateTo("Place" + "/" + id);
		}
	}

}
