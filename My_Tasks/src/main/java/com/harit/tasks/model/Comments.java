package com.harit.tasks.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comment_id;
	
	@ManyToOne
	@JoinColumn(name="task_id", nullable = false)
	private Task task;
	
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant create_date;
	
	@Column(name="edit_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant edit_date;
	
}
