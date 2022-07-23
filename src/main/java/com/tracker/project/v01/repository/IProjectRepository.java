package com.tracker.project.v01.repository;

import com.tracker.project.v01.dao.ProjectDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<ProjectDAO, Integer> {
	ProjectDAO findByName(final String name);
}
