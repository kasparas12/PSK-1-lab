package vu.mif.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Getter @Setter
public class EmployeesDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> loadAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public void persist(Employee employee) {
        this.em.persist(employee);
    }

    public Employee findByFullName(String fullName) {
        return em.createNamedQuery("Employee.findByFullName", Employee.class).setParameter("fullName", fullName).getSingleResult();
    }

    public Employee merge(Employee employee) {
        return this.em.merge(employee);
    }
    public Employee getById(Integer id) {
        return em.find(Employee.class, id);
    }

}
