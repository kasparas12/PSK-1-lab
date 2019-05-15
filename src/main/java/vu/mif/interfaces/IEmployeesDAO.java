package vu.mif.interfaces;

import vu.mif.entities.Employee;
import vu.mif.exceptions.MinimumSalaryException;

import java.util.List;

public interface IEmployeesDAO {
    List<Employee> loadAll();
    void persist(Employee employee) throws MinimumSalaryException;
    Employee findByFullName(String fullName);
    Employee merge(Employee employee);
    Employee getById(Integer id);
}
