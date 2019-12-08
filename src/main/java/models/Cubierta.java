package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cubierta {

    public java.util.List<Card_es> cards = new ArrayList<>();

    public Cubierta() {
        for(int i = 2; i < 12; i++){
            cards.add(new Card_es(i,Palos.Bastos));
            cards.add(new Card_es(i,Palos.Oros));
            cards.add(new Card_es(i,Palos.Copas));
            cards.add(new Card_es(i,Palos.Espadas));
        }
        cards.add(new Card_es(15, Palos.Joker));
        cards.add(new Card_es(15, Palos.Joker));
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public ArrayList<Card_es> dealFour() {
        ArrayList<Card_es> four = new ArrayList<>();
        for (int i = 3; i >= 0; i--) {
            if (cards.size() > 0) {
                four.add(cards.get(cards.size()-1));
                cards.remove(cards.size()-1);
            }
        }
        return four;
    }
}