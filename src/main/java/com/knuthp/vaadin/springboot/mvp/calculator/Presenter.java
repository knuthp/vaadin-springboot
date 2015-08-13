package com.knuthp.vaadin.springboot.mvp.calculator;

public interface Presenter<T> {
	void setView(T view);
}
