package usecases;

import services.CardNameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateCardName implements Serializable {
    @Inject
    CardNameGenerator cardNameGenerator;

    private CompletableFuture<String> cardNameGenerationTask = null;

    public String generateNewCardName() {

        cardNameGenerationTask = CompletableFuture.supplyAsync(() -> cardNameGenerator.generateCardName());
        System.out.println("GENERATE NEW CARD NAME TASK");

        return  "/cards.xhtml?faces-redirect=true";
    }

    public boolean isNameGenerationRunning() {
        return cardNameGenerationTask != null && !cardNameGenerationTask.isDone();
    }

    public String getJerseyGenerationStatus() throws ExecutionException, InterruptedException {
        System.out.println("cardNameGenerationTask: " + cardNameGenerationTask);
        if (cardNameGenerationTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Name generation in progress";
        }
        return "Suggested card name: " + cardNameGenerationTask.get();
    }
}
