/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.modelos.Autor;
import java.util.List;
import co.edu.unicauca.mvc.accesoADatos.IAutorRepositorio;
import java.util.ArrayList;

/**
 *
 * @author SANTIAGO DORADO
 */

/**
 * Clase de servicio que proporciona métodos para gestionar autores
 * utilizando un repositorio de autores.
 */
public class AutorServicio {
    /**
     * Repositorio de autores utilizado por el servicio.
     */
    private IAutorRepositorio objIAutor;
    
    /**
     * Constructor que inicializa el servicio con un repositorio de autores.
     *
     * @param objIAutor El repositorio de autores a utilizar.
     */
    
    public AutorServicio(IAutorRepositorio objIAutor) {
        this.objIAutor = objIAutor;
    }
    /**
     * Registra un autor utilizando el repositorio.
     *
     * @param objAutor El autor a registrar.
     * @return true si el autor se registra correctamente, false en caso contrario.
     */
    public boolean registrarAutor(Autor objAutor){
        boolean bandera = this.objIAutor.registrarAutor(objAutor);
        return bandera;
    }
    /**
     * Lista todos los autores almacenados en el repositorio.
     *
     * @return Una lista de todos los autores.
     */
    public ArrayList<Autor> listarAutores(){
        return this.objIAutor.listarAutores();
    }
}
