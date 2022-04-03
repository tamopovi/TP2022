package entities;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Named
@Entity
@NamedQueries({
        @NamedQuery(name = "Card.findAll", query = "select c from Card as c")
})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    private String name;

    @Basic(optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "card")
    List<CardPrinting> cardPrintings;


    public void setCardPrintings(List<CardPrinting> cardPrintings) {
        this.cardPrintings = cardPrintings;
    }

    public List<CardPrinting> getCardPrintings(){
        return cardPrintings;
    }

    @ManyToMany(mappedBy = "setCardList")
    private List<Set> cardSets;

    public List<Set> getCardSets(){
        return cardSets;
    }

    public void setCardSets(List<Set> cardSets) {
        this.cardSets = cardSets;
    }
}
