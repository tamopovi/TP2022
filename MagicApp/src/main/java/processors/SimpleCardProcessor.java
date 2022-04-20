package processors;

import entities.Card;
import processors.interfaces.CardProcessor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleCardProcessor implements CardProcessor {
    public SimpleCardProcessor(){

    }

    public Card processCard(Card c) {
        return c;
    }
}
