package com.example.demo.model;

import java.io.Serializable;

public class DepartmentAttributeId implements Serializable {

    private int departmentId;
    private String attribute;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

    // Constructors, getters, setters, equals, hashCode
    
}
