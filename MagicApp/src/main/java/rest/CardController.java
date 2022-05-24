package rest;

import entities.Card;
import entities.CardPrinting;
import entities.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/card")
@Produces(MediaType.APPLICATION_JSON)
public class CardController {
    @Inject
    private EntityManager em;

    @Path("/{cardId}")
    @GET
    public Response find(@PathParam("cardId") Integer id) {
        Card cardEntity = em.find(Card.class, id);
        CardDTO cardDTO = new CardDTO();
        cardDTO.setName(cardEntity.getName());
        cardDTO.setCardSets(cardEntity.getCardSets().stream().map(Set::getName).collect(Collectors.toList()));
        cardDTO.setCardPrintings(cardEntity.getCardPrintings().stream().map(CardPrinting::getId).collect(Collectors.toList()));
        return Response.ok(cardDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CardDTO cardData) {
        Card newCard = new Card();
        newCard.setName(cardData.getName());
        em.persist(newCard);
        return Response.ok().build();
    }

    @Path("/{cardId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(CardDTO cardData, @PathParam("cardId") Integer id)
    {
        Card card = em.find(Card.class, id);
        if (card == null) {
            throw new IllegalArgumentException("cardId " + id + " not found");
        }
        card.setName(cardData.getName());
        em.merge(card);
        return Response.ok(card).build(); // low level API
    }
}