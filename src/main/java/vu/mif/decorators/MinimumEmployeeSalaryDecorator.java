package vu.mif.decorators;

import vu.mif.entities.Employee;
import vu.mif.exceptions.MinimumSalaryException;
import vu.mif.interfaces.IEmployeesDAO;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.math.BigDecimal;

@Decorator
public abstract class MinimumEmployeeSalaryDecorator implements IEmployeesDAO {

    private final BigDecimal minimalSalary = BigDecimal.valueOf(400);

    @Inject @Any @Delegate IEmployeesDAO employeesDAO;

    public void persist(Employee employee) throws MinimumSalaryException {
        if (employee.getSalary().compareTo(minimalSalary) == -1) {
            System.out.println("Employee cannot get less than ninimum salary, which is currently set to " + minimalSalary);
            throw new MinimumSalaryException("Employee cannot get less than ninimum salary, which is currently set to " + minimalSalary);
        }
        employeesDAO.persist(employee);
    }
}
