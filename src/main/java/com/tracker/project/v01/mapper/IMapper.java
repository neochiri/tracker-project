package com.tracker.project.v01.mapper;

public interface IMapper<Model, DAO> {
	Model daoToModel(DAO dao);
	DAO modelToDAO(Model model);
}
