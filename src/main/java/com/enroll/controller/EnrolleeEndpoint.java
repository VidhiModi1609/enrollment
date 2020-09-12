package com.enroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enroll.exception.RecordNotFoundException;
import com.enroll.model.Enrollee;
import com.enroll.service.EnrollService;


@RequestMapping(value = "/enrollment-api")
@RestController
public class EnrolleeEndpoint {

	@Autowired
	private EnrollService enrollService;

	@CrossOrigin
	@GetMapping("/enrollees")
	public ResponseEntity<List<Enrollee>> getAllEnrollees() {

		List<Enrollee> Enrollees = enrollService.getAllEnrollees();
		return new ResponseEntity<>(Enrollees, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/enrollee")
	public ResponseEntity<Enrollee> saveEnrollee(@RequestBody Enrollee Enrollee) {

		Enrollee emp = enrollService.addEnrollee(Enrollee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/enrollee")
	public ResponseEntity<Enrollee> updateEnrollee(@RequestBody Enrollee enrollee) {

		Enrollee emp = enrollService.editEnrollees(enrollee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/enrollee/{id}")
	public ResponseEntity<String> deleteEnrollee(@PathVariable(value = "EnrolleeId") Integer enrolleeId) {
		
		if(enrolleeId == null) {
	         throw new RecordNotFoundException("Invalid enrollee id : " + enrolleeId);
	    }

		enrollService.deleteEnrollees(enrolleeId);
		return new ResponseEntity<>("Enrollee with ID :" + enrolleeId + " deleted successfully", HttpStatus.OK);
	}

}
