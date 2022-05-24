package rest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardDTO {
    private String name;
    private List<String> cardSets;
    private List<Integer> cardPrintings;
}
