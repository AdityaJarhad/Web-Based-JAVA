package com.app.core;

public class Patient {
	
	private int pid;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	static int id = 1001;
	
	public Patient(String firstName, String lastName, String email, String password) {
		super();
		this.pid = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Patient(int pid, String password) {
		super();
		this.pid = pid;
		this.password = password;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Patient.id = id;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	

}
