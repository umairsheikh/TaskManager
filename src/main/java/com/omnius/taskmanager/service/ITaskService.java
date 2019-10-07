package com.omnius.taskmanager.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.omnius.taskmanager.dto.TaskDTO;
import com.omnius.taskmanager.model.Task;

public interface ITaskService {

	List<TaskDTO> getTasksByUser(String user);

	TaskDTO getTaskById(long id);

	TaskDTO updateTask(TaskDTO task);

	TaskDTO addTask(String username,String title, String desc, Date duedate,Date resolvedat);

	void deleteTask(long id);

	List<TaskDTO> getAllTasks();

	TaskDTO saveTask(TaskDTO task);

}