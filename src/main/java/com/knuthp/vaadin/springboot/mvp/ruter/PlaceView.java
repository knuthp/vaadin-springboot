package com.knuthp.vaadin.springboot.mvp.ruter;

import com.knuthp.ruter.model.PlaceDetails;

public interface PlaceView {

	void setPlace(PlaceDetails placeDetails);

	interface PlaceViewListener {
		void placeChanged(String id);
	}

	void addListener(PlaceViewListener listener);

}
