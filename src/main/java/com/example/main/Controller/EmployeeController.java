 package com.example.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.main.Entity.Employee;
import com.example.main.Service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		
		List<Employee> allemp = service.getAllemp();
		m.addAttribute("emp", allemp);
		
		return "index";	
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,RedirectAttributes rd)
	{
		System.out.println(e);
		Employee e1=service.addEmp(e);
		if(e1!=null)
		{
			
			rd.addFlashAttribute("msg", "success");
			
		}
		
		return "redirect:/addemp";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id,Model m)
	{
	Employee e=service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,RedirectAttributes rd)
	{
		
		service.addEmp(e);
		rd.addFlashAttribute("msg", "success");
		return "redirect:/edit/"+e.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		service.deleteEmp(id);
		return "redirect:/";
	}
	
}
