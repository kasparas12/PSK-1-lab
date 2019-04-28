package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.mybatis.dao.EmployeeMapper;
import vu.mif.mybatis.model.Employee;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class EmployeesMyBatis {

    @Inject
    private EmployeeMapper employeeMapper;

    @Getter @Setter
    private Employee employeeToCreate = new Employee();

    @Getter
    private List<Employee> allEmployees = new ArrayList<>();

    @PostConstruct
    private void init() {
        loadAllEmployees();
    }

    private void loadAllEmployees() {
        this.allEmployees = employeeMapper.selectAll();
    }

    @Transactional
    public String createEmployee() {
        this.employeeMapper.insert(employeeToCreate);
        return "/myBatis/employees?faces-redirect=true";
    }
}
