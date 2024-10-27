package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Evaluador;
import java.util.List;
import co.edu.unicauca.mvc.accesoADatos.IEvaluadorRepositorio;

/**
 *
 * @author Mary
 */

/**
 * Servicio para gestionar evaluadores en el sistema de conferencias.
 * Proporciona métodos para almacenar, listar, consultar, actualizar y eliminar evaluadores.
 */
public class EvaluadorServicio {
    private IEvaluadorRepositorio referenciaRepositorioEvaluador;
    /**
     * Constructor de la clase EvaluadorServicio.
     * 
     * @param referenciaRepositorioEvaluador Referencia al repositorio que maneja la persistencia de los evaluadores.
     */
    public EvaluadorServicio(IEvaluadorRepositorio referenciaRepositorioEvaluador)
    {
        this.referenciaRepositorioEvaluador=referenciaRepositorioEvaluador;
    }
    /**
     * Almacena un evaluador en el sistema.
     * 
     * @param objEvaluador El evaluador que se desea almacenar.
     * @return true si el evaluador se almacenó con éxito, false en caso contrario.
     */
    public boolean almacenarEvaluador(Evaluador objEvaluador)
    {
        return this.referenciaRepositorioEvaluador.almacenarEvaluador(objEvaluador);
    }
    /**
     * Lista todos los evaluadores almacenados en el sistema.
     * 
     * @return Una lista de evaluadores.
     */  
    public List<Evaluador> listarEvaluadores()
    {
        return this.referenciaRepositorioEvaluador.listarEvaluadores();
    }
    
    /**
     * Elimina un evaluador del sistema.
     * 
     * @param idEvaluador El ID del evaluador que se desea eliminar.
     * @return true si el evaluador se eliminó con éxito, false en caso contrario.
     */
    
    public boolean eliminarEvaluador(int idEvaluador)
    {
        return this.referenciaRepositorioEvaluador.eliminarEvaluador(idEvaluador);
    }
    /**
     * Consulta un evaluador por su ID.
     * 
     * @param idEvaluador El ID del evaluador que se desea consultar.
     * @return El objeto Evaluador correspondiente al ID, o null si no se encuentra.
     */
    public Evaluador consultarEvaluador(int idEvaluador)
    {
        return this.referenciaRepositorioEvaluador.consultarEvaluador(idEvaluador);
    }
    /**
     * Actualiza los datos de un evaluador en el sistema.
     * 
     * @param objEvaluador El evaluador con la información actualizada.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarEvaluador(Evaluador objEvaluador)
    {
        return this.referenciaRepositorioEvaluador.actualizarEvaluador(objEvaluador);
    }
}

