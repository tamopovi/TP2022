package entities;

import javax.inject.Named;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Named
@Entity
@Table(name = "card")
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

    public void print() {
        System.out.println("CARD: ");
        System.out.println("Id: " + this.getId());
        System.out.println("Name: " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
