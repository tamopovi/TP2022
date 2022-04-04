package usecases;



import entities.CardPrinting;
import lombok.Getter;
import lombok.Setter;
import persistence.CardPrintingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CardPrintings {

    @Inject
    private CardPrintingsDAO cardPrintingsDAO;

    @Getter
    @Setter
    private CardPrinting cardPrintingToCreate = new CardPrinting();

    @Getter
    private List<CardPrinting> allCardPrintings;

    @Getter
    private CardPrinting singleCardPrinting;

    @PostConstruct
    public void init(){
        loadAllCardPrintings();
    }

    @Transactional
    public void createCardPrinting(){
        this.cardPrintingsDAO.persist (cardPrintingToCreate);
    }

    private void loadAllCardPrintings() {
        this.allCardPrintings = cardPrintingsDAO.loadAll();
    }

    private void loadSingleCardPrinting(Integer id){
        this.singleCardPrinting = cardPrintingsDAO.findOne(id);
    }
}
