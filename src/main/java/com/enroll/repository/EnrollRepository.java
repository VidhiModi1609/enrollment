package com.enroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enroll.model.Enrollee;

public interface EnrollRepository extends JpaRepository<Enrollee, Integer> {

}
