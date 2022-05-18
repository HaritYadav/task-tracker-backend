package com.harit.tasks.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.harit.tasks.helpers.EnumValidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	
	@NotNull
	@NotEmpty
	private String projectName;
	
	@CreationTimestamp
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createDate;
	
	@Column(name="complete_date")
	private Instant completeDate;
	
	@Column(columnDefinition="varchar(255)")
	private String creator = "Harit";
	
	@OneToMany
	private List<Task> taskList;
	
	@EnumValidator(
		     enumClass= ProjectStatus.class,
		     message = "Incorrect Project Type!! Try: Inspiration, Ideation, Implementation"
		 )
	private String projectStatus;
	
	@EnumValidator(
	     enumClass= ProjectType.class,
	     message = "Incorrect Project Type!! Try: Development, Learning, BAU, Maintenance"
		)
	private String projectType;
	
}
