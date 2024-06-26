package controller;

import java.util.List;

import exception.VemNoX1Exception;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Carta;
import service.CartaService;

@Path("/carta")
public class CartaController {
	
	private CartaService service = new CartaService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carta salvar(Carta novaCarta) throws VemNoX1Exception {
		 return service.salvar(novaCarta);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean atualizar(Carta cartaEditada) throws VemNoX1Exception {
		 return service.atualizar(cartaEditada);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean excluir(@PathParam("id") int id){
		 return service.excluir(id);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Carta consultarPorId(@PathParam("id") int id){
		 return service.consultarPorId(id);
	}
	
	@GET
	@Path("/todas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carta> consultarTodas(){
		 return service.consultarTodas();
	}
	
	//Apenas para testes
//	@GET
//	@Path("/sortear")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Carta> sortear(){
//		return service.sortearSeisCartas();
//	}
}