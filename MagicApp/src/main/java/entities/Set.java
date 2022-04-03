package entities;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Named
@Entity
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
}
