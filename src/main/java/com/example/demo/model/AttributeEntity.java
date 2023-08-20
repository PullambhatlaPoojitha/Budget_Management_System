package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "combined_view")
@IdClass(DepartmentAttributeId.class)
public class AttributeEntity {

    @Id
    @Column(name = "department_id")
    private int departmentId;

    @Id
    @Column(name = "attribute")
    private String attribute;

    @Column(name = "budget_in_lakhs")
    private Double budgetInLakhs;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentsEntity department;

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

	public Double getBudgetInLakhs() {
		return budgetInLakhs;
	}

	public void setBudgetInLakhs(Double budgetInLakhs) {
		this.budgetInLakhs = budgetInLakhs;
	}

	public DepartmentsEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentsEntity department) {
		this.department = department;
	}

    // Constructors, getters, setters
    
}
