package com.jpa.demo.dao;

import com.jpa.demo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao extends JpaRepository<Grade, Integer> {
}
