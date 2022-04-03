package persistence;

import entities.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SetsDAO {

    @Inject
    private EntityManager em;

    public List<Set> loadAll() {
        return em.createNamedQuery("Set.findAll", Set.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Set set){
        this.em.persist(set);
    }

    public Set findOne(Integer id) {
        return em.find(Set.class, id);
    }
}
