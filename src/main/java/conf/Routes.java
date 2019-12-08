/**
 * Copyright (C) 2012 the original author or authors.
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

package conf;


import controllers.ApplicationControllerEs;
import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;
import controllers.ApplicationControllerEs;


public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
        
        router.GET().route("/").with(ApplicationController.class, "index");

        router.GET().route("/game").with(ApplicationController.class, "gameGet");
        router.GET().route("/espanol").with(ApplicationControllerEs.class, "espanol");
        router.GET().route("/espanol/game_es").with(ApplicationControllerEs.class, "gameGet_es");
        router.POST().route("/dealGame").with(ApplicationController.class, "dealPost");
        router.POST().route("/moveCard/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard");
        router.POST().route("/removeCard/{column}").with(ApplicationController.class, "removeCard");
        router.POST().route("/espanol/dealgame_es").with(ApplicationControllerEs.class, "dealPost_es");
        router.POST().route("/espanol/moveCard/{columnFrom}/{columnTo}").with(ApplicationControllerEs.class, "moveCard");
        router.POST().route("/espanol/removeCard/{column}").with(ApplicationControllerEs.class, "removeCard");
        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");



        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
