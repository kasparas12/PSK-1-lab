package vu.mif.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.entities.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Getter @Setter
public class ProjectsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Project> loadAll() {
        return em.createNamedQuery("Project.findAll", Project.class).getResultList();
    }

    public Project getById(Integer id) {
        return em.find(Project.class, id);
    }

    public void persist(Project project) {
        this.em.persist(project);
    }

    public Project merge(Project project) {
        return this.em.merge(project);
    }
}
