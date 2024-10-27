package co.edu.unicauca.mvc.controladores;

import java.util.List;
import co.edu.unicauca.mvc.modelos.Conferencia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public List<Conferencia> listarConferencias() {
        Response response = objConferenciaPeticiones
                .target(endPoint)
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == 200) {
            // Lee la lista de conferencias desde la respuesta
            return response.readEntity(new GenericType<List<Conferencia>>() {
            });
        } else {
            System.out.println("Error al listar las conferencias. Código de respuesta: " + response.getStatus());
            return null;
        }
    }

    // Método para crear una conferencia
    public boolean crearConferencia(Conferencia conferencia, Integer idUsuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convierte las fechas de LocalDate a String
        String fechaInicioStr = LocalDate.parse(conferencia.getFechaInicio()).format(formatter);
        String fechaFinStr = LocalDate.parse(conferencia.getFechaFin()).format(formatter);

        // Asigna las fechas convertidas a la conferencia
        conferencia.setFechaInicio(fechaInicioStr);
        conferencia.setFechaFin(fechaFinStr);

        Response response = objConferenciaPeticiones
                .target(endPoint)
                .queryParam("idUsuario", idUsuario)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(conferencia, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200 || response.getStatus() == 201) {
            return true;
        } else {
            System.out.println("Error al crear la conferencia. Código de respuesta: " + response.getStatus());
            return false;
        }
    }

    // Método para agregar un artículo a una conferencia
    public boolean agregarArticulo(Integer idConferencia, Integer idArticulo) {
        // Construir la URL con el ID de la conferencia
        String url = endPoint + "/" + idConferencia + "/articulo";

        // Realizar la solicitud PUT
        Response response = objConferenciaPeticiones
                .target(url)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(idArticulo, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200) {
            // Leer la conferencia actualizada desde la respuesta
            return true;
        } else {
            System.out.println("Error al agregar el artículo. Código de respuesta: " + response.getStatus());
            return false;
        }
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
