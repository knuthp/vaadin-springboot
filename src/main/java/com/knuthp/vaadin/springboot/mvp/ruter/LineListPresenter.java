package com.knuthp.vaadin.springboot.mvp.ruter;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.ruter.model.LineList;
import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;

@SpringComponent
@VaadinSessionScope
public class LineListPresenter implements Presenter<LineListView> {
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
	}

}
