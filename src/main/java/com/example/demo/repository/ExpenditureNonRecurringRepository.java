package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ExpenditureNonRecurringEntity;
import com.example.demo.model.ExpenditureRecurringEntity;
import com.example.demo.model.IncomeEntity;

public interface ExpenditureNonRecurringRepository extends JpaRepository<ExpenditureNonRecurringEntity, Integer> {

	
	Optional<ExpenditureNonRecurringEntity> findByDepartmentId(int departmentId);

}
