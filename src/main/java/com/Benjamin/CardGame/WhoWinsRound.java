package com.Benjamin.CardGame;

public class WhoWinsRound {

    // Used to decide whome gets the point for the winning the book
    boolean playerTeamWinners ;

    // Will call the other methods and inform who gets the point
    boolean getPlayerTeamWinners(String player, String teamMate, String oppoentLeft, String oppoentRight) {
        setPlayerTeamWinners( player,  teamMate,  oppoentLeft,  oppoentRight);
        return playerTeamWinners;
    }

    void setPlayerTeamWinners(String player, String teamMate, String oppoentLeft, String oppoentRight) {

        int playersCard = isSpade(player) + setCardValue(player); // Getting players card into a numeric value to compare with the others
        int teamMateCard = isSpade(teamMate) + setCardValue(teamMate);

        int oppoentLeftCard = isSpade(oppoentLeft) + setCardValue(oppoentLeft); // Getting your oppoents number value
        int oppoentRightCard = isSpade(oppoentRight) + setCardValue(oppoentRight);

        int playersTeamCard; // Whom ever has the  highest card on the team will activate this int.   // Make these separate with getters and setters???
        int computerTeamCard;

        // Maybe make this a class or method?? (with the two other below)
        if (playersCard > teamMateCard) {  // Comparing the player and its ally if player card is higher then setting playerTeamCard
            playersTeamCard = playersCard;
        } else {
            playersTeamCard = teamMateCard;
        }

        if (oppoentLeftCard > oppoentRightCard) { // Comparing oppoents cards for which is better.
            computerTeamCard = oppoentLeftCard;
        } else {
            computerTeamCard = oppoentRightCard;
        }

        if (playersTeamCard > computerTeamCard) { // Setting the boolean variable that will return to main and give a side a point.
            playerTeamWinners = true;
        } else {
            playerTeamWinners = false;
        }


//        if (player.substring(0, 1).equalsIgnoreCase("A" ) ||
//            player.substring(0, 1).equalsIgnoreCase("J" ) ||
//            player.substring(0, 1).equalsIgnoreCase("Q" ) ||
//            player.substring(0, 1).equalsIgnoreCase("K" )  ) {
//        }
    }

    int isSpade(String card) { // Checking if the card is a spade, if so will add 13 points so it trumps all other suits.
        char suitPlayed = card.charAt(card.length() -1);  // This should let us know whatever suit it is.
        char suitPlayedLowerCase = Character.toUpperCase(suitPlayed); // Making it uppercase for when returns should be capitalized.
        char s = 'S'; // The compare char to deside if its a spade.
        if (suitPlayedLowerCase == s ) {
            return 13; // Whoot, whoot, trump points!
        } else {
            return 0;
        }
    }

    int setCardValue(String card) { // This is to find the numaric value of the card.
        card = card.substring(0, 1).toUpperCase(); // Gets the first charater of it to figure out its numaric value.
        int cardValue ;
        switch (card) { // Testing the card to find its value
            case "A" :  // Ace
                return 1; // worth only one point, pretty low on the spectrum
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "1":  // Ten would only need 1 because there are no other ones.
                return 10;
            case "J": // Jack
                return 11;
            case "Q": // Queen
                return 12 ;
            case "K": // King
                return 13; // Most points you can get for card value
            default:
                return 0;
        }
    }


}
