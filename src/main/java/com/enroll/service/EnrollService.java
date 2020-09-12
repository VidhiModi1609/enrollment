package com.enroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enroll.model.Enrollee;
import com.enroll.repository.EnrollRepository;

@Service
public class EnrollService implements IEnrollService{

	 
    @Autowired
    private EnrollRepository enrollRepository;
 
    public List<Enrollee> getAllEnrollees() {
 
        return enrollRepository.findAll();
    }
 
    public Enrollee addEnrollee(Enrollee enrollee) {
        return enrollRepository.save(enrollee);
    }
 
    public Enrollee editEnrollees(Enrollee entity) {
 
        return enrollRepository.save(entity);
    }
 
    public void deleteEnrollees(Integer id) {
 
        enrollRepository.deleteById(id);
    }

}
