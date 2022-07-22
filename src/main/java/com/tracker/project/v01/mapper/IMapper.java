package com.tracker.project.v01.mapper;

public interface IMapper<Model, DAO> {
	Model dtoToModel(DAO dao);
	DAO modelToDto(Model model);
}
