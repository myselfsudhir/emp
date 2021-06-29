package com.te.empwebapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.empwebapp.beans.EmployeeInfoBean;
import com.te.empwebapp.beans.Products;
import com.te.empwebapp.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder");
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String getEmpForm() {
		return "empLogin";
	}// getEmpForm

	
	@PostMapping("/login")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map,Products product) {
		
		if (id == 10 && password.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", product);
			map.addAttribute("id", id);
			return "employeeHome";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "empLogin";
		}
	}// authenticate

	@GetMapping("/searchPage")
	public String getSearchPage(HttpSession session, ModelMap map) {
		Products product = (Products) session.getAttribute("loggedIn");
		System.out.println(product);
		if (product != null) {
			System.out.println("valid");
			return "empSearchPage";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}// getSearchPage

	@GetMapping("/search")
	public String getEmployeeData(int id,
			@SessionAttribute(name = "loggedIn", required = false) Products prod, ModelMap map) {
		if (prod != null) {
			Products product = service.getEmployeeData(id);
			if (prod != null) {
				map.addAttribute("id", product);
			} else {
				map.addAttribute("errMsg", "Data not Found");
			}
			return "empSearchPage";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "empLogin";
	}// logout

	@GetMapping("/getDeleteForm")
	public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map) {
		if (prod != null) {
			return "deleteEmp";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}//

	@GetMapping("/delete")
	public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map) {
		if (prod != null) {
			if (service.deleteEmpData(id)) {
				map.addAttribute("msg", "Data Deleted successfully for id : " + id);
			} else {
				map.addAttribute("msg", "Could not find Record for id : " + id);
			}
			return "deleteEmp";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}

	}//

	@GetMapping("/addProducts")
	public String getAddFrom(@SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map) {
		if (prod != null) {
			return "insertEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}

	}//

	@PostMapping("/add")
	public String addEmployee(Products product,
			@SessionAttribute(name = "loggedIn", required = false) Products prod, ModelMap map) {
		if (prod != null) {
			if (service.addEmployee(product)) {
				map.addAttribute("msg", "Successfully Inserted");
			} else {
				map.addAttribute("msg", "Failed to Insert");
			}
			return "insertEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}

	}// add Employee

	@GetMapping("/updateProducts")
	public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map) {
		if (prod != null) {
			map.addAttribute("id", prod);
			return "updateEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";

		}
	}//

	@PostMapping("/update")
	public String updateEmployeeData(@SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map, Products product) {
		System.out.println(product);
		if (prod != null) {
			if (service.updateRecord(product)) {
				map.addAttribute("msg", "Updated Successfully");
				map.addAttribute("id", product);
			} else {
				map.addAttribute("msg", "Updation Failed");
				map.addAttribute("id", product);
			}
			return "updateEmployee";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}//

	@GetMapping("/getAll")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) Products prod,
			ModelMap map) {
		if (prod != null) {
			List<Products> product = service.getAllEmployees();
			if (product != null) {
				
				map.addAttribute("infos", product);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			map.addAttribute("name", prod.getPname());	
			return "employeeHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "empLogin";
		}
	}

}