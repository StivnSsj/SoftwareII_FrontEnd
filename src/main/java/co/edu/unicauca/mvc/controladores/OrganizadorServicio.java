package co.edu.unicauca.mvc.controladores;

import java.util.List;
import co.edu.unicauca.mvc.modelos.Organizador;
import co.edu.unicauca.mvc.accesoADatos.IOrganizadorRepositorio;

/**
 *
 * @author Mary
 */

/**
 * Servicio para gestionar organizadores en el sistema de conferencias.
 * Proporciona métodos para almacenar y listar organizadores.
 */
public class OrganizadorServicio {

    private IOrganizadorRepositorio objIOrganizador;
    /**
     * Constructor de la clase OrganizadorServicio.
     * 
     * @param objIOrganizador Referencia al repositorio que maneja la persistencia de los organizadores.
     */
    public OrganizadorServicio(IOrganizadorRepositorio objIOrganizador) {
        this.objIOrganizador = objIOrganizador;
    }
    /**
     * Almacena un organizador en el sistema.
     * 
     * @param objOrganizador El organizador que se desea almacenar.
     * @return true si el organizador se almacenó con éxito, false en caso contrario.
     */
    public boolean almacenarOrganizador(Organizador objOrganizador) {
        boolean bandera = this.objIOrganizador.almacenarOrganizador(objOrganizador);
        return bandera;
    }
    /**
     * Lista todos los organizadores almacenados en el sistema.
     * 
     * @return Una lista de organizadores.
     */
    public List<Organizador> listarOrganizador() {
        return this.objIOrganizador.listarOrganizadores();
    }
}
