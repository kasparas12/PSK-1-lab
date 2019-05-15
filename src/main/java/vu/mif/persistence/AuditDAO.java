package vu.mif.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.AuditEntry;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
@Getter
@Setter
public class AuditDAO {

    @PersistenceUnit(unitName="ProjectManagementPU")
    private EntityManagerFactory emf;

    public void save(AuditEntry entry) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entry);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
