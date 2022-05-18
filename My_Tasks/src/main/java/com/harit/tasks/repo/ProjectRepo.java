package com.harit.tasks.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harit.tasks.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

	List<Project> findAllByProjectStatus(String status);

	List<Project> findAllByProjectType(String type);

}
