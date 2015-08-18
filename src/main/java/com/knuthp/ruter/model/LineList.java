package com.knuthp.ruter.model;

import java.util.ArrayList;
import java.util.List;

public class LineList {

	private final RuterGateway ruterGateway;

	public LineList(RuterGateway ruterGateway) {
		this.ruterGateway = ruterGateway;
	}

	public List<Line> getAllLines() {
		List<LineLight> lineLightList = ruterGateway.getLines();
		List<Line> lines = new ArrayList<Line>();
		for (LineLight lineLight : lineLightList) {
			lines.add(new Line(ruterGateway, lineLight));
		}
		return lines;
	}

}
