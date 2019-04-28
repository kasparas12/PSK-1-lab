package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.entities.Project;
import vu.mif.entities.Stage;
import vu.mif.persistence.EmployeesDAO;
import vu.mif.persistence.ProjectsDAO;
import vu.mif.persistence.StagesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class ProjectDetails {

    @Inject
    private ProjectsDAO projectsDAO;

    @Inject
    private StagesDAO stagesDAO;

    @Inject
    private EmployeesDAO employeesDAO;

    @Getter @Setter
    private String selectedEmployee;

    @Getter
    private List<Employee> allEmployees;

    @Getter @Setter
    private Project project;

    @Getter @Setter
    private Stage projectStageToCreate = new Stage();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer projectId = Integer.parseInt(requestParameters.get("projectId"));

        this.project = projectsDAO.getById(projectId);
        this.allEmployees = employeesDAO.loadAll();
    }

    @Transactional
    public String createStageToProject() {
        projectStageToCreate.setProject(this.project);
        this.stagesDAO.persist(projectStageToCreate);
        return "projects?faces-redirect=true&projectId=" + this.project.getId();
    }

    @Transactional
    public String addEmployeeToProject() {
        Employee emp = employeesDAO.findByFullName(selectedEmployee);
        emp.getProjectList().add(this.project);
        this.project.getEmployeeList().add(emp);
        employeesDAO.merge(emp);
        projectsDAO.merge(project);
       return "projects?faces-redirect=true&projectId=" + this.project.getId();
    }
}
