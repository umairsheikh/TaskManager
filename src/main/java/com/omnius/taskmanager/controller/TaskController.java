package com.omnius.taskmanager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omnius.taskmanager.dto.TaskDTO;
import com.omnius.taskmanager.model.Task;
import com.omnius.taskmanager.service.ITaskService;


@Controller
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	@GetMapping("/all")
    public List<TaskDTO> getAllTasks() {
    	System.out.println("getallTasks");
    	List <TaskDTO> tasks = taskService.getAllTasks();
        return tasks;
    }	   
	
	@RequestMapping(value = "/list-tasks", method = RequestMethod.GET)
	public String showTasks(ModelMap model) {
		String name = getLoggedInUsername(model);
		model.put("tasks", taskService.getTasksByUser(name));
		return "list-tasks";
	}

	private String getLoggedInUsername(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String showAddTaskPage(ModelMap model) {
		model.addAttribute("task", new TaskDTO());
		return "taskPage";
	}

	@RequestMapping(value = "/delete-task", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long id) {
		taskService.deleteTask(id);
		return "redirect:/list-tasks";
	}

	@RequestMapping(value = "/update-task", method = RequestMethod.GET)
	public String showUpdateTaskPage(@RequestParam long id, ModelMap model) {
		TaskDTO taskdto = taskService.getTaskById(id);
		taskdto.showTaskData();
		model.put("task", taskdto);
		return "taskPage";
	}

	@RequestMapping(value = "/update-task", method = RequestMethod.POST)
	public String updateTask(ModelMap model, @Valid TaskDTO task, BindingResult result) {

		System.out.println("--------------------------update post req");
//		if (result.hasErrors()) {
//			return "task";
//		}
	   task.setUsername(getLoggedInUsername(model));
	   
	   if(task == null)
	   {
	    System.out.println("--------------------------resolved"+task.getResolvedat() );
		System.out.println("--------------------------postponed"+task.getRemindat() );
	   }
	   else
	   { 
		   TaskDTO taskDto = taskService.updateTask(task);
	   }
	   return "redirect:/list-tasks";
	}

	@RequestMapping(value = "/add-task", method = RequestMethod.POST)
	public String addTask(ModelMap model, @Valid TaskDTO task, BindingResult result) {

		if (result.hasErrors()) {
			return "task";
		}

		task.setUsername(getLoggedInUsername(model));
		taskService.saveTask(task);
		return "redirect:/list-tasks";
	}
}
