package org.openshift.webservice;

import javax.ws.rs.*;

import java.util.Vector;

@Path("/eat")
public class Hog {

	@GET()
	@Produces("text/json")
	@Path("quick")
	public Vector EatMemorySimulate() {
		Vector v = new Vector<String>();
		v.add(new String("java.lang.OutOfMemoryError"));
		System.out.println("java.lang.OutOfMemoryError");
		return v;
	}

	@GET()
	@Produces("text/json")
	public void EatMemory() {
		Vector v = new Vector();
		while (true) {
			byte b[] = new byte[10485760];
			v.add(b);
			Runtime rt = Runtime.getRuntime();
			System.out.println("free memory: " + rt.freeMemory());
		}
	}

}
