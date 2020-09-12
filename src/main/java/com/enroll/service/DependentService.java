package com.enroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enroll.model.Dependent;
import com.enroll.repository.DepedentRepository;

@Service
public class DependentService implements IDependentService{

	@Autowired
	private DepedentRepository depedentRepository;

	@Override
	public Dependent addDependent(Dependent dependent) {
		return depedentRepository.save(dependent);
	}

	@Override
	public Dependent editDependent(Dependent dependent) {

		return depedentRepository.save(dependent);
	}

	@Override
	public void deleteDependent(Integer id) {

		depedentRepository.deleteById(id);
	}

}
