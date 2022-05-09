package com.harit.tasks.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private Long project_id;
	
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant create_date;
	
	private Instant complete_date;
	
	@OneToMany
	private List<Task> task_list;
	
	@EnumValidator(
		     enumClass= ProjectStatus.class,
		     message = "Incorrect Project Type!! Try: Inspiration, Ideation, Implementation"
		 )
	private String project_status;
	
	@EnumValidator(
	     enumClass= ProjectType.class,
	     message = "Incorrect Project Type!! Try: Development, Learning, BAU, Maintenance"
		)
	private String project_type;
	
}
