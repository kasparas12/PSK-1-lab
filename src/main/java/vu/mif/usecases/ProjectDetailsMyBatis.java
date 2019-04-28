package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.mybatis.dao.EmployeeMapper;
import vu.mif.mybatis.dao.EmployeeProjectMapper;
import vu.mif.mybatis.dao.ProjectMapper;
import vu.mif.mybatis.dao.StageMapper;
import vu.mif.mybatis.model.Employee;
import vu.mif.mybatis.model.EmployeeProject;
import vu.mif.mybatis.model.Project;
import vu.mif.mybatis.model.Stage;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class ProjectDetailsMyBatis {

    @Inject
    ProjectMapper projectMapper;

    @Inject
    EmployeeMapper employeeMapper;

    @Inject
    StageMapper stageMapper;

    @Inject
    EmployeeProjectMapper employeeProjectMapper;

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

        this.project = projectMapper.selectByPrimaryKey(projectId);
        this.allEmployees = employeeMapper.selectAll();
    }

    @Transactional
    public String createStageToProject() {
       projectStageToCreate.setProjectId(this.project.getId());
       projectStageToCreate.setProject(this.project);
       stageMapper.insert(projectStageToCreate);

       return "/myBatis/projects?faces-redirect=true&projectId=" + this.project.getId();
    }

    @Transactional
    public String addEmployeeToProject() {
        Employee emp = employeeMapper.findByFullName(selectedEmployee);

        EmployeeProject ep = new EmployeeProject();
        ep.setEmployeeId(emp.getId());
        ep.setProjectId(project.getId());
        employeeProjectMapper.insert(ep);
        return "projects?faces-redirect=true&projectId=" + this.project.getId();
    }
}
