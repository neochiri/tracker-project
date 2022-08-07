package com.tracker.project.v01.service;

import com.tlc.tracker.exception.BusinessServiceException;
import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.mapper.ProjectMapper;
import com.tracker.project.v01.model.ProjectModel;
import com.tracker.project.v01.repository.IProjectRepository;
import com.tracker.project.v01.utils.ProjectObjects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.tracker.project.v01.utils.ProjectConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.*;

@ExtendWith({MockitoExtension.class})
public class ProjectServiceTest {

	@InjectMocks
	private ProjectService projectService;
	private final IProjectRepository projectRepository;
	private final ProjectMapper projectMapper;

	public ProjectServiceTest(@Mock final IProjectRepository projectRepository, @Mock final ProjectMapper projectMapper) {
		this.projectRepository = projectRepository;
		this.projectMapper = projectMapper;
	}

	@Test
	public void testFindProjectFound() {
		when(projectRepository.findByName(anyString())).thenReturn(ProjectObjects.getProjectDAO());
		when(projectMapper.daoToModel(any(ProjectDAO.class))).thenReturn(ProjectObjects.getProjectModel());
		final ProjectModel project = projectService.find(PROJECT_NAME);

		assertNotNull("Project must not be null", project);
	}

	@Test
	public void testFindProjectNotExisting() {
		when(projectRepository.findByName(anyString())).thenReturn(null);

		final BusinessServiceException exception = assertThrows(BusinessServiceException.class, () -> {projectService.find(PROJECT_NAME);});

		assertEquals("Project could not be found", exception.getMessage());
	}

	@Test
	public void testFindAllProjects() {
		when(projectRepository.findAll()).thenReturn(List.of(new ProjectDAO()));
		when(projectMapper.daoToModel(any(ProjectDAO.class))).thenReturn(new ProjectModel());

		final List<ProjectModel> projects = projectService.findAll();

		assertFalse(projects.isEmpty());
	}
}
