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

	public Place getStop(String id) {
		ResponseEntity<Place> entity = restTemplate
				.getForEntity("http://reisapi.ruter.no" + "/Place/GetStop/"
						+ id, Place.class);
		return entity.getBody();
	}

	public List<Place> getStopsRuter() {
		ResponseEntity<Place[]> entity = restTemplate.getForEntity(
				"http://reisapi.ruter.no" + "/Place/GetStopsRuter/",
				Place[].class);
		return Arrays.asList(entity.getBody());
	}
}