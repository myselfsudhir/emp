package com.te.empwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.empwebapp.beans.EmployeeInfoBean;
import com.te.empwebapp.beans.Products;
import com.te.empwebapp.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int id, String pwd) {
		if (id <= 0) {
			return null;
		} else {
			return dao.authenticate(id, pwd);
		}

	}

	@Override
	public Products getEmployeeData(int id) {
		if (id <= 0) {
			return null;
		}
		return dao.getEmployeeData(id);
	}

	@Override
	public boolean deleteEmpData(int id) {

		return dao.deleteEmpData(id);
	}

	@Override
	public boolean addEmployee(Products product) {
		return dao.addEmployee(product);
	}

	@Override
	public boolean updateRecord(Products product) {
		// TODO Auto-generated method stub
		return dao.updateRecord(product);
	}

	@Override
	public List<Products> getAllEmployees() {

		return dao.getAllEmployees();
	}

	

}