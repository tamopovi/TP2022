package processors;

import entities.Card;
import processors.interfaces.CardProcessor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

// marks new card names as Work In Progress
@Alternative
@ApplicationScoped
public class WIPCardProcessor implements CardProcessor {

    public WIPCardProcessor(){

    }


    @Override
    public Card processCard(Card c) {
        System.out.println("Process card at WIPCardProcessor");
        String currentName = c.getName();
        c.setName("[WIP]"+currentName);
        return c;
    }
}
