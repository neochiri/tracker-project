package com.tracker.project.v01.utils;

import com.tracker.project.v01.dao.ProjectDAO;
import com.tracker.project.v01.model.ProjectModel;

import static com.tracker.project.v01.utils.ProjectConstants.*;

public class ProjectObjects {

	public static ProjectModel getProjectModel() {
		return (ProjectModel) UtilsTest.getObjectFromJsonFile(PROJECT_MODEL_JSON, ProjectModel.class);
	}

	public static ProjectDAO getProjectDAO() {
		return (ProjectDAO) UtilsTest.getObjectFromJsonFile(PROJECT_DAO_JSON, ProjectDAO.class);
	}
}
