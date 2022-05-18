package com.harit.tasks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harit.tasks.dto.ProjectDto;
import com.harit.tasks.exception.TaskTrackerException;
import com.harit.tasks.model.Project;
import com.harit.tasks.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	private ProjectService service;
	
	public ProjectController(ProjectService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody ProjectDto request) {
		Long id = service.createNewProject(request);
		return ResponseEntity.ok().body(id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Project>> getAll(){
		return ResponseEntity.ok().body(service.getAllProjects());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Project> getById(@PathVariable Long id) throws TaskTrackerException{
		return ResponseEntity.ok().body(service.getProjectById(id));
	}
	
	@GetMapping("/getByStatus/{status}")
	public ResponseEntity<List<Project>> getByStatus(@PathVariable String status) throws TaskTrackerException{
		return ResponseEntity.ok().body(service.getAllProjectsByStatus(status));
	}
	
	@GetMapping("/getByType/{type}")
	public ResponseEntity<List<Project>> getByType(@PathVariable String type) throws TaskTrackerException{
		return ResponseEntity.ok().body(service.getAllProjectsByType(type));
	}
	
}
