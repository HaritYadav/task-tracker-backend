package com.harit.tasks.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.harit.tasks.helpers.EnumValidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long task_id;
	
	@NotNull
	@NotEmpty
	private String task_name;
	
	@ManyToOne
	@JoinColumn(name="project_id", nullable=false)
	private Project project;
	
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant create_date;
	
	@EnumValidator(
		     enumClass= TaskStatus.class,
		     message = "Incorrect Project Type!! Try: NotStarted, Backlog, InProgress, Stalled, Completed, Cancelled"
		 )
	private String task_status;
	
	@EnumValidator(
		     enumClass= TaskType.class,
		     message = "Incorrect Project Type!! Try: AppBuilding, MachineLearning, Documentation, BugFixing, RiskHandling"
		 )
	private String task_type;
	
	@OneToMany
	private List<Comments> comments;
	
}
