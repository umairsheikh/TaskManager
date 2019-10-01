package com.omnius.taskmanager.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.omnius.taskmanager.model.Task;

public interface ITaskService {

	List<Task> getTasksByUser(String user);

	Optional<Task> getTaskById(long id);

	void updateTask(Task task);

	Task addTask(String username,String title, String desc, Date duedate,Date resolvedat,Date remindat);

	void deleteTask(long id);
	
	Task saveTask(Task task);

	List<Task> getAllTasks();

}