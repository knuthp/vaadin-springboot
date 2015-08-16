package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

public interface PlaceListView {

	void init(List<PlaceLight> placeList);

	interface PlaceListViewListener {
		void selectionChanged(String id);
	}

	void addListener(PlaceListViewListener listener);

}
