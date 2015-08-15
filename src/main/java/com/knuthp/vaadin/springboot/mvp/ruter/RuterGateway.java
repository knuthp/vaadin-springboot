package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class RuterGateway {
	private RestTemplate restTemplate = new RestTemplate();

	public PlaceLight getStop(String id) {
		ResponseEntity<PlaceLight> entity = restTemplate.getForEntity(
				"http://reisapi.ruter.no" + "/Place/GetStop/" + id,
				PlaceLight.class);
		return entity.getBody();
	}

	public List<PlaceDetails> getPlaces(String id) {
		ResponseEntity<PlaceDetails[]> entity = restTemplate.getForEntity(
				"http://reisapi.ruter.no" + "/Place/GetPlaces/" + id,
				PlaceDetails[].class);
		return Arrays.asList(entity.getBody());
	}

	public List<PlaceLight> getStopsRuter() {
		ResponseEntity<PlaceLight[]> entity = restTemplate.getForEntity(
				"http://reisapi.ruter.no" + "/Place/GetStopsRuter/",
				PlaceLight[].class);
		return Arrays.asList(entity.getBody());
	}

	public List<Line> getLines() {
		ResponseEntity<Line[]> entity = restTemplate.getForEntity(
				"http://reisapi.ruter.no" + "/Line/GetLines/", Line[].class);
		return Arrays.asList(entity.getBody());
	}

}