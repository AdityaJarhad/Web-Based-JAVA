package com.app.entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass //class level annotation
			//(meant for hibernate) --> to tell hibernate following is super class, 
			//from which all other entities will inherit, don't create any table
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp	//add current date only once when entity created 
	private LocalDate creationDate;
	@UpdateTimestamp	//update date at every time after update entity
	private LocalDate updatedOn;
	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", creationDate=" + creationDate + ", updatedOn=" + updatedOn + "]";
	}
	
}
