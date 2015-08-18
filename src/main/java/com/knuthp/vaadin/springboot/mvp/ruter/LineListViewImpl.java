package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.ruter.model.Line;
import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@ViewScope
@SpringView(name = LineListViewImpl.VIEW_NAME)
public class LineListViewImpl extends VerticalLayout implements LineListView,
		View {
	public static final String VIEW_NAME = "LineList";
	private final BeanContainer<String, Line> lineListBeans;
	private final Table table;

	@Autowired
	public LineListViewImpl(Presenter<LineListView> presenter) {
		lineListBeans = new BeanContainer<String, Line>(Line.class);
		lineListBeans.setBeanIdProperty("id");
		table = new Table("Lines", lineListBeans);
		table.setSizeFull();

		addComponent(table);

		presenter.setView(this);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLines(List<Line> allLines) {
		lineListBeans.addAll(allLines);
	}

}
