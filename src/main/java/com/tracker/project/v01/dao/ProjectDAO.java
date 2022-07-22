package com.tracker.project.v01.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Entity(name = "project")
public class ProjectDAO {

	@jakarta.persistence.Id
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
