package fr.pantheonsorbonne.miage;
import java.util.ArrayList;

public class Local {
    public static void main(String[] args){
        Distribution.createPacket();
        Player malik = new Player("malik", Distribution.newRandomHand());
        Player ken = new Player("ken", Distribution.newRandomHand());

        System.out.println("Main de malik : ");
        for(int i = 0;i<malik.getHand().size();i++){
            System.out.println(malik.getHand().get(i).getValeur()+" "+malik.getHand().get(i).getCouleur());
        }

        System.out.println();

        System.out.println("Main de ken : ");
        for(int i = 0;i<ken.getHand().size();i++){
            System.out.println(ken.getHand().get(i).getValeur()+" "+ken.getHand().get(i).getCouleur());
        }
        
        System.out.println();

        Player[] players = {malik,ken};
        Turn tour = new Turn(2, players);

        CarteJouer.firstCard();
        while(true){

            players[Turn.nextPlayer].playCard();
            if(players[Turn.nextPlayer].getHand().isEmpty()){
                System.out.println(players[Turn.nextPlayer].getName() + " a gagné");
                break;
            }
            Turn.nextTurnIndex();

            

            /* 
            System.out.println(CarteJouer.playedCard.get(CarteJouer.playedCard.size()-1).getValeur()+" "+CarteJouer.playedCard.get(CarteJouer.playedCard.size()-1).getCouleur());
            malik.playCard();
            if(malik.getHand().isEmpty()){
                System.out.println("malik gagne");
                break;
            }
            System.out.println(CarteJouer.playedCard.get(CarteJouer.playedCard.size()-1).getValeur()+" "+CarteJouer.playedCard.get(CarteJouer.playedCard.size()-1).getCouleur());

            ken.playCard();
            if(ken.getHand().isEmpty()){
                System.out.println("ken gagne");
                break;
            }
            */

        }
       
    }
}
