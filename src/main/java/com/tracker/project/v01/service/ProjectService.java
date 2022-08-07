package com.tracker.project.v01.service;

import com.tlc.tracker.exception.BusinessServiceException;
import com.tlc.tracker.exception.ErrorType;
import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.mapper.ProjectMapper;
import com.tracker.project.v01.model.ProjectModel;
import com.tracker.project.v01.repository.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

	private final IProjectRepository projectRepository;
	private final ProjectMapper projectMapper;

	public ProjectService(final IProjectRepository projectRepository, final ProjectMapper projectMapper) {
		this.projectRepository = projectRepository;
		this.projectMapper = projectMapper;
	}

	@Override
	public ProjectModel find(final String name) {
		final ProjectDAO projectFound = projectRepository.findByName(name);
		if (projectFound == null) {
			throw new BusinessServiceException("Project could not be found", ErrorType.BUSINESS_ERROR);
		}
		final ProjectModel project = projectMapper.daoToModel(projectFound);
		return project;
	}

	@Override
	public List<ProjectModel> findAll() {
		final List<ProjectDAO> projectsFound = projectRepository.findAll();
		final List<ProjectModel> projects = projectsFound.stream().map(project -> projectMapper.daoToModel(project)).collect(Collectors.toList());
		return projects;
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
