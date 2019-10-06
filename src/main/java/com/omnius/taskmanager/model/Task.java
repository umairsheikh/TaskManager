package com.omnius.taskmanager.model;

import java.io.Serializable;
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

@Entity
@Table(name = "tasks")
public class Task implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	
	@CreationTimestamp
	@Column(name = "CREATEDAT", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
	private Date createdat;
	@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
	private Date updatedat;	
	@Temporal(TemporalType.TIMESTAMP)
	private Date duedate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedat;
	@Temporal(TemporalType.TIMESTAMP)
	private Date remindat;
	@Size(min = 2, message = "Enter at least 10 Characters...")
	private String title;
	@Size(min = 1, message = "Enter at least 10 Characters...")
	private String description;
	
	private int priority;
	private int status;	

	
	public Task() {
		super();
	}

	public Task(String user,String title, String desc, Date duedate,Date resolvedat,Date remindat) {
		super();
		this.username = user;
		this.title = title;
		this.description = desc;
		this.duedate = duedate;
		this.resolvedat= resolvedat;
		this.remindat = remindat;
		
	}

	public void showTaskData()
	{
		System.out.println(" Created AT"+createdat.toString() +" Title "+title);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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