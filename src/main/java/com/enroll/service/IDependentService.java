package com.enroll.service;

import com.enroll.model.Dependent;

public interface IDependentService {
	
	public Dependent addDependent(Dependent dependent);

	public Dependent editDependent(Dependent dependent);

	public void deleteDependent(Integer id);

}
