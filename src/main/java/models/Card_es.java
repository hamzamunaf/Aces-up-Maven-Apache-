package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;



public class Card_es implements Serializable {
    public final int value;
    public final Palos suit;

    @JsonCreator
    public Card_es(@JsonProperty("value") int value, @JsonProperty("suit") Palos suit) {
        this.value = value;
        this.suit = suit;

    }

//    public Palos getCard() {
//        return Palos.valueOf();
//    }

    public Palos getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.value + this.suit.toString();
    }
}