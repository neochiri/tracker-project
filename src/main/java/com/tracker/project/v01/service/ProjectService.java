package com.tracker.project.v01.service;

import com.tracker.project.v01.model.ProjectModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

	@Override
	public ProjectModel find(final String name) {
		return null;
	}

	@Override
	public List<ProjectModel> findAll() {
		return List.of(new ProjectModel());
	}

	@Override
	public ProjectModel create(final ProjectModel projectModel) {
		return new ProjectModel();
	}

	@Override
	public ProjectModel update(final String name, final ProjectModel projectModel) {
		return new ProjectModel();
	}

	@Override
	public void delete(final String name) {

	}
}
