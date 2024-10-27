package co.edu.unicauca.mvc.controladores;

import java.util.List;
import co.edu.unicauca.mvc.modelos.Conferencia;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Clase de servicio que proporciona métodos para gestionar conferencias
 * utilizando un repositorio de conferencias.
 */
public class ConferenciaServices {

    private String endPoint;
    private Client objConferenciaPeticiones;

    public ConferenciaServices() {
        this.endPoint = "http://localhost:1000/api/conferencias";
        this.objConferenciaPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Conferencia consultarConferencia(Integer id) {
        //Conferencia objConferencia = null;

        WebTarget target = this.objConferenciaPeticiones.target(this.endPoint + "/" + id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        Conferencia objConferencia = objPeticion.get(Conferencia.class);
        return objConferencia;
    }

    public List<Conferencia> listarConferencias() {
        try {
            WebTarget target = objConferenciaPeticiones.target(endPoint);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);

            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                return respuesta.readEntity(new GenericType<List<Conferencia>>() {
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

    public Boolean eliminarConferencia(Integer id) {
        Boolean bandera = false;
        WebTarget target = objConferenciaPeticiones.target(this.endPoint + "/" + id);
        bandera = target.request(MediaType.APPLICATION_JSON_TYPE).delete(Boolean.class);
        return bandera;
    }
    
    public Conferencia consultarConferenciaPorNombre(String nombre) {
        // Construir la URL con el nombre de la conferencia
        WebTarget target = objConferenciaPeticiones.target(endPoint).path("nombre").path(nombre);

        // Enviar la petición GET
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        // Verificar si la respuesta fue exitosa
        if (response.getStatus() == 200) {
            // Leer el objeto Conferencia desde la respuesta
            return response.readEntity(Conferencia.class);
        } else {
            System.out.println("Error al consultar la conferencia: " + response.getStatus());
            return null;
        }
    }
    
}
