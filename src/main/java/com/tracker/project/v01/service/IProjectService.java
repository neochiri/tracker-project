package com.tracker.project.v01.service;

import com.tracker.project.v01.model.ProjectModel;

public interface IProjectService extends IService<ProjectModel> {
	ProjectModel find(final String name);
}
