package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class PlaceListPresenter implements Presenter<PlaceListView> {
	private static final Logger LOG = LoggerFactory
			.getLogger(PlaceListPresenter.class);

	private PlaceListView view;
	private PlaceList placeList;

	@Override
	public void setView(PlaceListView view) {
		this.view = view;
		List<Place> list = placeList.getPlaceList();
		LOG.info("Init view with list of size={}", list.size());
		view.init(list);
	}

	@Autowired
	public PlaceListPresenter(PlaceList placeList) {
		this.placeList = placeList;
	}

}
