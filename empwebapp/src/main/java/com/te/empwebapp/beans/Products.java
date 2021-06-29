package com.te.empwebapp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Columns;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "products")
public class Products implements Serializable {
	@Id
	@Column
	private Integer pid;
	@Column
	private String pname;
	@Column
	private Date mgDate;
	@Column
	private Date exDate;
	@Column
	private Integer price;
	@Column
	private Integer quantity;
}