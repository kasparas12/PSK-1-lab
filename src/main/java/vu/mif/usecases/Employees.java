package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.persistence.EmployeesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Employees {

    @Inject
    private EmployeesDAO employeesDAO;

    @Getter @Setter
    private Employee employeeToCreate = new Employee();

    @Getter
    private List<Employee> allEmployees = new ArrayList<>();

    @PostConstruct
    private void init() {
        loadAllEmployees();
    }

    private void loadAllEmployees() {
        this.allEmployees = employeesDAO.loadAll();
    }

    @Transactional
    public String createEmployee() {
        this.employeesDAO.persist(employeeToCreate);
        return "employees?faces-redirect=true";
    }
}
