package models;

import java.util.ArrayList;

public class Column_es {

    public int id;
    public java.util.List<Card_es> cards = new ArrayList<>();

    public Column_es() {
    }

    public Column_es(int id) {
        this.id = id;
    }
}