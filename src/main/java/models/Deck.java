package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    public java.util.List<Card> cards = new ArrayList<>();

    public Deck() {
        for(int i = 2; i < 15; i++){
            cards.add(new Card(i,Suit.Clubs));
            cards.add(new Card(i,Suit.Hearts));
            cards.add(new Card(i,Suit.Diamonds));
            cards.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public ArrayList<Card> dealFour() {
        ArrayList<Card> four = new ArrayList<>();
        for (int i = 3; i >= 0; i--) {
            if (cards.size() > 0) {
                four.add(cards.get(cards.size()-1));
                cards.remove(cards.size()-1);
            }
        }
        return four;
    }
}
