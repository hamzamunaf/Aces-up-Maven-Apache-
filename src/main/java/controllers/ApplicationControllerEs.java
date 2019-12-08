package controllers;


import models.Game_es;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;

@Singleton
public class ApplicationControllerEs {

    public Result espanol() {
        return Results.html().template("views/AcesUp/espanol.html");
    }

    public Result gameGet_es(){
//        System.out.println("Lets test2 it out");
        Game_es g = new Game_es();
        g.cubierta.shuffle();
//        System.out.println("Lets test it out");
        g.dealFour();
//        System.out.println("Lets test it out 3");
        return Results.json().render(g);
    }
    public Result dealPost_es(Context context, Game_es g) {
        System.out.println(context.getRequestPath());
        if (context.getRequestPath().contains("/espanol/dealgame_es")) {
            System.out.println("Lets test2 it out");
            g.dealFour();
            //System.out.println("Game point:"+ VarGame);
            System.out.println("Lets test2 it out");

        }
        return Results.json().render(g);
    }
    public Result removeCard(Context context, @PathParam("column") int colNumber, Game_es g) {
        g.remove(colNumber);
        return Results.json().render(g);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game_es g) {
            g.move(colFrom, colTo);
        return Results.json().render(g);
    }
}
