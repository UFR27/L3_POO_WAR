package fr.pantheonsorbonne.miage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class CarteJouerTest {
    /* 
    
    @Test
    public void firstCardAddedToPlayedCard(){
        Distribution.createPacket();
        CarteJouer.firstCard();

        boolean isSimpleCard = true;

        assertTrue(!CarteJouer.playedCard.isEmpty());

        for(int i =0;i<50;i++){
            Distribution.createPacket();
            CarteJouer.firstCard();
            if(CarteJouer.playedCard.getFirst().getValeur().equals("AS") || CarteJouer.playedCard.getFirst().getValeur().equals("VALET") || CarteJouer.playedCard.getFirst().getValeur().equals("DIX")
            || CarteJouer.playedCard.getFirst().getValeur().equals("SEPT") || CarteJouer.playedCard.getFirst().getValeur().equals("HUIT")){
                isSimpleCard = false;
            }
        }

        assertTrue(isSimpleCard);


    }
    
    @Test
    public void firstCardDeleteFromPacket(){
        Distribution.createPacket();
        CarteJouer.firstCard();
        boolean isDeleteFromPacket = true;
        for(Card i : Distribution.packet){
            if(i.getCouleur().equals(CarteJouer.playedCard.getFirst().getCouleur())&&i.getValeur().equals(CarteJouer.playedCard.getFirst().getValeur())){
                isDeleteFromPacket = false;
            }
        }

        assertTrue(isDeleteFromPacket);
    }

    @Test
    public void firstCardIsSimple(){
        boolean isSimpleCard = true;

        //Tested 50 times
        for(int i =0;i<50;i++){
            Distribution.createPacket();
            CarteJouer.firstCard();
            if(CarteJouer.playedCard.getFirst().getValeur().equals("AS") || CarteJouer.playedCard.getFirst().getValeur().equals("VALET") || CarteJouer.playedCard.getFirst().getValeur().equals("DIX")
            || CarteJouer.playedCard.getFirst().getValeur().equals("SEPT") || CarteJouer.playedCard.getFirst().getValeur().equals("HUIT")){
                isSimpleCard = false;
            }
        }

        assertTrue(isSimpleCard);

    }
    */

}
