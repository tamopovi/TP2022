package persistence;

import entities.Card;
import entities.CardPrinting;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CardPrintingsDAO {

    @Inject
    private EntityManager em;

    public List<CardPrinting> loadAll() {
        return em.createNamedQuery("CardPrinting.findAll", CardPrinting.class).getResultList();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(CardPrinting cardPrinting){
        this.em.persist(cardPrinting);
    }

    public CardPrinting findOne(Integer id) {
        return em.find(CardPrinting.class, id);
    }
}
