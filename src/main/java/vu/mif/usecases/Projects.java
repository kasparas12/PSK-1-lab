package vu.mif.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Project;
import vu.mif.persistence.ProjectsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Projects {

    @Inject
    private ProjectsDAO projectsDAO;

    @Getter @Setter
    private Project projectToCreate = new Project();

    @Getter
    private List<Project> allProjects = new ArrayList<>();

    @PostConstruct
    private void init() {
        loadAllProjects();
    }

    private void loadAllProjects() {
        this.allProjects = projectsDAO.loadAll();
    }

    @Transactional
    public String createProject() {
        this.projectsDAO.persist(projectToCreate);
        return "index?faces-redirect=true";
    }
}
