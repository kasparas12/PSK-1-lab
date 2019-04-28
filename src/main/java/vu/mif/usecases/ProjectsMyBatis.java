package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.mybatis.dao.ProjectMapper;
import vu.mif.mybatis.model.Project;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ProjectsMyBatis {

    @Inject
    ProjectMapper projectMapper;

    @Getter
    List<Project> allProjects;

    @Getter @Setter
    Project projectToCreate = new Project();

    @PostConstruct
    public void init() {
        this.loadAllProjects();
    }

    private void loadAllProjects() {
        this.allProjects = projectMapper.selectAll();
    }

    @Transactional
    public String createProject() {
        projectMapper.insert(projectToCreate);
        return "/myBatis/index.xhtml?faces-redirect=true";
    }
}
