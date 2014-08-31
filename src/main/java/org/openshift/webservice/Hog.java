package org.openshift.webservice;

import javax.ws.rs.*;

import java.util.Vector;


@Path("/eat")
public class Hog {

	 @GET()
	 @Produces("text/json")
	 public Vector EatMemory() {
		 	Vector v = new Vector<String>();
		 	v.add(new String("java.lang.OutOfMemoryError"));
		 	System.out.println("java.lang.OutOfMemoryError");
		 	return v;
	 }
}
