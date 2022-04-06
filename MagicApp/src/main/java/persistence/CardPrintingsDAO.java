package persistence;

import entities.Card;
import entities.CardPrinting;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CardPrintingsDAO {

    @Inject
    private EntityManager em;

    public List<CardPrinting> loadAll(Integer cardId) {
        Query query = em.createNamedQuery("CardPrinting.findAll", CardPrinting.class);
        query.setParameter("cardId",cardId );
        return query.getResultList();
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
