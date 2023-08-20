//package com.example.demo.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "combined_view")
//public class GetAllDataEntity {
//    @Id
//    @Column(name="department_id")
//    private int departmentId;
//
//    private String attributeName;
//    private Double attributeValue;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
//    private Department department;
//
//    // Constructors, getters, setters
//}
