package entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "CardPrinting.findAll", query = "select c from CardPrinting as c")
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
}
