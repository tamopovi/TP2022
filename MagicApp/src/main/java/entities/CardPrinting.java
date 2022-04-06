package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "CardPrinting.findAll", query = "select c from CardPrinting as c where  c.card.id = :cardId")
})
public class CardPrinting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @ManyToOne(optional = false)
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @ManyToOne(optional = false)
    private Set printedCardSet;

    public Set getPrintedCardSet() {
        return printedCardSet;
    }

    public void setPrintedCardSet(Set printedCardSet) {
        this.printedCardSet = printedCardSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardPrinting cardPrinting = (CardPrinting) o;
        return Objects.equals(id, cardPrinting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
