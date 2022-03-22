package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Set {
    private String id;

    @GeneratedValue
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String code;

    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private List<Card> setCardList;

    @ManyToMany
    public List<Card> getSetCardList(){
        return setCardList;
    }

    public void setSetCardList(List<Card> setCardList) {
        this.setCardList = setCardList;
    }
}
