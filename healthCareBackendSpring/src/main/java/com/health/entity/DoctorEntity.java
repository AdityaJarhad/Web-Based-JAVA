package com.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "doctor")
public class DoctorEntity extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String specialization;


	
}
