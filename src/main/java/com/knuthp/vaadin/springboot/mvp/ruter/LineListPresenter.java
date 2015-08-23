package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.ruter.model.Line;
import com.knuthp.ruter.model.LineList;
import com.knuthp.ruter.model.TransportationType;
import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.knuthp.vaadin.springboot.mvp.ruter.LineListView.LineListViewListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;

@SpringComponent
@VaadinSessionScope
public class LineListPresenter implements Presenter<LineListView>,
		LineListViewListener {
	private LineListView view;
	private LineList lineList;
	private List<TransportationType> displayList = new ArrayList<TransportationType>();

	@Autowired
	public LineListPresenter(LineList lineList) {
		this.lineList = lineList;
		displayList.add(TransportationType.TRAIN);
	}

	@Override
	public void setView(LineListView view) {
		this.view = view;
		view.setDisplayList(displayList);
		view.addListener(this);
		setLines();
	}

	@Override
	public void filterChanged(TransportationType transportationType,
			boolean selected) {
		if (selected) {
			displayList.add(transportationType);
		} else {
			displayList.remove(transportationType);
		}
		setLines();
	}

	private void setLines() {
		List<Line> filtered = lineList.getAllLines().stream()
				.filter(e -> displayList.contains(e.getTransportation()))
				.collect(Collectors.toList());
		view.setLines(filtered);
	}

}
