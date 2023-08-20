package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.DepartmentsEntity;

public interface DepartmentsRepository extends JpaRepository<DepartmentsEntity, Integer> {

//	DepartmentsEntity getDepartmentById(String departmentId);

//	DepartmentsEntity getDepartmentById(String departmentId);
//	DepartmentsEntity findByDepartmentName(String departmentName);

//	DepartmentsEntity findByDepartmentName(String departmentName);
//	 List<DepartmentsEntity> findAll();
//	Optional<DepartmentsEntity> findById(int departmentId);
	List<DepartmentsEntity> findAll();
	
	@Query("SELECT d.departmentId FROM DepartmentsEntity d")
    List<Integer> findAllDepartmentIds();
	


	    @Query("SELECT d FROM DepartmentsEntity d JOIN FETCH d.attributes WHERE d.id = :departmentId")
	    DepartmentsEntity findByIdWithAttributes(@Param("departmentId") int departmentId);
	}

	


