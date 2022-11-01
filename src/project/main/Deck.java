package src.project;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;



public class Deck {

    protected static LinkedList<Card> deck = new LinkedList<Card>();
    private final String [] NAMES = {"ACE", "KING", "QUEEN", "JACK", "TEN", "NINE", "EIGHT", "SEVEN","SIX", "FIVE", "FOUR", "THREE", "TWO"}; // les 8 valeurs constantes
    private final String [] COLORS = {"COEUR", "CARREAU", "TREFLE", "PIQUE"}; // les 4 couleurs constantes
    private static Random random = new Random();
    
    protected List<Card> deckCreation(){ // création des 32 cards et ne retourne rien
        LinkedList<Card> deck = new LinkedList<Card>();
        for(String name : NAMES){ // parcours des valeurs constantes
            for(String couleur : COLORS){ 
                Card card = new Card(name, couleur); // appel à la classe Card pour créer un objet card
                deck.add(card); // et l'ajouter au deck
            }
        }
        return deck;
    }

    
    protected Queue<Card> ArrayToQueue(LinkedList<Card> deck){
        Queue<Card> finalDeck = new PriorityQueue<Card>(); //empty
        while(!deck.isEmpty()){
            int x = random.nextInt(deck.size()-1);
            finalDeck.add(deck[x]);
            deck.remove(x);
        }


   
        return finalDeck;
    }

}
