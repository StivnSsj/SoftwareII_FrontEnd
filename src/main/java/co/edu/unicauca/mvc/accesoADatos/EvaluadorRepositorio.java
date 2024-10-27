package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Evaluador;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IEvaluadorRepositorio para gestionar 
 * el almacenamiento, consulta, actualización y eliminación de evaluadores.
 */

public class EvaluadorRepositorio implements IEvaluadorRepositorio{

    /**
     * Lista que almacena los evaluadores.
     */
    
    private ArrayList<Evaluador> listaDeEvaluadores;
    
    /**
     * Constructor de la clase. Inicializa la lista de evaluadores.
     */
    
    public EvaluadorRepositorio()
    {
        this.listaDeEvaluadores= new ArrayList();
    }
    
    /**
     * Almacena un evaluador en la lista.
     *
     * @param objEvaluador El evaluador a almacenar.
     * @return true si el evaluador se almacena correctamente, false en caso contrario.
     */
    
    @Override
    public boolean almacenarEvaluador(Evaluador objEvaluador) {
       objEvaluador.setId(getCantidadEvaluadores());
       return this.listaDeEvaluadores.add(objEvaluador);
    }

    /**
     * Lista todos los evaluadores almacenados.
     *
     * @return Una lista de todos los evaluadores.
     */
    
    @Override
    public List<Evaluador> listarEvaluadores() {
        return this.listaDeEvaluadores;
    }
    /**
     * Obtiene la cantidad de evaluadores almacenados.
     *
     * @return La cantidad de evaluadores más uno.
     */
    
    private int getCantidadEvaluadores()
    {
        return this.listaDeEvaluadores.size()+1;
    }
    
    /**
     * Elimina un evaluador de la lista por su ID.
     *
     * @param idEvaluador El ID del evaluador a eliminar.
     * @return true si el evaluador se elimina correctamente, false en caso contrario.
     */

    public boolean eliminarEvaluador(int idEvaluador) {
        boolean bandera=false;
        for (int i = 0; i < this.listaDeEvaluadores.size(); i++) {
            if(this.listaDeEvaluadores.get(i).getId()==idEvaluador)
            {
                this.listaDeEvaluadores.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }

    /**
     * Consulta un evaluador por su ID.
     *
     * @param idEvaluador El ID del evaluador a consultar.
     * @return El evaluador consultado, o null si no se encuentra.
     */
    
    public Evaluador consultarEvaluador(int idEvaluador) {
        Evaluador objEvaluador=null;
        for (int i = 0; i < this.listaDeEvaluadores.size(); i++) {
            if(this.listaDeEvaluadores.get(i).getId()==idEvaluador)
            {
                objEvaluador=this.listaDeEvaluadores.get(i);
                break;
            }
        }
        
        return objEvaluador;
    }
    
    /**
     * Actualiza un evaluador en la lista.
     *
     * @param objEvaluador El evaluador con la información actualizada.
     * @return true si el evaluador se actualiza correctamente, false en caso contrario.
     */

    public boolean actualizarEvaluador(Evaluador objEvaluador) {
        boolean bandera=false;
        for (int i = 0; i < this.listaDeEvaluadores.size(); i++) {
            if(this.listaDeEvaluadores.get(i).getId()==objEvaluador.getId())
            {
                this.listaDeEvaluadores.set(i, objEvaluador);
                bandera=true;
                break;
            }
        }
        
        return bandera;
    }

}


