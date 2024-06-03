package com.health.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class AppointmentEntity extends BaseEntity {
	@Column(length = 20)
	private LocalDate date;
	@Column(length = 20)
	private LocalTime time;

	@ManyToOne
	@JoinColumn(name = "p_id", nullable = false)
	private PatientEntity patientEntity;
	@ManyToOne
	@JoinColumn(name = "d_id", nullable = false)
	private DoctorEntity doctor;
}
