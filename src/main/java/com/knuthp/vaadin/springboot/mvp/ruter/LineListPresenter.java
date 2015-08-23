package com.knuthp.vaadin.springboot.mvp.ruter;

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
public class LineListPresenter implements Presenter<LineListView>, LineListViewListener {
	private LineListView view;
	private LineList lineList;

	@Autowired
	public LineListPresenter(LineList lineList) {
		this.lineList = lineList;
	}

	@Override
	public void setView(LineListView view) {
		this.view = view;
		view.setLines(lineList.getAllLines());
		view.addListener(this);
		
		}

	@Override
	public void filterTransportType(Map<TransportationType, Boolean> filter) {
		List<Line> filtered = lineList.getAllLines().stream().filter(e -> filter.get(e.getTransportation()) != null).collect(Collectors.toList());
		view.setLines(filtered);
	}

}
