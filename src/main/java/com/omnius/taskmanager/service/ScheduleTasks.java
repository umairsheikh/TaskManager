package com.omnius.taskmanager.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.omnius.taskmanager.dto.TaskDTO;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class ScheduleTasks {

    
    @Autowired
    private  TaskService taskService;

    public static int counter=1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    
    @Scheduled(fixedDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10000,100000) }" )
    public void callTaskGenerator() {
    	counter++; 
    	String date = dateFormat.format(new Date());
    	 JSONObject json = new JSONObject();
    	 json.put("username","admin");
    	 json.put("title","app");
    	 json.put("description","DB Bahn");
    	 json.put("priority",1);
    	 json.put("status",1);
    	 json.put("duedate",date);
     	 
    	 ObjectMapper objectMapper = new ObjectMapper();
    	 TaskDTO task;
		try {
			task = objectMapper.readValue(json.toString(), TaskDTO.class);
			TaskDTO createdTask = taskService.addTask("admin",task.getTitle(), task.getDescription(), task.getDuedate(),null);
			// createdTask.showTaskData();			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}