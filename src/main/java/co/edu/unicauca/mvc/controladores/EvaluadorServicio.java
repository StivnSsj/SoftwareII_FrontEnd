package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Evaluador;
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
 * Servicio para gestionar evaluadores en el sistema de conferencias.
 * Proporciona métodos para almacenar, listar, consultar, actualizar y eliminar
 * evaluadores.
 */
public class EvaluadorServicio {

    private Client client;
    private String endPointUsuarios; // URL base de la API para evaluadores
    private OrganizadorServicio organizadorServicio;

    /**
     * Constructor de la clase EvaluadorServicio.
     *
     * @param client El cliente HTTP para realizar las peticiones.
     * @param endPointEvaluadores URL base de la API de evaluadores.
     */
    public EvaluadorServicio() {
        this.endPointUsuarios = "http://localhost:8080/api/usuarios"; // Endpoint de usuarios
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
        this.organizadorServicio = organizadorServicio;
    }

    /**
     * Almacena un evaluador en el sistema.
     *
     * @param objEvaluador El evaluador que se desea almacenar.
     * @return true si el evaluador se almacenó con éxito, false en caso
     * contrario.
     */
    public boolean almacenarEvaluador(Evaluador evaluador) {
        // Primero, obtenemos la lista actual de usuarios para contar el ID.
        List<Usuario> listaUsuarios = listarUsuarios();
        int nuevoId = listaUsuarios.size() + 1;

        // Creamos un nuevo objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setId(nuevoId); // Asignamos el nuevo ID
        nuevoUsuario.setNombre(evaluador.getNombre());
        nuevoUsuario.setApellido(evaluador.getApellido());
        nuevoUsuario.setCorreo(evaluador.getCorreo());

        // Asignar rol de evaluador
        Rol rolEvaluador = new Rol();
        rolEvaluador.setId(2);
        rolEvaluador.setNombre("EVALUADOR");
        nuevoUsuario.setRol(rolEvaluador);

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
     * Lista todos los usuarios con el rol de evaluador almacenados en el
     * sistema.
     *
     * @return Una lista de usuarios con el rol de evaluador.
     */
    public List<Usuario> listarEvaluadores() {
        try {
            WebTarget target = client.target(endPointUsuarios);
            Invocation.Builder solicitud = target.request(MediaType.APPLICATION_JSON);
            Response respuesta = solicitud.get();

            if (respuesta.getStatus() == 200) { // Si la respuesta es exitosa
                List<Usuario> usuarios = respuesta.readEntity(new GenericType<List<Usuario>>() {
                });
                // Filtrar solo los usuarios que tienen el rol de evaluador
                List<Usuario> evaluadores = new ArrayList<>();
                for (Usuario usuario : usuarios) {
                    if (usuario.getRol().getNombre().equals("EVALUADOR")) {
                        evaluadores.add(usuario);
                    }
                }
                return evaluadores;
            } else {
                System.out.println("Error: No se pudieron obtener los evaluadores. Código de respuesta: " + respuesta.getStatus());
                return new ArrayList<>(); // Retorna una lista vacía en caso de error
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retorna una lista vacía si ocurre una excepción
        }
    }

    /**
     * Elimina un evaluador del sistema.
     *
     * @param idEvaluador El ID del evaluador que se desea eliminar.
     * @return true si el evaluador se eliminó con éxito, false en caso
     * contrario.
     */
    public boolean eliminarEvaluador(int idEvaluador) {
        Response respuesta = client
                .target(endPointUsuarios + "/" + idEvaluador)
                .request()
                .delete();

        int statusCode = respuesta.getStatus();
        return statusCode == Response.Status.NO_CONTENT.getStatusCode() // 204
                || statusCode == Response.Status.OK.getStatusCode();    // 200
    }

    /**
     * Consulta un evaluador por su ID.
     *
     * @param idEvaluador El ID del evaluador que se desea consultar.
     * @return El objeto Usuario correspondiente al ID, o null si no se
     * encuentra.
     */
    public Usuario consultarEvaluador(int id) {
        // Construir el endpoint
        String endpoint = endPointUsuarios + "/" + id;
        System.out.println("Consultando endpoint: " + endpoint);

        Response respuesta = client
                .target(endpoint)
                .request(MediaType.APPLICATION_JSON)
                .get();

        // Imprimir el código de estado y el cuerpo de la respuesta
        System.out.println("Código de estado: " + respuesta.getStatus());
        if (respuesta.getStatus() == Response.Status.OK.getStatusCode()) {
            Usuario usuario = respuesta.readEntity(Usuario.class);
            System.out.println("Usuario encontrado: " + usuario.getNombre());
            return usuario; // Devolver el objeto Usuario
        } else {
            String errorMessage = respuesta.readEntity(String.class);
            System.out.println("Error al consultar: " + errorMessage);
            return null; // Devolver null si hay un error
        }
    }

    /**
     * Actualiza los datos de un evaluador en el sistema.
     *
     * @param usuario El usuario con la información actualizada.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarEvaluador(Usuario usuario) {
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
