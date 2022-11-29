package fr.pantheonsorbonne.miage;

public class LocalEngine {

    private  int nbAs = 0;
    private boolean asPicked = false;
    private boolean sevenStopped = false;
    private boolean playAgain = false;
    private String lastColorChosen = "";
    private int nextPlayer = 0;
    private int rotation = 0;
    private Player[] players = new Player[3];
    Distribution dist = new Distribution();
    protected void play(){

        Player malik = new Player("malik", dist.newRandomHand());
        Player ken = new Player("ken", dist.newRandomHand());
        Player herbaut = new Player("herbaut", dist.newRandomHand());
        players[0] =malik;
        players[1] =ken;
        players[2] =herbaut;


        dist.distributeFirstCardOnTheTable();

        while (true) {

            System.out.println(
                    "Carte jouée : " + dist.getPlayedCard().get(dist.getPacket().size() - 1).getValeur() + " "
                            + dist.getPlayedCard().get(dist.getPlayedCard().size() - 1).getCouleur());
            System.out.println();

            System.out.println("main de " + players[nextPlayer].getName());
            for (int i = 0; i < players[nextPlayer].getHand().size(); i++) {
                System.out.println(players[nextPlayer].getHand().get(i).getValeur() + " "
                        + players[nextPlayer].getHand().get(i).getCouleur());
            }

            System.out.println();

            playCard(players[nextPlayer]);
            if (players[nextPlayer].getHand().isEmpty()) {
                System.out.println(players[nextPlayer].getName() + " a gagné");
                break;
            }
           nextTurnIndex();

        }
    }

    public  void nextTurnIndex() {
        if (!playAgain) {
            if (rotation == 0) {
                nextPlayer++;
                if (nextPlayer >= players.length) {
                    nextPlayer = 0;
                }
            } else {
                nextPlayer--;
                if (nextPlayer < 0) {
                    nextPlayer = players.length - 1;
                }
            }
        } else {
            playAgain = false;
        }
    }

    public  void changeRotation() {
        rotation++;
        if (rotation > 1) {
            rotation = 0;
        }
    }

    public void pickCard(int number, Player player) {
        for (int i = 0; i < number; i++) {
            if (!dist.getPacket().isEmpty()) {
                player.getHand().add(dist.getRandomCard());
            } else {
                int initialSize = dist.getPlayedCard().size() - 1;
                for (int j = 0; j < initialSize; j++) {
                    dist.getPacket().add(dist.getPlayedCard().get(0));
                    dist.getPlayedCard().remove(0);
                }

                dist.getPlayedCard().add(dist.getPacket().get(dist.getPacket().size() - 1));
                number++;
            }
        }
    }

    public  String chooseColor(){
        String[] tabColor ={"PIQUE", "TREFLE", "COEUR", "CARREAU"};
        int max = 0;
        String maxColor = "";

        for(int j=0;j<4;j++){
            int count=0;
            for(int i=0; i<players[nextPlayer].getHand().size();i++){
                if(players[nextPlayer].getHand().get(i).getCouleur().equals(tabColor[j])){
                    count++;
                }
            }
            if(count>max){
                max=count;
                maxColor= tabColor[j];
            }
        }
        return maxColor;
    }

    public void plusTwo(Player player){
        pickCard(nbAs*2, player);
        nbAs=0;
    }

    public  void addAs(){
        nbAs++;
    }

    private void asPlayed(Player player) {
        for (int i = 0; i < player.getHand().size(); i++) {
            if (player.getHand().get(i).getValeur().equals("AS")) {
                addAs();
                dist.getPlayedCard().add(player.getHand().get(i));
                player.getHand().remove(i);
                return;
            }
        }
        addAs();
        plusTwo(player);
        asPicked = true;
    }

    private void playEight(int indexEight, Player player){
        dist.getPlayedCard().add(player.getHand().get(indexEight));
        player.getHand().remove(indexEight);
        asPicked = false;
        sevenStopped = false;
        lastColorChosen = chooseColor();
    }

    private void playCombination(String toCombinate, Player player){
        for (int j = 0; j < player.getHand().size(); j++) {
            if (toCombinate.equals(player.getHand().get(j).getValeur())) {
                dist.getPlayedCard().add(player.getHand().get(j));
                if (player.getHand().get(j).getValeur().equals("VALET") && players.length != 2) {
                    changeRotation();
                }
                player.getHand().remove(j);
            }
        }
    }

    public void playCard(Player player) {
        Card lastPlayedCard = dist.getPlayedCard().get(dist.getPlayedCard().size() - 1);
        String lastColor = lastPlayedCard.getCouleur();
        String lastValue = lastPlayedCard.getValeur();

        if (lastValue.equals("HUIT")) {
            lastColor = lastColorChosen;
        }

        else if (lastValue.equals("SEPT") && !sevenStopped) {
            sevenStopped = true;
            return;
        }

        else if (lastValue.equals("AS") && !asPicked) {
            asPlayed(player);
            return;
        }

        int indexEight = -1;

        for (int i = 0; i < player.getHand().size(); i++) {

            if ((lastColor.equals(player.getHand().get(i).getCouleur()) || lastValue.equals(player.getHand().get(i).getValeur()))
                    && !player.getHand().get(i).getValeur().equals("HUIT")) {
                dist.getPlayedCard().add(player.getHand().get(i));
                if (player.getHand().get(i).getValeur().equals("DIX")) {
                    playAgain = true;
                } else if (player.getHand().get(i).getValeur().equals("VALET")) {
                    if (players.length == 2) {
                        playAgain = true;
                    } else {
                        changeRotation();
                    }
                }
                String toCombinate = player.getHand().get(i).getValeur();
                player.getHand().remove(i);
                // combination of cards

                if (!toCombinate.equals("AS")) {
                    playCombination(toCombinate, player);
                }
                asPicked = false;
                sevenStopped = false;
                return;
            }
            if (player.getHand().get(i).getValeur().equals("HUIT")) {
                indexEight = i;
            }
        }

        if (indexEight != -1) {
            playEight(indexEight, player);
            return;
        }

        pickCard(1, player);
    }
}
