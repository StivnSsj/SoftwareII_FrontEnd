package co.edu.unicauca.mvc.modelos;

/**
 *
 * @author Mary
 */

/**
 * Representa un organizador dentro del sistema de conferencias.
 * Contiene información sobre el nombre, apellido y correo electrónico del organizador.
 */
public class Organizador {
    private String nombreOrganizador;
    private String apellidoOrganizador;
    private String correo;
    
    /**
     * Constructor para inicializar un organizador con los detalles básicos.
     * 
     * @param nombreOrganizador Nombre del organizador.
     * @param apellidoOrganizador Apellido del organizador.
     * @param correo Correo electrónico del organizador.
     */
    
    public Organizador(String nombreOrganizador,String apellidoOrganizador, String correo) {
        this.nombreOrganizador = nombreOrganizador;
        this.apellidoOrganizador = apellidoOrganizador;      
        this.correo = correo;
    }
    
    // Métodos getters y setters
     /**
     * Obtiene el nombre del organizador.
     * 
     * @return el nombre del organizador.
     */
    public String getNombre() {
        return nombreOrganizador;
    }
    /**
     * Establece el nombre del organizador.
     * 
     * @param nombreOrganizador el nombre a establecer.
     */
    public void setNombre(String nombreOrganizador) {
        this.nombreOrganizador = nombreOrganizador;
    }
    /**
     * Obtiene el apellido del organizador.
     * 
     * @return el apellido del organizador.
     */
    public String getApellido() {
        return apellidoOrganizador;
    }
    /**
     * Establece el apellido del organizador.
     * 
     * @param apellidoOrganizador el apellido a establecer.
     */
    public void setApellido(String apellidoOrganizador) {
        this.apellidoOrganizador=apellidoOrganizador;
    }
    /**
     * Obtiene el correo electrónico del organizador.
     * 
     * @return el correo electrónico del organizador.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Establece el correo electrónico del organizador.
     * 
     * @param correo el correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo=correo;
    }
}
