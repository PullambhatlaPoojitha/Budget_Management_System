package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DepartmentsEntity;
import com.example.demo.repository.DepartmentsRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentRepository;

 
    public DepartmentsEntity getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }
    public List<DepartmentsEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Transactional
    public DepartmentsEntity getDepartmentWithAttributes(int departmentId) {
        return departmentRepository.findByIdWithAttributes(departmentId);
    }
}