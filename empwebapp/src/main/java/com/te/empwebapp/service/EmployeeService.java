package com.te.empwebapp.service;

import java.util.List;

import com.te.empwebapp.beans.EmployeeInfoBean;
import com.te.empwebapp.beans.Products;

public interface EmployeeService {

	public EmployeeInfoBean authenticate(int id, String pwd);

//	public EmployeeInfoBean getEmployeeData(int id);
	public Products getEmployeeData(int id);

	public boolean deleteEmpData(int id);
	
//	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean addEmployee(Products product);
	
	public boolean updateRecord(Products product);
	
	public List<Products> getAllEmployees();
}