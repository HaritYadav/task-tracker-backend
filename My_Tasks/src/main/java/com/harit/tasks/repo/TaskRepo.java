package com.harit.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harit.tasks.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
