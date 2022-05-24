package services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class CardNameGenerator implements Serializable {

    public String generateCardName() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        String[] adjectives = {"Big",
                "Gigantic",
                "Bad",
                "Evil",
                "Scary",
                "Creepy",
                "Beautiful",
                "Majestic",
                "Deluxe",
                "Red",
                "Green",
                "Blue",
                "Fearful",
                "Powerful"
        };
        String[] nouns = {
                "Shard",
                "Survivor",
                "Alchemy",
                "Magic Spell",
                "World",
                "Sixth Sense",
                "Thunderclap",
                "Turning",
                "Energy",
                "Monster",
                "Ground",
                "Society",
                "Tarot Card",
                "Spirit",
                "Strike Down",
                "Shoreline",
                "Third Eye",
                "Radiation",
                "Black Magic",
                "Burn Mark",
                "Explosion",
                "Knight",
                "Mercury",
                "Contempt",
                "Psychic",
                "Gentle Wind",
                "Stare Down",
                "Pandemonium",
                "Necromancer",
                "Dreaming",
                "Spirit World",
                "Interloper",
                "Wind",
                "Nightmare",
                "Wizardry",
                "Whisperer",
                "Wizard",
                "Mystic",
                "Dungeon",
                "Moonbeam",
                "Retribution",
                "Melancholy",
                "Magnetic North",
                "Stronghold",
                "Watchman",
                "Fang",
                "Figure",
                "Throw Back",
                "Defender",
                "Vampire",
                "Limit",
                "Shadows",
                "Mayhem",
                "Candlelight",
                "Breaking Point",
                "Crossroads",
                "Sunburst",
                "Resistance",
                "Viper",
                "Apprentice",
                "Magical Power",
                "Countermeasure",
                "Folklore",
                "Sorcery",
                "Underworld"
        };
        String newName = adjectives[new Random().nextInt(adjectives.length)] + ' ' + nouns[new Random().nextInt(nouns.length)];
        System.out.println("newName: " + newName);
        return newName;
    }
}