package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.ruter.model.Line;
import com.knuthp.ruter.model.TransportationType;
import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@ViewScope
@SpringView(name = LineListViewImpl.VIEW_NAME)
public class LineListViewImpl extends VerticalLayout implements LineListView,
		View {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory
			.getLogger(LineListViewImpl.class);
	public static final String VIEW_NAME = "LineList";
	private final List<LineListViewListener> listeners = new ArrayList<LineListView.LineListViewListener>();
	private final BeanContainer<String, Line> lineListBeans;
	private final Table table;
	private final Map<TransportationType, CheckBox> filterMap = new HashMap<TransportationType, CheckBox>();

	@Autowired
	public LineListViewImpl(Presenter<LineListView> presenter) {
		HorizontalLayout filterButtons = new HorizontalLayout();
		for (TransportationType t : TransportationType.values()) {
			CheckBox checkBox = new CheckBox(t.toString());
			checkBox.addValueChangeListener(listener -> filterChanged(t,
					(Boolean) listener.getProperty().getValue()));

			filterButtons.addComponent(checkBox);
			filterMap.put(t, checkBox);
		}
		addComponent(filterButtons);
		lineListBeans = new BeanContainer<String, Line>(Line.class);
		lineListBeans.setBeanIdProperty("id");
		table = new Table("Lines", lineListBeans);
		table.setColumnHeader("name", "Navn");
		table.setColumnHeader("transportation", "Transport");
		table.addGeneratedColumn("Icon", this::generatePrettyNameCell);
		table.setVisibleColumns("Icon", "name", "transportation");
		table.setSelectable(true);

		addComponent(table);

		presenter.setView(this);
	}

	private void filterChanged(TransportationType transportationType,
			boolean selected) {
		listeners.forEach(l -> l.filterChanged(transportationType, selected));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLines(List<Line> allLines) {
		lineListBeans.removeAllItems();
		lineListBeans.addAll(allLines);
	}

	public Object generatePrettyNameCell(Table source, Object itemId,
			Object columnId) {
		Item item = source.getItem(itemId);
		Property<String> name = item.getItemProperty("name");
		Property<TransportationType> type = item
				.getItemProperty("transportation");
		ClassResource resource = new ClassResource("icons/"
				+ type.getValue().name().toLowerCase() + ".svg");

		LOG.info(resource.getFilename() + resource.getMIMEType()
				+ resource.getBufferSize());
		Embedded image = new Embedded(type.getValue().toString(), resource);
		image.setWidth(32, Unit.PIXELS);
		image.setHeight(32, Unit.PIXELS);
		return image;
	}

	@Override
	public void addListener(LineListViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void setDisplayList(List<TransportationType> displayList) {
		displayList.forEach(b -> filterMap.get(b).setValue(true));
	}

}
