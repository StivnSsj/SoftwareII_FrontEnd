package co.edu.unicauca.mvc.modelos;

/**
 * Representa un autor de un artículo dentro del sistema de conferencias.
 * Contiene información personal del autor como nombre, apellido y correo electrónico.
 * 
 * @author SANTIAGO DORADO
 */

    public class Autor {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    
     /**
     * Constructor vacío para la clase Autor.
     */
    public Autor(){
        
    }
    /**
     * Constructor con parámetros para inicializar un autor.
     * 
     * @param id Identificador único del autor.
     * @param nombre Nombre del autor.
     * @param apellido Apellido del autor.
     * @param correo Correo electrónico del autor.
     */
    
    public Autor(int id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    
    // Métodos getters y setters
    /**
     * Obtiene el identificador único del autor.
     * 
     * @return el identificador del autor.
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el identificador único del autor.
     * 
     * @param id el identificador a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }   
    /**
     * Obtiene el nombre del autor.
     * 
     * @return el nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del autor.
     * 
     * @param nombre el nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el apellido del autor.
     * 
     * @return el apellido del autor.
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Establece el apellido del autor.
     * 
     * @param apellido el apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }  
    /**
     * Obtiene el correo electrónico del autor.
     * 
     * @return el correo electrónico del autor.
     */
    public String getCorreo() {
        return correo;
    }
     /**
     * Establece el correo electrónico del autor.
     * 
     * @param correo el correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }      
}
