package com.omnius.taskmanager.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.omnius.taskmanager.model.Task;

@Component
public class ScheduleTasks {

    
    @Autowired
    private  TaskService taskService;

    public static int counter=1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    
    //@Scheduled(fixedRate = 10000)
    @Scheduled(fixedRate = 600000, initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(60*1000) }" )
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
    	 json.put("resolvedat",date);
    	 json.put("remindat",date);
     	 


     	 
    	 ObjectMapper objectMapper = new ObjectMapper();
    	 Task task;
		try {
			task = objectMapper.readValue(json.toString(), Task.class);
			 Task createdTask = taskService.addTask("admin",task.getTitle(), task.getDescription(), task.getDuedate(),task.getResolvedat(),task.getRemindat());
			 createdTask.showTaskData();			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}