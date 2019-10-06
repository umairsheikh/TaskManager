package com.omnius.taskmanager.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.omnius.taskmanager.model.Task;
import java.io.Serializable;



public class TaskDTO implements Serializable  {

	long id;
	String username;
	Date duedate;
	Date resolvedat;
	Date remindat;
	String title;
	String description;
	Date createdat;
	Date updatedat;	
	
	private int priority;
	private int status;	
	
	public TaskDTO() {
		super();
	}

	public TaskDTO(String user,String title, String desc, Date duedate,Date resolvedat,Date remindat) {
		super();
		this.username = user;
		this.title = title;
		this.description = desc;
		this.duedate = duedate;
		this.resolvedat= resolvedat;
		this.remindat = remindat;
		  priority=this.priority;
		  status=this.status;	
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void showTaskData()
	{
			System.out.println(" Created AT"+getCreatedat().toString() +" Title "+title);
	}
	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getResolvedat() {
		return resolvedat;
	}

	public void setResolvedat(Date resolvedat) {
		this.resolvedat = resolvedat;
	}

	public Date getRemindat() {
		return remindat;
	}

	public void setRemindat(Date remindat) {
		this.remindat = remindat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}