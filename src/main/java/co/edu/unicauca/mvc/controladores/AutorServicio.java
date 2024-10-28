package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Autor;
import co.edu.unicauca.mvc.modelos.Rol;
import co.edu.unicauca.mvc.modelos.Usuario;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Servicio para gestionar autores en el sistema de conferencias.
 * Proporciona métodos para almacenar, listar, consultar, actualizar y eliminar
 * autores.
 */
public class AutorServicio {

    private Client client;
    private String endPointUsuarios; // URL base de la API para usuarios

    /**
     * Constructor de la clase AutorServicio.
     */
    public AutorServicio() {
        this.endPointUsuarios = "http://localhost:8080/api/usuarios"; // Endpoint de usuarios
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    /**
     * Almacena un autor en el sistema.
     *
     * @param autor El autor que se desea almacenar.
     * @return true si el autor se almacenó con éxito, false en caso
     * contrario.
     */
    public boolean almacenarAutor(Autor autor) {
        // Primero, obtenemos la lista actual de usuarios para contar el ID.
        List<Usuario> listaUsuarios = listarUsuarios();
        int nuevoId = listaUsuarios.size() + 1;

        // Creamos un nuevo objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setId(nuevoId); // Asignamos el nuevo ID
        nuevoUsuario.setNombre(autor.getNombre());
        nuevoUsuario.setApellido(autor.getApellido());
        nuevoUsuario.setCorreo(autor.getCorreo());

        // Asignar rol de autor
        Rol rolAutor = new Rol();
        rolAutor.setId(3); // Asumiendo que 1 es el ID del rol de autor
        rolAutor.setNombre("AUTOR");
        nuevoUsuario.setRol(rolAutor);

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
     * Lista todos los usuarios almacenados en el sistema.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> listarUsuarios() {
        try {
            WebTarget target = client.target(endPointUsuarios);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);

            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                return respuesta.readEntity(new GenericType<List<Usuario>>() {
                });
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
     * Lista todos los usuarios con el rol de autor almacenados en el
     * sistema.
     *
     * @return Una lista de usuarios con el rol de autor.
     */
    public List<Usuario> listarAutores() {
        try {
            WebTarget target = client.target(endPointUsuarios);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);
            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                List<Usuario> usuarios = respuesta.readEntity(new GenericType<List<Usuario>>() {
                });
                // Filtrar solo los usuarios que tienen el rol de autor
                List<Usuario> autores = new ArrayList<>();
                for (Usuario usuario : usuarios) {
                    if (usuario.getRol().getNombre().equals("AUTOR")) {
                        autores.add(usuario);
                    }
                }
                return autores;
            } else {
                System.out.println("Error: No se pudieron obtener los autores. Código de respuesta: " + respuesta.getStatus());
                return new ArrayList<>(); // Retorna una lista vacía en caso de error
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retorna una lista vacía si ocurre una excepción
        }
    }

    /**
     * Elimina un autor del sistema.
     *
     * @param idAutor El ID del autor que se desea eliminar.
     * @return true si el autor se eliminó con éxito, false en caso
     * contrario.
     */
    public boolean eliminarAutor(int idAutor) {
        Response respuesta = client
                .target(endPointUsuarios + "/" + idAutor)
                .request()
                .delete();

        int statusCode = respuesta.getStatus();
        return statusCode == Response.Status.NO_CONTENT.getStatusCode() // 204
                || statusCode == Response.Status.OK.getStatusCode();    // 200
    }

    /**
     * Consulta un autor por su ID.
     *
     * @param idAutor El ID del autor que se desea consultar.
     * @return El objeto Usuario correspondiente al ID, o null si no se
     * encuentra.
     */
    public Usuario consultarAutor(int idAutor) {
        // Construir el endpoint
        String endpoint = endPointUsuarios + "/" + idAutor;
        System.out.println("Consultando endpoint: " + endpoint);

        Response respuesta = client
                .target(endpoint)
                .request(MediaType.APPLICATION_JSON)
                .get();

        // Imprimir el código de estado y el cuerpo de la respuesta
        System.out.println("Código de estado: " + respuesta.getStatus());
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            Usuario usuario = respuesta.readEntity(Usuario.class);
            System.out.println("Autor encontrado: " + usuario.getNombre());
            return usuario; // Devolver el objeto Usuario
        } else {
            String errorMessage = respuesta.readEntity(String.class);
            System.out.println("Error al consultar: " + errorMessage);
            return null; // Devolver null si hay un error
        }
    }

    /**
     * Actualiza los datos de un autor en el sistema.
     *
     * @param usuario El usuario con la información actualizada.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarAutor(Usuario usuario) {
        // Asumiendo que 'usuario' tiene un método getId() para obtener el ID del usuario.
        Response respuesta = client
                .target(endPointUsuarios + "/" + usuario.getId()) // Agregamos el ID aquí
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(usuario, MediaType.APPLICATION_JSON));

        // Imprimir el código de estado y el cuerpo de la respuesta
        System.out.println("Código de estado: " + respuesta.getStatus());
        if (respuesta.getStatus() != Response.Status.OK.getStatusCode()) {
            String errorMessage = respuesta.readEntity(String.class);
            System.out.println("Mensaje de error: " + errorMessage);
        }

        return respuesta.getStatus() == Response.Status.OK.getStatusCode();
    }
}
