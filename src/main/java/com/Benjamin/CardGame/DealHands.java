package com.Benjamin.CardGame;

import java.util.ArrayList;

public class DealHands {

    ArrayList<String> hand = new ArrayList<>(13);

//    ArrayList<String> playerHand = new ArrayList<>(13);
//    ArrayList<String> opponentLeft = new ArrayList<>(13);
//    ArrayList<String> teamMatesHand = new ArrayList<>(13);
//    ArrayList<String> opponentRight = new ArrayList<>(13);

//    Static methods can be invoked statically in this syntax:
//    Code:
//              Class.methodName(arguments);
//
//    Non-static methods require instantination of the class, something like this:
//    Code:
//              Class objectReference = new Class(constructorParams);
//              objectReference .methodName();


    //This will get each players hands
    public ArrayList<String> getHand(ArrayList deck) {
        setHand(deck);
        return hand;
    }

    void setHand(ArrayList deck) {
        for (int i = 0; i < 13; i++) {
            hand.add(deck.get(i).toString()); // This should add 13 cards to one hand
            deck.remove(i);                   // This should remove 13 cards from the deck.
            if (deck.equals(null)) {
                deck.add("Emtpy");
            }
        }
    }



}
