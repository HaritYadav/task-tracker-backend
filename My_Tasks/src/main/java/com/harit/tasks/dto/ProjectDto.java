package com.harit.tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
	
	private String projectName;
	private String projectStatus;
	private String projectType;
	
}
