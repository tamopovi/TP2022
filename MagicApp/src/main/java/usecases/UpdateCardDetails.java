package usecases;


import lombok.Getter;
import lombok.Setter;
import interceptors.LoggedInvocation;
import persistence.CardsDAO;
import entities.Card;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateCardDetails implements Serializable {

    private Card card;

    @Inject
    private CardsDAO cardsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateCardDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer cardId = Integer.parseInt(requestParameters.get("cardId"));
        this.card = cardsDAO.findOne(cardId);
    }

    @Transactional
    @LoggedInvocation
    public String updateCardName() {
        try{
            cardsDAO.update(this.card);
        } catch (OptimisticLockException e) {
            return "/cardDetails.xhtml?faces-redirect=true&cardId=" + this.card.getId() + "&error=optimistic-lock-exception";
        }
        return "/cardDetails.xhtml?cardId=" + this.card.getId() + "&faces-redirect=true";
    }
}
