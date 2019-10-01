package com.omnius.taskmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnius.taskmanager.model.Task;
import com.omnius.taskmanager.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	
	@Override
	public List<Task> getAllTasks() {
			  return taskRepository.findAll();
	}
	
	@Override
	public List<Task> getTasksByUser(String username) {
		return taskRepository.findByUsername(username);
	}

	@Override
	public Optional<Task> getTaskById(long id) {
		return taskRepository.findById(id);
	}

	@Override
	public void updateTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public Task addTask(String username,String title, String desc, Date duedate,Date resolvedat,Date remindat) {
		return taskRepository.save(new Task(username,title, desc, duedate, resolvedat,remindat));
	}

	@Override
	public void deleteTask(long id) {
		Optional<Task> task = taskRepository.findById(id);
		if (task.isPresent()) {
			taskRepository.delete(task.get());
		}
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
}