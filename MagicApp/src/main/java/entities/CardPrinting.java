package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CardPrinting {
    private String id;

    @GeneratedValue
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Card card;

    @ManyToOne
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
