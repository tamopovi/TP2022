package usecases;



import entities.Card;
import entities.Set;
import lombok.Getter;
import lombok.Setter;
import persistence.CardsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Cards {

    @Inject
    private CardsDAO cardsDAO;

    @Getter
    @Setter
    private Card cardToCreate = new Card();

    @Getter
    private List<Card> allCards;

    @Getter
    private Card singleCard;

    @PostConstruct
    public void init(){
        loadAllCards();
    }

    @Transactional
    public void createCard(){
        this.cardsDAO.persist (cardToCreate);
    }

    private void loadAllCards(){
        this.allCards = cardsDAO.loadAll();
    }

    private void loadSingleCard(Integer id){
        this.singleCard = cardsDAO.findOne(id);
    }
}
