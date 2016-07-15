package rs.maven.auto;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import rs.maven.auto.Auto;
import rs.maven.auto.dao.DAO;


@Path ("/auto")
public class AutoResource {
	
	
	DAO dao = new DAO ();
	
	@GET
	@Path ("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Auto> listaAuta () {
		
		return dao.getAUTO();
		
	}
	
	@POST
	@Path ("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public void  insertAuto(Auto a){
		
		dao.insertAuto(a);                  // koristi isti upit i metodu kao za insert auto preko servleta
	}
	
	/////////////////////////////////////////////////////za get po id-u i update////////////
	@GET
	@Path ("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Auto selectAutoById(@PathParam("id")int id) {
		
		return dao.selectAutoById(id);
		
	}
	
	
	
	
	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public void  UpdateAuto(Auto a){
		
		 dao.UpdateAuto(a);
	}
	
		
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public void deleteAuto(@PathParam("id")long  id) {
		
		 dao.DELETEAUTO(id);
		
	}
	
}