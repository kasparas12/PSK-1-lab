package vu.mif.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Employee;
import vu.mif.interceptors.AuditedRequest;
import vu.mif.interfaces.IEmployeesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Getter @Setter
public class EmployeesDAO implements IEmployeesDAO, Serializable {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> loadAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    @Override
    public void persist(Employee employee) {
        System.out.println("Persisting...");
        this.em.persist(employee);
    }

    @Override
    public Employee findByFullName(String fullName) {
        return em.createNamedQuery("Employee.findByFullName", Employee.class).setParameter("fullName", fullName).getSingleResult();
    }

    @Override
    public Employee merge(Employee employee) {
        return this.em.merge(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return em.find(Employee.class, id);
    }

}
