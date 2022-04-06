package entities;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Named
@Entity
@Table(name = "set")
@NamedQueries({
        @NamedQuery(name = "Set.findAll", query = "select s from Set as s")
})
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(max = 3,min = 3)
    private String code;

    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToMany
    private List<Card> setCardList;


    public List<Card> getSetCardList(){
        return setCardList;
    }

    public void setSetCardList(List<Card> setCardList) {
        this.setCardList = setCardList;
    }

    @OneToMany(mappedBy = "printedCardSet")
    private List<CardPrinting> printedCardSet;

    public List<CardPrinting> getPrintedCardSet() {
        return printedCardSet;
    }

    public void setPrintedCardSet(List<CardPrinting> printedCardSet) {
        this.printedCardSet = printedCardSet;
    }

    public void print() {
        System.out.println("SET: ");
        System.out.println("Id: " + this.getId());
        System.out.println("Name: " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return Objects.equals(id, set.id) &&
                Objects.equals(name, set.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
