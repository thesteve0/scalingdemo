package org.openshift.webservice;

import javax.ws.rs.*;

import java.util.Vector;

@Path("/eat")
public class Hog {

	@GET()
	@Path("quick")
	public void EatMemorySimulate() {
		System.out.println(" java.lang.OutOfMemoryError");
	}

	@GET()
	@Produces("text/json")
	public void EatMemory() {
		Vector v = new Vector();
		try {
			while (true) {
				byte b[] = new byte[10000000];
				v.add(b);
				Runtime rt = Runtime.getRuntime();
				System.out.println("free memory: " + rt.freeMemory());
			}
		} catch (java.lang.OutOfMemoryError e) {
			e.printStackTrace();
			System.out.println(" java.lang.OutOfMemoryError");
		}
	}

}
