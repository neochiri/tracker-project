package com.tracker.project.v01.service;

import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.mapper.ProjectMapper;
import com.tracker.project.v01.model.ProjectModel;
import com.tracker.project.v01.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tracker.project.v01.utils.ProjectConstants.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
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
		when(projectRepository.findByName(anyString())).thenReturn(new ProjectDAO());
		when(projectMapper.daoToModel(any(ProjectDAO.class))).thenReturn(new ProjectModel());
		ProjectModel project = projectService.find(PROJECT_NAME);

		assertNotNull("Project must not be null", project);
	}
}
