package com.Benjamin.CardGame;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class Main {

    static DeckMaker deck = new DeckMaker();

    static DealHands playerHand = new DealHands();
    static DealHands opponentLeft = new DealHands();
    static DealHands teamMatesHand = new DealHands();
    static DealHands opponentRight = new DealHands();

    int playerTeamScore = 0;
    int oppoentsTeamScore = 0;

//    Objects[] hands = new Objects[ new playerHand, opponentLeft, teamMatesHand, opponentRight];
//    ArrayList<Objects> handss = new ArrayList<Objects>() {playerHand, opponentLeft, teamMatesHand, opponentRight};

//    ArrayList<String> playerHand = new ArrayList<>(13);
//    ArrayList<String> opponentLeft = new ArrayList<>(13);
//    ArrayList<String> teamMatesHand = new ArrayList<>(13);
//    ArrayList<String> opponentRight = new ArrayList<>(13);

    //deck.setCompleteDeck

    String[] cardValues = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // All the different types of cards but jokers.
    String[] cardTypes = new  String[] {"C", "D", "H", "S" } ;  // Club, Diamonds, Hearts ands spades for each suit

    public static void main(String[] args) {
        // write your code here

        //deck.setCompleteDeck();
        //deck.getCompleteDeck();

        ArrayList<String> checkDeck = deck.getCompleteDeck(); // Getting the deck I plan to work with
        Collections.shuffle(checkDeck);  // This is a quick built in feature to shuffle the deck.
        //playerHand.getHand(checkDeck);
        ArrayList<String> playerHandArray =  playerHand.getHand(checkDeck); // Each player getting a random hand. With the last 13 cards in the deck for the last opponent
        // TODo sort the players hand for easier viewing.
        ArrayList<String> opponentLeftArray = opponentLeft.getHand(checkDeck);
        ArrayList<String> teamMatesHandArray = teamMatesHand.getHand(checkDeck);
        //ArrayList<String> opponentRightArray = opponentRight.getHand(checkDeck);  // Not sure this is needed because I can use the last 13 cards in the deck for the last person

        int PlayerTeamBooks = 0;
        int ComputerTeamBooks = 0;

        while (!gameOver(playerHandArray)) {

            String pickedCard = playerTurn(playerHandArray); // Getting a card from the hand
            //System.out.println(pickedCard);
            String leftOpponentPlayed = computerTurn(opponentLeftArray, pickedCard);
            String teamMatePlayed = computerTurn(teamMatesHandArray, pickedCard);
            String rightOpponentPlayed = computerTurn(checkDeck, pickedCard);

            System.out.println("Teamate: " + teamMatePlayed  );
            System.out.println(leftOpponentPlayed + " <-opponents-> " + rightOpponentPlayed  );
            System.out.println(" You:    "  + pickedCard);


            WhoWinsRound thisRound = new WhoWinsRound();
            boolean PointForBook = thisRound.getPlayerTeamWinners(pickedCard, teamMatePlayed, leftOpponentPlayed, rightOpponentPlayed);
            if (PointForBook == true) {
                PlayerTeamBooks++;
            } else {
                ComputerTeamBooks++;
            }
            System.out.println("Your team books are:" + PlayerTeamBooks + " Your oppoents books are: " + ComputerTeamBooks);

        }




        for (int i = 0; i < playerHandArray.size(); i++) {  // Used to outpring the deck showing the my work is going smoothly.
            System.out.print(" " + playerHandArray.get(i));
        }
        System.out.println();
        for (int i = 0; i < opponentLeftArray.size(); i++) {  // Used to outpring the deck showing the my work is going smoothly.
            System.out.print(" " + opponentLeftArray.get(i));
        }
        System.out.println();
        for (int i = 0; i < teamMatesHandArray.size(); i++) {  // Used to outpring the deck showing the my work is going smoothly.
            System.out.print(" " + teamMatesHandArray.get(i));
        }
//        System.out.println();
//        for (int i = 0; i < opponentRightArray.size(); i++) {  // Used to outpring the deck showing the my work is going smoothly.
//            System.out.print(" " + opponentRightArray.get(i));
//        }
        System.out.println();
        for (int i = 0; i < checkDeck.size(); i++) {  // Used to outpring the deck showing the my work is going smoothly.
            System.out.print(" " + checkDeck.get(i));
           // System.out.println("Hay"); // To make sure there is nothing left in the deck
        }



    }

    // Took this from the go fish game because it works so well. 
    public static boolean gameOver(ArrayList playerHandArray) { // To end the game if nothing left in hand.

        if (playerHandArray.isEmpty()) { // Not sure this will work???
            return true;
        } else {
            return false;
        }
    }

    public static String playerTurn(ArrayList playerHandArray) {

        String cardPlayed ; // To place the card they picked in this variable
        System.out.println("Your Hand is: "); // Used to show the players current hand.
        for (int i = 0; i < playerHandArray.size(); i++) {  //
            System.out.print(" " + playerHandArray.get(i));
        }
        System.out.println();
        boolean checkCardInHand = false;  // For  the do-while loop to

        do {
            Scanner scanCardInput = new Scanner(System.in); // Scanner started to see what the player wants to play
            System.out.println("Pick a card to play: "); // Letting them know to pick a card
            String cardPicked = scanCardInput.nextLine(); // Maybe not use nextline() ???
            cardPlayed = cardPicked; // Having my variable outside the loop become what was picked so I can send it back
            for (int i = 0; i < playerHandArray.size(); i++) {  // Scanning the player hand to make sure their pick matchs a card in their hand.
                  String compareMe = playerHandArray.get(i).toString();
                  if (cardPicked.equalsIgnoreCase(compareMe)) {
                      checkCardInHand = true; // Will break the loop if it is a card they have in thier hand
                      playerHandArray.remove(i); // Removing that card from thier hand.
                  }
            }
        } while (checkCardInHand == false); // Will continue the loop tell a card in their hand is picked.
        return cardPlayed; // Returning the card they pick.
    }

    public static String computerTurn(ArrayList computersHand, String pickedCard) {

        // make sure it matches the suit.
        char suitPlayed = pickedCard.charAt(pickedCard.length() -1);  // This should let us know whatever suit it is.
        char suitPlayedLowerCase = Character.toLowerCase(suitPlayed); // Making it lowercase for comparison purposes.
        for (int i = 0; i < computersHand.size(); i++) {  // This searching the hand for a matching suit
            String compareMe = computersHand.get(i).toString().toLowerCase();  //
            if (suitPlayedLowerCase == compareMe.charAt(compareMe.length() -1)) { // Seeing if they match suits
                computersHand.remove(i); // removes the card from the deck
                return compareMe;   // Returning the a card if suits match.
                // Should I change back to uppercase ???
            }
        }

        String cardComputerWillPlay = computersHand.get(0).toString(); // Default if no match found.
        computersHand.remove(0);
        return cardComputerWillPlay;
    }
}
