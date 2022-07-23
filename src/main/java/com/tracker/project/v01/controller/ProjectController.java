package com.tracker.project.v01.controller;

import com.tracker.project.v01.model.ProjectModel;
import com.tracker.project.v01.service.IProjectService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v01/project")
public class ProjectController {

	private final IProjectService projectService;

	public ProjectController(final IProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjectModel>> findAll() {
		final List<ProjectModel> projects = projectService.findAll();
		return new ResponseEntity<>(projects, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectModel> find(@PathVariable final String name) {
		final ProjectModel project = projectService.find(name);
		return new ResponseEntity<>(project, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectModel> create(@RequestBody final ProjectModel model) {
		final ProjectModel project = projectService.create(model);
		return new ResponseEntity<>(project, new HttpHeaders(), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectModel> update(@PathVariable final String name, @RequestBody final ProjectModel model){
		final ProjectModel project = projectService.update(name, model);
		return new ResponseEntity<>(project, new HttpHeaders(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{name}")
	public ResponseEntity deleteStore(@PathVariable String name){
		projectService.delete(name);
		return new ResponseEntity(new HttpHeaders(), HttpStatus.NO_CONTENT);
	}
}
