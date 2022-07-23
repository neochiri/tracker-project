package com.tracker.project.v01.dao;

import javax.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity(name = "project")
public class ProjectDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String name;
	private byte[] icon;
	@Column(nullable = false)
	private String tag;
	@Column(nullable = false)
	private String owner;
	private String createdBy;
	private String updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;


}
