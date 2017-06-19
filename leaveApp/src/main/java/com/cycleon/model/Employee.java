package com.cycleon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="department")
	private String department;
	@Column(name="available_leaves")
	private double availableLeaves;
	public Employee(){
		
	}
	public Employee(int id,String name,String email,String department,double availableLeaves){
		this.id=id;
		this.name=name;
		this.email=email;
		this.department=department;
		this.availableLeaves=availableLeaves;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getAvailableLeaves() {
		return availableLeaves;
	}
	public void setAvailableLeaves(double availableLeaves) {
		this.availableLeaves = availableLeaves;
	}
	
	
}
