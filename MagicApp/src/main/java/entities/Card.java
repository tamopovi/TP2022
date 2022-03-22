package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Card {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
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

    List<CardPrinting> cardPrintings;

    @OneToMany(mappedBy = "card")
    public List<CardPrinting> getCardPrintings(){
        return cardPrintings;
    }

    public void setCardPrintings(List<CardPrinting> cardPrintings){
        this.cardPrintings = cardPrintings;
    }

    private List<Set> cardSets;

    @ManyToMany(mappedBy = "setCardList")
    public List<Set> getCardSets(){
        return cardSets;
    }

    public void setCardSets(List<Set> cardSets) {
        this.cardSets = cardSets;
    }
}
