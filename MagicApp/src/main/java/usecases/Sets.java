package usecases;



import entities.Set;
import lombok.Getter;
import lombok.Setter;
import persistence.SetsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Sets {

    @Inject
    private SetsDAO setsDAO;

    @Getter
    @Setter
    private Set setToCreate = new Set();

    @Getter
    private List<Set> allSets;

    @Getter
    private Set singleSet;

    @PostConstruct
    public void init(){
        loadAllSets();
    }

    @Transactional
    public void createSet(){
        this.setsDAO.persist(setToCreate);
    }

    private void loadAllSets(){
        this.allSets = setsDAO.loadAll();
    }

    private void loadSingleSet(Integer id){
        this.singleSet = setsDAO.findOne(id);
    }
}
