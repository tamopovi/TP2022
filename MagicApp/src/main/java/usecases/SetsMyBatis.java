package usecases;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.SetMapper;
import mybatis.model.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class SetsMyBatis {
    @Inject
    SetMapper setMapper;

    @Getter
    private List<Set> allSets;

    @Getter @Setter
    private Set setToCreate = new Set();

    @PostConstruct
    public void init(){
        loadAllSets();
    }

    @Transactional
    public void createSet(){
        setMapper.insert(setToCreate);
    }

    private void loadAllSets(){
        this.allSets = setMapper.selectAll();
    }
}
