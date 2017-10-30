package com.Benjamin.CardGame;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

class DeckMaker {

    //String[] completeDeck = new String[52];
    ArrayList<String> completeDeck = new ArrayList<>(52);  // This arrayList will become a complete deck of cards meant to return to main()

//    String[] cardValues = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // All the different types of cards but jokers.
//    String[] cardTypes = new  String[] {"C", "D", "H", "S" } ;  // Club, Diamonds, Hearts ands spades for each suit

    public ArrayList<String> getCompleteDeck() {  // What is used to call for a new deck
        setCompleteDeck();  // Making the deck

        return completeDeck; // Sending the dect back to main()
    }

    void setCompleteDeck() {
        // Below is both card numbers or ace or royality and card type
        String[] cardValues = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // All the different types of cards but jokers.
        String[] cardTypes = new  String[] {"C", "D", "H", "S" } ;  // Club, Diamonds, Hearts ands spades for each suit

        for (int i = 0; i < 4; i++) { // The first for loop is for each cardType (clubs, hearts, etc)
            String cardT = cardTypes[i]; // Identifing the card type to
            for (int j = 0; j < cardValues.length; j++) {
                completeDeck.add(cardValues[j] + cardT);
            }
        }
    }
}

//  Not need will just use the built in feature from Collections.shuffle()
//class shuffle {
//    ArrayList<String> ShuffleMeDeck = new ArrayList<>();
//
//    public ArrayList<String> getShuffleMeDeck() {
//        setShuffleMeDeck(ShuffleMeDeck);
//        return ShuffleMeDeck;
//    }
//
//    void setShuffleMeDeck(ArrayList Deck) {
//        ArrayList<String> TempDeck = Deck;
//        String temp;
//        String tempSwitcher;
//        Random rand = new Random(52);
//
//        for (int i = 0; i < TempDeck.size(); i++ ) {
//            temp = TempDeck.get(i).toString();
//            int tempNumber = rand.nextInt();
//            tempSwitcher = TempDeck.get(tempNumber).toString();
//            TempDeck.remove(tempNumber);
//            TempDeck.add(tempNumber, temp);
//            TempDeck.remove(i);
//            TempDeck.add(i, tempSwitcher);
//        }
//
//    }
//    //Collections.shuffle(ShuffleMeDeck);
//}
