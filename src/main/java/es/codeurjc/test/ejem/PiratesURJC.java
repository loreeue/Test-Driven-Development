package es.codeurjc.test.ejem;

import java.util.Set;

public class PiratesURJC {

    private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
    private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

    public String play(String round) {
        String[] cards = round.split(" ");
        int biggestCardValue = -1;
        int currentWinner = -1;
        char firstLetter = getFirstLetter(cards);
        boolean allSpecials = allAreSpecialCards(cards);
        boolean foundKK = false;
        boolean foundBB = false;
        int playerWithBB = playerWithASpecificCard(cards, "BB");
        int playerWithKK = playerWithASpecificCard(cards, "KK");

        if (playerWithBB != -1) {
            foundBB = true;
        }
        if (playerWithKK != -1) {
            foundKK = true;
        }

        for (int i = 0; i < cards.length; i++) {
            char playerCardLetter = cards[i].charAt(1);
            if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
                cards[i + 1] = "14";
            }
            if (playerWithKK != -1 && playerWithBB != -1 && playerWithBB < playerWithKK) {
                foundBB = false;
                playerWithBB = -1;
            }
            if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
                cards[playerWithKK] = "-1";
                foundKK = false;
            }
            cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
            if (isSpecialCard(cards[i])) {
                int playerCardValue = Integer.parseInt(cards[i]);
                if (playerCardValue >= biggestCardValue) {
                    biggestCardValue = playerCardValue;
                    currentWinner = i;
                }
            }
            if (playerCardLetter == firstLetter || foundBB) {
                int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
                if (playerCardValue > biggestCardValue) {
                    biggestCardValue = playerCardValue;
                    currentWinner = i;
                }
            }
        }
        if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
            return "Gana jugador " + (playerWithBB + 1);
        }
        return "Gana jugador " + (currentWinner + 1);
    }

    private boolean isATie(String[] cards, int biggestCardValue) {
        boolean foundBiggestCardValue = false;
        for (String card : cards) {
            int value = Character.getNumericValue(card.charAt(0));
            if (!isSpecialCard(card) && value == biggestCardValue) {
                if (foundBiggestCardValue) {
                    return true;
                }
                foundBiggestCardValue = true;
            }
        }
        return false;
    }

    private char getFirstLetter(String[] cards) {
        char firstLetter = cards[0].charAt(1);
        for (String card : cards) {
            if (card.charAt(1) == 'N') {
                return card.charAt(1);
            }
        }
        for (String card : cards) {
            if (!isSpecialCard(card)) {
                return card.charAt(1);
            }
        }
        return firstLetter;
    }

    private int playerWithASpecificCard(String[] cards, String specificCard) {
        for (int i = 0; i < cards.length; i++) {
            if (specificCard.equals(cards[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSpecialCard(String card) {
        return SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card);
    }

    private boolean allAreSpecialCards(String[] cards) {
        for (String card : cards) {
            if (!isSpecialCard(card)) {
                return false;
            }
        }
        return true;
    }

    private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
        if (!SPECIAL_CARDS.contains(card)) {
            return card;
        }
        return switch (card) {
            case "SR" -> foundKK ? "00" : (foundBB ? "7" : "11");
            case "PR" -> foundKK ? "00" : (foundBB ? "8" : "12");
            case "SK" -> foundKK ? "00" : (foundBB ? "0" : "13");
            case "KK" -> allSpecials ? "15" : "00";
            case "BB" -> "00";
            default -> null;
        };
    }
}