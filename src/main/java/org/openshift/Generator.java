package org.openshift;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by spousty on 8/22/14.
 */

@Path("/char")
public class Generator {

    @GET()
    @Produces("text/plain")
    public String MakeACharacter(){
        return "hey it works";
    }

}
