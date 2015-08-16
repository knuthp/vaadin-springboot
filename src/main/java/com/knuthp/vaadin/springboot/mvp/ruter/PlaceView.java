package com.knuthp.vaadin.springboot.mvp.ruter;

public interface PlaceView {

	void setPlace(PlaceDetails placeDetails);

	interface PlaceViewListener {
		void placeChanged(String id);
	}

	void addListener(PlaceViewListener listener);

}
