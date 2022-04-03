package persistence;

import entities.Card;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CardsDAO {

    @Inject
    private EntityManager em;

    public List<Card> loadAll() {
        return em.createNamedQuery("Card.findAll", Card.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Card card){
        this.em.persist(card);
    }

    public Card findOne(Integer id) {
        return em.find(Card.class, id);
    }
}
