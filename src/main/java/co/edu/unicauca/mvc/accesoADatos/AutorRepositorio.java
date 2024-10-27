package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mary
 */

/**
 * Clase que implementa la interfaz IAutorRepositorio para gestionar 
 * el almacenamiento y consulta de autores.
 */
public class AutorRepositorio implements IAutorRepositorio {
    /**
     * Lista que almacena los autores.
     */
    
    private ArrayList<Autor> listaAutores;
    
    /**
     * Constructor de la clase. Inicializa la lista de autores.
     */
    
    public AutorRepositorio() {
        this.listaAutores = new ArrayList();
    } 
    
    /**
     * Obtiene la cantidad de autores almacenados.
     *
     * @return La cantidad de autores más uno.
     */
    
    private int getCantidadAutores()
    {
        return this.listaAutores.size()+1;
    }

    /**
     * Registra un autor en la lista.
     *
     * @param objAutor El autor a registrar.
     * @return true si el autor se registra correctamente, false en caso contrario.
     */
    @Override
    public boolean registrarAutor(Autor objAutor) {
        objAutor.setId(getCantidadAutores());
        return this.listaAutores.add(objAutor);
    }
    
    /**
     * Lista todos los autores almacenados.
     *
     * @return Una lista de todos los autores.
     */

    @Override
    public ArrayList<Autor> listarAutores() {
        return this.listaAutores;
    }
}
