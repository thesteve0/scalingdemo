package org.openshift.webservice;

import org.openshift.model.*;
import org.openshift.model.Character;

import javax.ws.rs.*;
import java.util.HashMap;

/**
 * Created by spousty on 8/22/14.
 */

@Path("/char")
public class Generator {

    private org.openshift.model.Character character = new Character();

    @GET()
    @Produces("text/json")
    public HashMap MakeACharacter(){
        return character.getAllAttributes();
    }

    @GET()
    @Produces("text/json")
    @Path("{name}")
    public HashMap MakeACharacterWithAName(@PathParam("name") String name){

        character.setName(name);
        return character.getAllAttributes();

    }

}
