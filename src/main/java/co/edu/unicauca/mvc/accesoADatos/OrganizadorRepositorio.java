package co.edu.unicauca.mvc.accesoADatos;

import java.util.LinkedList;
import java.util.List;
import co.edu.unicauca.mvc.modelos.Organizador;
/**
 *
 * @author Mary
 */

/**
 * Clase que implementa la interfaz IOrganizadorRepositorio para gestionar
 * el almacenamiento y consulta de organizadores.
 */

public class OrganizadorRepositorio implements IOrganizadorRepositorio
{
    /**
     * Lista que almacena los organizadores.
     */
    private LinkedList<Organizador> listaOrganizadores;
    
    /**
     * Constructor que inicializa la lista de organizadores.
     */
    
    public OrganizadorRepositorio()
    {
        this.listaOrganizadores= new LinkedList();
    }
    
    /**
     * Almacena un organizador en el repositorio.
     *
     * @param objOrganizador El organizador a almacenar.
     * @return true si el organizador se almacena correctamente, false en caso contrario.
     */
    
@Override
    public boolean almacenarOrganizador(Organizador objOrganizador) {
        boolean bandera=this.listaOrganizadores.add(objOrganizador);
        return bandera;
    }
    
    /**
     * Lista todos los organizadores almacenados en el repositorio.
     *
     * @return Una lista de todos los organizadores.
     */

    public List<Organizador> listarOrganizadores() {
        return this.listaOrganizadores;
    }
}