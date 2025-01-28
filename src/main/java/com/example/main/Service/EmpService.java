package com.example.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.Entity.Employee;
import com.example.main.Repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;

	public Employee addEmp(Employee e) {
		return repo.save(e);
	}

	public List<Employee> getAllemp() {
		return repo.findAll();
	}

	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}

}
