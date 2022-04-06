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

    @Getter
    private CardPrinting singleCardPrinting;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer cardId = Integer.parseInt(requestParameters.get("cardId"));
        this.card = cardsDAO.findOne(cardId);
    }

    @Transactional
    public void createCardPrinting(){
        cardPrintingToCreate.setCard(this.card);
        this.set = this.setsDAO.findOne(printedSetId);
        cardPrintingToCreate.setPrintedCardSet(this.set);

        System.out.print("HERE CARD: " + cardPrintingToCreate.getCard());
        System.out.print("HERE SET: " + cardPrintingToCreate.getPrintedCardSet());
        this.cardPrintingsDAO.persist (cardPrintingToCreate);
    }

    private void loadAllCardPrintings() {
        this.allCardPrintings = cardPrintingsDAO.loadAll();
    }

    private void loadSingleCardPrinting(Integer id){
        this.singleCardPrinting = cardPrintingsDAO.findOne(id);
    }
}
