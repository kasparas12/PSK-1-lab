package vu.mif.persistence;

import lombok.Getter;
import lombok.Setter;
import vu.mif.entities.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@Getter @Setter
public class StagesDAO {
    @PersistenceContext
    private EntityManager em;

    public void persist(Stage stage) {
        this.em.persist(stage);
    }
}
