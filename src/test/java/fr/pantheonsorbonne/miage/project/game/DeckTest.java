package fr.pantheonsorbonne.miage.project.game;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeckTest {

    
    /** deckCreation Tests */
    @Test
    void deckCreationHas52Cards() {
        Deck newDeck = new Deck();
        
        assertEquals(52, newDeck.deckCreation().size());

    }

    @Test
    void isHeartSevenExist(){
        Deck newDeck = new Deck();
        
        Card HeartSeven = new Card("SEVEN", "HEARTS");

        assertTrue(newDeck.deckCreation().contains(HeartSeven));
    }

    @Test
    void cardsAreUnique(){
        Deck newDeck = new Deck();
        Set<Card> s =new HashSet<Card>((newDeck.deckCreation()));

        assertTrue(s.size()== newDeck.deckCreation().size());
    }

    @Test
    void testDeckCreation() {

    }
}
