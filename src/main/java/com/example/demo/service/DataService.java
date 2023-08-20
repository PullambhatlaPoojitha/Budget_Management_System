//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.AttributeEntity;
//import com.example.demo.model.GetAllDataEntity;
//import com.example.demo.repository.DataRepository;
//
//@Service
//public class DataService{
//	
//	
//
//	    @Autowired
//	    private DataRepository dataRepository; 
//	    
//	    public GetAllDataEntity getDepartmentAttributes(int departmentId) {
//	        // Fetch department data from the database using departmentId
//	        // Construct a Department object and populate its attributes and values
//	    	GetAllDataEntity department = new GetAllDataEntity();
//	        // Set departmentId and departmentName
//	        department.setDepartmentId(departmentId);
//	        department.setDepartmentName(dataRepository.getDepartmentName(departmentId));
//	        
//	        // Fetch attributes and values from the database using departmentId
//	        List<AttributeEntity> attributes = dataRepository.getAttributes(departmentId);
//	        for (AttributeEntity attribute : attributes) {
//	            department.getAttributesAndValues().put(attribute.getName(), attribute.getValue());
//	        }
//	        
//	        return department;
//	    }
//	}
//
//	