package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import com.knuthp.ruter.model.PlaceLight;

public interface PlaceListView {

	void init(List<PlaceLight> placeList);

	interface PlaceListViewListener {
		void selectionChanged(String id);
	}

	void addListener(PlaceListViewListener listener);

}
