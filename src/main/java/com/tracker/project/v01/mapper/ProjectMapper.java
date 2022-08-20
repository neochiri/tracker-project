package com.tracker.project.v01.mapper;

import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.model.ProjectModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper implements IMapper<ProjectModel, ProjectDAO>{
	private final ModelMapper modelMapper;

	public ProjectMapper(final ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ProjectModel daoToModel(final ProjectDAO projectDAO) {
		return modelMapper.map(projectDAO, ProjectModel.class);
	}

	@Override
	public ProjectDAO modelToDAO(final ProjectModel projectModel) {
		return modelMapper.map(projectModel, ProjectDAO.class);
	}
}
