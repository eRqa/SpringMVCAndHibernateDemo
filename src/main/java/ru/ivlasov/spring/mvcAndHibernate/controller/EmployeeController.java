package ru.ivlasov.spring.mvcAndHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ivlasov.spring.mvcAndHibernate.entity.Employee;
import ru.ivlasov.spring.mvcAndHibernate.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", employeeList);
        return "allEmployees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeInfo";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("id") int id, Model model) {
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        return "employeeInfo";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
       employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
