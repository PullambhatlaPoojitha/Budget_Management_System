package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getColumnNames(Class<?> entityClass) {
        return entityManager.getMetamodel().entity(entityClass).getAttributes().stream()
                .map(attribute -> attribute.getName())
                .collect(Collectors.toList());
    }
}
