package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Evaluador;
import java.util.List;

/**
 *
 * @author Mary
 */
/**
 * Interfaz que define los métodos para gestionar el almacenamiento,
 * consulta, actualización y eliminación de evaluadores.
 */
public interface IEvaluadorRepositorio {
    
    /**
     * Almacena un evaluador en el repositorio.
     *
     * @param objEvaluador El evaluador a almacenar.
     * @return true si el evaluador se almacena correctamente, false en caso contrario.
     */
    public boolean almacenarEvaluador(Evaluador objEvaluador);
    /**
     * Lista todos los evaluadores almacenados en el repositorio.
     *
     * @return Una lista de todos los evaluadores.
     */
    public List<Evaluador> listarEvaluadores();
    /**
     * Elimina un evaluador del repositorio por su ID.
     *
     * @param idEvaluador El ID del evaluador a eliminar.
     * @return true si el evaluador se elimina correctamente, false en caso contrario.
     */
    public boolean eliminarEvaluador(int idEvaluador);
    /**
     * Consulta un evaluador por su ID.
     *
     * @param idEvaluador El ID del evaluador a consultar.
     * @return El evaluador consultado, o null si no se encuentra.
     */
    public Evaluador consultarEvaluador(int idEvaluador);
    /**
     * Actualiza la información de un evaluador en el repositorio.
     *
     * @param objEvaluador El evaluador con la información actualizada.
     * @return true si el evaluador se actualiza correctamente, false en caso contrario.
     */
    public boolean actualizarEvaluador(Evaluador objEvaluador);
}
