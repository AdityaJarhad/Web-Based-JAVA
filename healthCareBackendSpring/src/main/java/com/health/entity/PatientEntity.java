package com.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//id name email pawd creationtime updatedon
@Getter
@Setter
@ToString
@Entity
@Table(name = "patient")
public class PatientEntity extends BaseEntity {
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "email", length = 20)
	private String email;
	@Column(name = "password", length = 20)
	private String pwd;


}
