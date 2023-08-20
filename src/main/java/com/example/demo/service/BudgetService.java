package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.*;
@Service
public class BudgetService {

    private final EntityService entityService;

    @Autowired
    public BudgetService(EntityService entityService) {
        this.entityService = entityService;
    }

    public List<String> getIncomeEntityFields() {
        return entityService.getColumnNames(IncomeEntity.class);
    }

    public List<String> getRecurringExpenditureEntityFields() {
        return entityService.getColumnNames(ExpenditureRecurringEntity.class);
    }

    public List<String> getNonRecurringExpenditureEntityFields() {
        return entityService.getColumnNames(ExpenditureNonRecurringEntity.class);
    }
}
