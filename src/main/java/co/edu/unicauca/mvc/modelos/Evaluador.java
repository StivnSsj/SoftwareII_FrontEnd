package co.edu.unicauca.mvc.modelos;

/**
 *
 * @author Mary
 */

/**
 * Representa un evaluador dentro del sistema de conferencias.
 * Contiene información sobre el nombre, apellido, correo electrónico y los temas de experiencia del evaluador.
 */

public class Evaluador {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String temasExperto;
    
    /**
     * Constructor vacío para la clase Evaluador.
     */
    public Evaluador() {

    }
    /**
     * Constructor con parámetros para inicializar un evaluador.
     * 
     * @param id Identificador único del evaluador.
     * @param nombre Nombre del evaluador.
     * @param apellido Apellido del evaluador.
     * @param correo Correo electrónico del evaluador.
     * @param temasExperto Temas en los que el evaluador es experto.
     */
    public Evaluador(int id, String nombre, String apellido, String correo, String temasExperto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.temasExperto = temasExperto;
    }
    
    // Métodos getters y setters
    /**
     * Obtiene el identificador único del evaluador.
     * 
     * @return el identificador único del evaluador.
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el identificador único del evaluador.
     * 
     * @param id el identificador a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre del evaluador.
     * 
     * @return el nombre del evaluador.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del evaluador.
     * 
     * @param nombre el nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el apellido del evaluador.
     * 
     * @return el apellido del evaluador.
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Establece el apellido del evaluador.
     * 
     * @param apellido el apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    } 
    /**
     * Obtiene los temas en los que el evaluador es experto.
     * 
     * @return los temas de experiencia del evaluador.
     */
    public String getTemas() {
        return temasExperto;
    }
    /**
     * Establece los temas en los que el evaluador es experto.
     * 
     * @param temasExperto los temas de experiencia a establecer.
     */
    public void setTemasExperto(String temasExperto) {
        this.temasExperto = temasExperto;
    }
    /**
     * Obtiene el correo electrónico del evaluador.
     * 
     * @return el correo electrónico del evaluador.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del evaluador.
     * 
     * @param correo el correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }   
}
