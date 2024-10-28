package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Organizador;
import co.edu.unicauca.mvc.modelos.Rol;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
import co.edu.unicauca.mvc.modelos.Usuario;
import java.util.ArrayList;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

/**
 * Servicio para gestionar organizadores en el sistema de conferencias.
 * Proporciona métodos para almacenar y listar organizadores a través de la API
 * REST de usuarios.
 */
public class OrganizadorServicio {

    private String endPointUsuarios;
    private Client client;
    private OrganizadorServicio organizadorServicio;

    /**
     * Constructor de la clase OrganizadorServicio.
     */
    public OrganizadorServicio() {
        this.endPointUsuarios = "http://localhost:8080/api/usuarios"; // Endpoint de usuarios
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
        //this.organizadorServicio = organizadorServicio; //
    }

    
        public List<Usuario> listarUsuarios() {
        try {
            WebTarget target = client.target(endPointUsuarios);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);

            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                return respuesta.readEntity(new GenericType<List<Usuario>>() {});
            } else {
                System.out.println("Error: No se pudieron obtener los usuarios. Código de respuesta: " + respuesta.getStatus());
                return new ArrayList<>(); // Retorna una lista vacía en caso de error
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retorna una lista vacía si ocurre una excepción
        }
    }
    /**
     * Almacena un organizador en el sistema a través de la API REST.
     *
     * @param objOrganizador El organizador que se desea almacenar.
     * @return true si el organizador se almacenó con éxito, false en caso
     * contrario.
     */
    public boolean almacenarOrganizador(Organizador organizador) {
        // Primero, obtenemos la lista actual de usuarios para contar el ID.
        List<Usuario> listaUsuarios = listarUsuarios();
        int nuevoId = listaUsuarios.size() + 1; 

        // Creamos un nuevo objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setId(nuevoId); // Asignamos el nuevo ID
        nuevoUsuario.setNombre(organizador.getNombre());
        nuevoUsuario.setApellido(organizador.getApellido());
        nuevoUsuario.setCorreo(organizador.getCorreo());

        // Asignar rol por defecto
        Rol rolOrganizador = new Rol();
        rolOrganizador.setId(1); 
        rolOrganizador.setNombre("ORGANIZADOR");
        nuevoUsuario.setRol(rolOrganizador);

        // Realizamos la solicitud POST enviando el objeto Usuario como JSON
        Response respuesta = client
                .target(endPointUsuarios)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(nuevoUsuario, MediaType.APPLICATION_JSON));

        // Comprobamos si la respuesta tiene un estado exitoso (2xx)
        int statusCode = respuesta.getStatus();
        return statusCode == Response.Status.CREATED.getStatusCode()
                || statusCode == Response.Status.OK.getStatusCode();
    }

    /**
     * Lista todos los organizadores almacenados en el sistema a través de la
     * API REST.
     *
     * @return Una lista de organizadores.
     */
    public List<Usuario> listarOrganizadores() {
        // Realizamos la solicitud GET para obtener todos los usuarios
        Response respuesta = client
                .target(endPointUsuarios)
                .request(MediaType.APPLICATION_JSON)
                .get();

        // Verificamos si la respuesta tiene un estado exitoso
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            // Deserializamos la respuesta en una lista de usuarios
            List<Usuario> listaUsuarios = respuesta.readEntity(new GenericType<List<Usuario>>() {
            });

            // Filtramos la lista de usuarios para obtener solo aquellos que son organizadores
            return listaUsuarios.stream()
                    .filter(usuario -> usuario.getRol().getNombre().equalsIgnoreCase("ORGANIZADOR"))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Error al listar organizadores. Código de estado: " + respuesta.getStatus());
            return null;
        }
    }
}
