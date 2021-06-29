package com.te.empwebapp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean implements Serializable{
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
//	@DateTimeFormat(iso = ISO.DATE)
	private Date dob;
	
	@Column
	private String password;

}