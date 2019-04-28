package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.mybatis.dao.EmployeeMapper;
import vu.mif.mybatis.model.Employee;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class ProjectsForEmployeeMyBatis {

    @Getter @Setter
    private Employee employee;

    @Inject
    private EmployeeMapper employeesMapper;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employee = employeesMapper.selectByPrimaryKey(employeeId);
    }
}
