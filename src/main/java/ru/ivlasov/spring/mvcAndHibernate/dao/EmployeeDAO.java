package ru.ivlasov.spring.mvcAndHibernate.dao;

import ru.ivlasov.spring.mvcAndHibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee e);

    public Employee findEmployeeById(int id);

    public void deleteEmployee(int id);
}
