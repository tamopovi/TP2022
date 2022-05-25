package usecases;

import entities.Card;
import entities.Set;
import lombok.Getter;
import lombok.Setter;
import persistence.CardsDAO;
import persistence.SetsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class CardDetails implements Serializable {

    @Inject
    private CardsDAO cardsDAO;

    @Getter @Setter
    private Card card;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer cardId = Integer.parseInt(requestParameters.get("cardId"));
        this.card = cardsDAO.findOne(cardId);
    }
}
