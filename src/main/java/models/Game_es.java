package models;

import java.util.ArrayList;

public class Game_es{

    public Cubierta cubierta = new Cubierta();
    public java.util.List<Column_es> columns_es = new ArrayList<>();


    public Game_es(){
        columns_es.add(new Column_es(1));
        columns_es.add(new Column_es(2));
        columns_es.add(new Column_es(3));
        columns_es.add(new Column_es(4));
    }


    public void dealFour() {
        ArrayList<Card_es> deal = cubierta.dealFour();
        for (int i = 0; i < deal.size(); i++) {
            Card_es c = deal.get(i);
            columns_es.get(i).cards.add(c);
        }
    }

    public void customDeal(int c1, int c2, int c3, int c4) {
        columns_es.get(0).cards.add(cubierta.cards.get(c1));
        cubierta.cards.remove(c1);
        columns_es.get(1).cards.add(cubierta.cards.get(c2));
        cubierta.cards.remove(c2);
        columns_es.get(2).cards.add(cubierta.cards.get(c3));
        cubierta.cards.remove(c3);
        columns_es.get(3).cards.add(cubierta.cards.get(c4));
        cubierta.cards.remove(c4);
    }

    private Card_es getTopCard(int columnNumber) {
        return this.columns_es.get(columnNumber).cards.get(this.columns_es.get(columnNumber).cards.size()-1);
    }

    private boolean columnHascards(int columnNumber){
        if(this.columns_es.get(columnNumber).cards.size()>0){
            return true;
        }
        return false;
    }

//    public void remove(int columnNumber) {
//        if(columnHascards(columnNumber)) {
//            Card_es c = getTopCard(columnNumber);
//            boolean removeCard = false;
//            for (int i = 0; i < 4; i++) {
//                if (i != columnNumber) {
//                    if (columnHascards(i)) {
//                        Card_es compare = getTopCard(i);
//                        if(compare.getValue() == c.getValue()){
//                            if (compare.getValue() > c.getValue()) {
//                                removeCard = true;
//                            }
//                        }
//                    }
//                }
//            }
//            if (removeCard) {
//                this.columns_es.get(columnNumber).cards.remove(this.columns_es.get(columnNumber).cards.size() - 1);
//            }
//        }
//    }

    public void remove(int columnNumber) {
        if(columnHascards(columnNumber)) {
            Card_es c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHascards(i)) {
                        Card_es compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.columns_es.get(columnNumber).cards.remove(this.columns_es.get(columnNumber).cards.size() - 1);
            }
        }
    }


    public void move(int columnFrom, int columnTo) {
        Card_es cardToMove = getTopCard(columnFrom);
        this.removeCardFromCol(columnFrom);
        this.addCardToCol(columnTo,cardToMove);
    }


    private void addCardToCol(int columnTo, Card_es cardToMove) {
        columns_es.get(columnTo).cards.add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.columns_es.get(colFrom).cards.remove(this.columns_es.get(colFrom).cards.size()-1);
    }

}