package usecases;



import entities.Card;
import lombok.Getter;
import lombok.Setter;
import persistence.CardsDAO;
import processors.interfaces.CardProcessor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Cards {

    @Inject
    private CardsDAO cardsDAO;

    @Inject
    private CardProcessor cardProcessor;

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
        System.out.println("CARD TO CREATE");
        cardToCreate.print();
        Card processedCard = cardProcessor.processCard(cardToCreate);
        System.out.println("PROCESSED CARD");
        processedCard.print();
        this.cardsDAO.persist (processedCard);
    }

    private void loadAllCards(){
        this.allCards = cardsDAO.loadAll();
    }

//    private void loadSingleCard(Integer id){
//        this.singleCard = cardsDAO.findOne(id);
//    }
}
