package com.enroll.service;

import java.util.List;

import com.enroll.model.Enrollee;

public interface IEnrollService {

	public List<Enrollee> getAllEnrollees();
 
    public Enrollee addEnrollee(Enrollee enrollee);
 
    public Enrollee editEnrollees(Enrollee entity);
 
    public void deleteEnrollees(Integer id);

}
