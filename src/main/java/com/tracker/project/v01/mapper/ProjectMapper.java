package com.tracker.project.v01.mapper;

import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.model.ProjectModel;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper implements IMapper<ProjectModel, ProjectDAO>{

	@Override
	public ProjectModel daoToModel(final ProjectDAO projectDAO) {
		return new ProjectModel();
	}

	@Override
	public ProjectDAO modelToDAO(final ProjectModel projectModel) {
		return new ProjectDAO();
	}
}
