package com.knuthp.vaadin.springboot.mvp;

public interface Presenter<T> {
	void setView(T view);
}
