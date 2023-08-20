package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ExpenditureRecurringEntity;
import com.example.demo.model.IncomeEntity;

public interface ExpenditureRecurringRepository extends JpaRepository<ExpenditureRecurringEntity, Integer> {

	Optional<ExpenditureRecurringEntity> findByDepartmentId(int departmentId);

}
