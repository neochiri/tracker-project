package com.tracker.project.v01.service;

import java.util.List;

public interface IService<Model> {
	List<Model> findAll();
	Model create(final Model model);
	Model update(final String param, final Model model);
	void delete(final String param);
}
