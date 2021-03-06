package com.tracker.project.v01.service;

import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.mapper.ProjectMapper;
import com.tracker.project.v01.model.ProjectModel;
import com.tracker.project.v01.repository.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
		final ProjectModel project = projectMapper.daoToModel(projectFound);
		return project;
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
