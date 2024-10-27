package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Articulo;
import co.edu.unicauca.mvc.modelos.Conferencia;
import co.edu.unicauca.mvc.modelos.Evaluador;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Clase de servicio que proporciona métodos para gestionar artículos
 * utilizando un repositorio de artículos.
 */

public class ArticuloServices {
    private String endPoint;
    private Client objArticuloPeticiones;

    public ArticuloServices() {
        this.endPoint = "http://localhost:2000/api/articulos";
        this.objArticuloPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public List<Articulo> listarArticulos() {
        try {
            WebTarget target = objArticuloPeticiones.target(endPoint);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);

            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                return respuesta.readEntity(new GenericType<List<Articulo>>() {
                });
            } else {
                System.out.println("Error: No se pudieron obtener las conferencias. Código de respuesta: " + respuesta.getStatus());
                return new ArrayList<>(); // Retorna una lista vacía en caso de error
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retorna una lista vacía si ocurre una excepción
        }
    }

    public Articulo consultarArticulo(Integer id) {
        WebTarget target = this.objArticuloPeticiones.target(this.endPoint + "/" + id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        Articulo objArticulo = objPeticion.get(Articulo.class);
        return objArticulo;
    }
    
    public boolean crearArticulo(Articulo objArticulo, Integer idUsuario) {
        Response respuesta = objArticuloPeticiones
                .target(endPoint)
                .queryParam("idUsuario", idUsuario)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(objArticulo, MediaType.APPLICATION_JSON));

        // Verificamos si el estado de respuesta es exitoso (2xx)
        int statusCode = respuesta.getStatus();
        if (statusCode == Response.Status.CREATED.getStatusCode()
                || statusCode == Response.Status.OK.getStatusCode()
                || statusCode == Response.Status.NO_CONTENT.getStatusCode()) {
            return true;
        } else {
            System.out.println("Error al crear el artículo. Código de estado: " + statusCode);
            System.out.println("Detalles de respuesta: " + respuesta.readEntity(String.class));
            return false;
        }
    }

    public boolean actualizarArticulo(Articulo objArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean asignarEvaluador(int idArticulo, ArrayList<Evaluador> listEvaluadores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void cambiarEstado(int idArticulo, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean almacenarArticulo(Articulo objArticulo) {
        return true;
    }

    
}
