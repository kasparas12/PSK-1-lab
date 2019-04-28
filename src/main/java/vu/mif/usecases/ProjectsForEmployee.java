package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.persistence.EmployeesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class ProjectsForEmployee {

    @Getter @Setter
    private Employee employee;

    @Inject
    private EmployeesDAO employeesDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employee = employeesDAO.getById(employeeId);
    }
}
