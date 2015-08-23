package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;
import java.util.Map;

import com.knuthp.ruter.model.Line;
import com.knuthp.ruter.model.TransportationType;

public interface LineListView {

	void setDisplayList(List<TransportationType> displayList);
	void setLines(List<Line> allLines);
	
	interface LineListViewListener {
		void filterChanged(TransportationType transportationType,
				boolean selected);
	}
	
	void addListener(LineListViewListener listener);


}
