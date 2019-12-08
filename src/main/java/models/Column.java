package models;

import java.util.ArrayList;

public class Column {

    public int id;
    public java.util.List<Card> cards = new ArrayList<>();

    public Column() {
    }

    public Column(int id) {
        this.id = id;
    }
}
