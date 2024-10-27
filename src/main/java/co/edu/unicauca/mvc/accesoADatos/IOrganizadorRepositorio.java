package co.edu.unicauca.mvc.accesoADatos;

/**
 *
 * @author Mary
 */
import co.edu.unicauca.mvc.modelos.Organizador;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar el almacenamiento
 * y consulta de organizadores.
 */
public interface IOrganizadorRepositorio {
    /**
     * Almacena un organizador en el repositorio.
     *
     * @param objOrganizador El organizador a almacenar.
     * @return true si el organizador se almacena correctamente, false en caso contrario.
     */
    public boolean almacenarOrganizador(Organizador objOrganizador);
    
    /**
     * Lista todos los organizadores almacenados en el repositorio.
     *
     * @return Una lista de todos los organizadores.
     */
    public List<Organizador> listarOrganizadores();
}

