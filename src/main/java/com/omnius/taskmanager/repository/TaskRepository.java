package com.omnius.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnius.taskmanager.dto.TaskDTO;
import com.omnius.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByUsername(String user);
}
