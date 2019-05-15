package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.exceptions.MinimumSalaryException;
import vu.mif.interfaces.IEmployeesDAO;
import vu.mif.persistence.EmployeesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class Employees {

    @Inject
    private IEmployeesDAO employeesDAO;

    @Getter @Setter
    private Employee employeeToCreate = new Employee();

    @Getter
    private List<Employee> allEmployees = new ArrayList<>();

    @Getter
    private String error = null;
    @PostConstruct
    private void init() {
        loadAllEmployees();
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        error = requestParameters.get("error");
    }

    private void loadAllEmployees() {
        this.allEmployees = employeesDAO.loadAll();
    }

    @Transactional
    public String createEmployee() throws MinimumSalaryException {
        try {
            System.out.println("trying");
            employeesDAO.persist(employeeToCreate);
            System.out.println("tried");
            return "employees?faces-redirect=true";
        } catch (MinimumSalaryException e) {
            return "employees?faces-redirect=true&error=minimum-salary-error";
        }
    }
}
