package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.interfaces.IEmployeesDAO;
import vu.mif.persistence.EmployeesDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class ProjectsForEmployee implements Serializable {

    public ProjectsForEmployee() {

    }
    @Getter @Setter
    private Employee employee;

    @Inject
    private IEmployeesDAO employeesDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employee = employeesDAO.getById(employeeId);
    }

    @Transactional
    public String UpdateEmployee() {
        try {
            this.employeesDAO.merge(this.employee);
        } catch (OptimisticLockException e) {
            return "/employeeProjects.xhtml?faces-redirect=true&employeeId=" + this.employee.getId() + "&error=optimistic-lock-exception";
        }
        return "/employeeProjects.xhtml?faces-redirect=true&employeeId=" + this.employee.getId();
    }
}
