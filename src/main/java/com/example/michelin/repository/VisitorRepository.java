package com.example.michelin.repository;

import com.example.michelin.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
}
