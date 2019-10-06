package com.omnius.taskmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnius.taskmanager.dto.TaskDTO;
import com.omnius.taskmanager.model.Task;
import com.omnius.taskmanager.repository.TaskRepository;
import com.omnius.taskmanager.util.ObjectMapperUtils;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<TaskDTO> getAllTasks() {
		
		
		List<TaskDTO> listOfTaskDTOs = ObjectMapperUtils.mapAll(taskRepository.findAll(), TaskDTO.class);
		return listOfTaskDTOs;
	}
	
	@Override
	public List<TaskDTO> getTasksByUser(String username) {
		List<TaskDTO> listOfTaskDTOs = ObjectMapperUtils.mapAll(taskRepository.findByUsernameOrderByDuedate(username), TaskDTO.class);
		return listOfTaskDTOs;
	}

	@Override
	public TaskDTO getTaskById(long id) {
		Optional<Task> taskbyId = taskRepository.findById(id);
		System.out.println("---------------------------"+taskbyId.isPresent());

		TaskDTO taskDto = ObjectMapperUtils.map(taskbyId.get(), TaskDTO.class);
		System.out.println("---------------------------"+taskDto.getCreatedat());

		return taskDto;
	}

	@Override
	public TaskDTO updateTask(TaskDTO task) {
		
		Task newTask = ObjectMapperUtils.map(task, Task.class);
		TaskDTO newTaskDto = ObjectMapperUtils.map(taskRepository.save(newTask), TaskDTO.class);
		return newTaskDto;
	}

	@Override
	public TaskDTO addTask(String username,String title, String desc, Date duedate,Date resolvedat,Date remindat) {
		Task newTask= taskRepository.save(new Task(username,title, desc, duedate, resolvedat,remindat));
		TaskDTO newTaskDto = ObjectMapperUtils.map(newTask, TaskDTO.class);
		return newTaskDto;
	}

	@Override
	public void deleteTask(long id) {
		Optional<Task> task = taskRepository.findById(id);
		if (task.isPresent()) 
		{
			taskRepository.delete(task.get());
		}
	}

	@Override
	public TaskDTO saveTask(TaskDTO task) {
		Task newTask = ObjectMapperUtils.map(task, Task.class);
		TaskDTO newTaskDto = ObjectMapperUtils.map(taskRepository.save(newTask), TaskDTO.class);
		return newTaskDto;
	}
}