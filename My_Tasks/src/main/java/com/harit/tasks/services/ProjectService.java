package com.harit.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harit.tasks.dto.ProjectDto;
import com.harit.tasks.exception.TaskTrackerException;
import com.harit.tasks.model.Project;
import com.harit.tasks.repo.ProjectRepo;

@Service
public class ProjectService {
	
	private ProjectRepo repo;
	
	public ProjectService(ProjectRepo repo) {
		this.repo = repo;
	}
	
	public Long createNewProject(ProjectDto request) {
		Project newProject = mapDtoToModel(request);		
		return repo.save(newProject).getProjectId();
	}
	
	public List<Project> getAllProjects(){
		return repo.findAll();
	}
	

	public Project getProjectById(Long id) throws TaskTrackerException {
		return repo.findById(id).orElseThrow(()-> new TaskTrackerException("No Such Project ID"));
	}
	
	public List<Project> getAllProjectsByStatus(String status) throws TaskTrackerException {
		return repo.findAllByProjectStatus(status);
	}
	
	public List<Project> getAllProjectsByType(String type) throws TaskTrackerException {
		return repo.findAllByProjectType(type);
	}
	
	private Project mapDtoToModel(ProjectDto dto) {
		Project newProject = new Project();
		
		newProject.setProjectName(dto.getProjectName());
		newProject.setProjectStatus(dto.getProjectStatus());
		newProject.setProjectType(dto.getProjectType());
		
		return newProject;
	}
	
}
