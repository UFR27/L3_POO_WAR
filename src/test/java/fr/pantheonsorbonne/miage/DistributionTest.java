package fr.pantheonsorbonne.miage;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class DistributionTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testSizeCreatePacket()
    {
        Distribution dist = new Distribution();
        assertEquals(52,dist.getPacket().size());
        
    }
    @Test
    public void testAllDifferentCards()
    {
        Distribution dist = new Distribution();
        Set<Card> packetTest = new HashSet<>();
        for(Card i : dist.getPacket()){
            packetTest.add(i);
        }

        assertEquals(52,packetTest.size());
        
    }
    @Test
    public void newRandomHandSizeTest()
    {
        Distribution dist = new Distribution();
        List<Card> hand = dist.newRandomHand();
        assertEquals(8,hand.size());
    }
    @Test
    public void testAllDifferentCardsInHand()
    {
        Distribution dist = new Distribution();
        List<Card> hand = dist.newRandomHand();
        Set<Card> handTest = new HashSet<Card>();
        for(Card i : hand){
            handTest.add(i);
        }

        assertEquals(8,hand.size());
        
    }

    @Test
    public void CardsInHandRemovedInPacket()
    {
        Distribution dist = new Distribution();

        List<Card> hand = dist.newRandomHand();
        for(Card i : hand){
            assertFalse(dist.getPacket().contains(i));
        }

        assertEquals(44,dist.getPacket().size());
        
    }

    @Test
    public void getRandomCardTest()
    {
        Distribution dist = new Distribution();
        Card card = dist.getRandomCard();
        assertEquals(51,dist.getPacket().size());
        assertFalse(dist.getPacket().contains(card));
    }

}
