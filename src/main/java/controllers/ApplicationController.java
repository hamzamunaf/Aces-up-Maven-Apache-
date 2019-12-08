/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {
    int VarGame = 0;
    public Result index() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }

//    public Result espanol() {
//        return Results.html().template("views/AcesUp/espanol.html");
//    }


    public Result gameGet() {
        VarGame=0;
        Game g = new Game();
        g.deck.shuffle();
        g.dealFour();

        return Results.json().render(g);
    }

    public Result dealPost(Context context, Game g) {
        if (context.getRequestPath().contains("deal")) {
            g.dealFour();
            VarGame++;
            //System.out.println("Game point:"+ VarGame);

        }
        return Results.json().render(g);
    }

    public Result removeCard(Context context, @PathParam("column") int colNumber, Game g) {
        g.remove(colNumber);
        return Results.json().render(g);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game g) {
        if (VarGame == 0) {
            g.move(colFrom, colTo);
        }
        if (VarGame != 0) {
            g.custommove(colFrom, colTo);
        }
        return Results.json().render(g);
    }

}

