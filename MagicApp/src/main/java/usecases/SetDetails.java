package usecases;

import entities.Set;
import lombok.Getter;
import lombok.Setter;
import persistence.SetsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class SetDetails implements Serializable {

    @Inject
    private SetsDAO setsDAO;

    @Getter @Setter
    private Set set;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer setId = Integer.parseInt(requestParameters.get("setId"));
        this.set = setsDAO.findOne(setId);
    }


}
