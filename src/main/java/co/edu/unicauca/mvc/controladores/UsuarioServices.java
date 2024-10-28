package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

public class UsuarioServices {

    private String endPoint;
    private Client objUsuarioPeticiones;

    public UsuarioServices() {
        this.endPoint = "http://localhost:8080/api/usuarios";
        this.objUsuarioPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public boolean crearUsuario(Usuario objUsuario) {
        // Realizamos la solicitud POST enviando el objeto Usuario como JSON
        Response respuesta = objUsuarioPeticiones
                .target(endPoint)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(objUsuario, MediaType.APPLICATION_JSON));

        // Comprobamos si la respuesta tiene un estado exitoso (2xx)
        int statusCode = respuesta.getStatus();
        if (statusCode == Response.Status.CREATED.getStatusCode()
                || statusCode == Response.Status.OK.getStatusCode()
                || statusCode == Response.Status.NO_CONTENT.getStatusCode()) {
            return true;
        } else {
            System.out.println("Error al crear el usuario. Código de estado: " + statusCode);
            System.out.println("Detalles de respuesta: " + respuesta.readEntity(String.class));
            return false;
        }
    }
    
    public boolean consultarUsuario(Integer id) {
        // Realizamos la solicitud GET para obtener el usuario con el ID especificado
        Response respuesta = objUsuarioPeticiones
            .target(endPoint + "/" + id)
            .request(MediaType.APPLICATION_JSON)
            .get();

        // Verificamos si el estado de respuesta indica éxito
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            // Usuario encontrado
            return true;
        } else if (respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            // Usuario no encontrado
            System.out.println("Usuario no encontrado con ID: " + id);
            return false;
        } else {
            // Otro tipo de error
            System.out.println("Error al consultar el usuario. Código de estado: " + respuesta.getStatus());
            System.out.println("Detalles de respuesta: " + respuesta.readEntity(String.class));
            return false;
        }
    }
    
    public String consultarRolUsuario(Integer idUsuario) {
        // Realizamos la solicitud GET para obtener el rol del usuario con el ID especificado
        Response respuesta = objUsuarioPeticiones
            .target(endPoint + "/rol/" + idUsuario)
            .request(MediaType.APPLICATION_JSON)
            .get();

        // Verificamos si la respuesta tiene un estado exitoso
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            // Obtenemos el nombre del rol desde la respuesta como una cadena
            String nombreRol = respuesta.readEntity(String.class);
            return nombreRol;
        } else if (respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            System.out.println("Usuario no encontrado con ID: " + idUsuario);
            return null;
        } else {
            // Otro tipo de error
            System.out.println("Error al consultar el rol del usuario. Código de estado: " + respuesta.getStatus());
            System.out.println("Detalles de respuesta: " + respuesta.readEntity(String.class));
            return null;
        }
    }
    
    public Usuario obtenerUsuario(Integer idUsuario) {
        // Realizamos la solicitud GET para obtener el usuario con el ID especificado
        Response respuesta = objUsuarioPeticiones
            .target(endPoint + "/" + idUsuario)
            .request(MediaType.APPLICATION_JSON)
            .get();

        // Verificamos si la respuesta tiene un estado exitoso
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            // Deserializamos la respuesta en un objeto Usuario
            Usuario objUsuario = respuesta.readEntity(Usuario.class);
            return objUsuario;
        } else if (respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
            System.out.println("Usuario no encontrado con ID: " + idUsuario);
            return null;
        } else {
            // Otro tipo de error
            System.out.println("Error al consultar el usuario. Código de estado: " + respuesta.getStatus());
            System.out.println("Detalles de respuesta: " + respuesta.readEntity(String.class));
            return null;
        }
    }
    
     public List<Usuario> obtenerUsuariosPorRol(String rolNombre) {
        // Realizamos la solicitud GET para obtener todos los usuarios
        Response respuesta = objUsuarioPeticiones
            .target(endPoint)
            .request(MediaType.APPLICATION_JSON)
            .get();

        // Verificamos si la respuesta tiene un estado exitoso
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            // Deserializamos la respuesta en una lista de usuarios
            List<Usuario> listaUsuarios = respuesta.readEntity(new GenericType<List<Usuario>>() {});

            // Filtramos la lista de usuarios por el rol especificado
            return listaUsuarios.stream()
                .filter(usuario -> usuario.getRol().getNombre().equalsIgnoreCase(rolNombre))
                .collect(Collectors.toList());
        } else {
            System.out.println("Error al consultar los usuarios. Código de estado: " + respuesta.getStatus());
            return null;
        }
    }
}
