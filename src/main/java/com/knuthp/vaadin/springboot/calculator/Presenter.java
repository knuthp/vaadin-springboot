package com.knuthp.vaadin.springboot.calculator;

public interface Presenter<T> {
	void setView(T view);
}
