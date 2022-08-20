package com.tracker.project.v01.dao;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity(name = "project")
public class ProjectDAO {

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Lob
	private byte[] icon;
	@Column(nullable = false)
	private String tag;
	@Column(nullable = false)
	private String owner;
	private String createdBy;
	private String updatedBy;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;


}
