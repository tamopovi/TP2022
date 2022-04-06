package usecases;



import entities.Card;
import entities.CardPrinting;
import entities.Set;
import lombok.Getter;
import lombok.Setter;
import persistence.CardPrintingsDAO;
import persistence.CardsDAO;
import persistence.SetsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Model
public class CardPrintings {

    @Getter @Setter
    private Integer printedSetId;

    @Inject
    private CardPrintingsDAO cardPrintingsDAO;

    @Inject
    private SetsDAO setsDAO;

    @Inject
    private CardsDAO cardsDAO;

    @Getter
    @Setter
    private CardPrinting cardPrintingToCreate = new CardPrinting();

    @Getter
    @Setter
    private Card card;

    @Getter
    @Setter
    private Set set;

    @Getter
    private List<CardPrinting> allCardPrintings;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer cardId = Integer.parseInt(requestParameters.get("cardId"));
        this.card = cardsDAO.findOne(cardId);
        loadAllCardPrintings(cardId);
    }

    @Transactional
    public void createCardPrinting(){
        cardPrintingToCreate.setCard(this.card);
        this.set = this.setsDAO.findOne(printedSetId);
        cardPrintingToCreate.setPrintedCardSet(this.set);

//        System.out.println("HERE CARD: " + cardPrintingToCreate.getCard());
//        System.out.println("HERE SET: " + cardPrintingToCreate.getPrintedCardSet());
//        cardPrintingToCreate.getCard().print();
//        cardPrintingToCreate.getPrintedCardSet().print();
        List<Card> currentSetCardList = this.set.getSetCardList();
        List<Card> newSetCardList =
                Stream.concat(currentSetCardList.stream(), Stream.of(this.card))
                        .collect(Collectors.toList());
        this.set.setSetCardList(newSetCardList);
        this.setsDAO.persist(this.set);
        this.cardPrintingsDAO.persist (cardPrintingToCreate);
    }

    private void loadAllCardPrintings(Integer byCardId) {
        this.allCardPrintings = cardPrintingsDAO.loadAll(byCardId);
    }

}
