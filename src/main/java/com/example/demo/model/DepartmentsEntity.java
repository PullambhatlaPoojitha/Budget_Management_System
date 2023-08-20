package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class DepartmentsEntity {

	@Id
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<AttributeEntity> attributes;
	public List<AttributeEntity> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<AttributeEntity> attributes) {
		this.attributes = attributes;
	}
	
	
}
