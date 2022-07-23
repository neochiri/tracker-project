package com.tracker.project.v01.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class ProjectModel {
	private Integer id;
	@NotNull
	@Size(min = 5, max = 30)
	private String name;
	private byte[] icon;
	@NotNull
	@Size(min = 3, max = 3)
	private String tag;
	@NotNull
	@Email
	private String owner;
}
