package com.enroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enroll.model.Dependent;
import com.enroll.model.Enrollee;
import com.enroll.service.DependentService;
import com.enroll.service.EnrollService;

@RequestMapping(value = "/enrollment-api")
@RestController
public class DependentEndpoint {

	@Autowired
	private DependentService dependentService;
	@Autowired
	private EnrollService enrollService;

	@CrossOrigin
	@PostMapping("/dependent/{enrolleeId}")
	public ResponseEntity<Dependent> saveDependent(@RequestBody Dependent dependent,@PathVariable (value = "enrolleeId") Integer enrolleeId) {
		Enrollee enrol= enrollService.getAllEnrollees().stream().filter(enrollee->enrollee.getId().equals(enrolleeId)).findFirst().get();
		dependent.setEnrollee(enrol);
		Dependent dep = dependentService.addDependent(dependent);
		
		return new ResponseEntity<>(dep, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/dependent")
	public ResponseEntity<Dependent> updateDependent(@RequestBody Dependent dependent) {

		Dependent emp = dependentService.editDependent(dependent);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/dependent/{id}")
	public ResponseEntity<String> deleteDependent(@PathVariable(value = "id") Integer dependentId) {

		dependentService.deleteDependent(dependentId);
		return new ResponseEntity<>("Enrollee with ID :" + dependentId + " deleted successfully", HttpStatus.OK);
	}

}
