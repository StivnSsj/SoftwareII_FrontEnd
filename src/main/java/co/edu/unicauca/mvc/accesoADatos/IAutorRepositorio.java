/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mary
 */

/**
 * Interfaz que define los métodos para gestionar el almacenamiento
 * y consulta de autores.
 */

public interface IAutorRepositorio {
    /**
     * Registra un autor en el repositorio.
     *
     * @param objAutor El autor a registrar.
     * @return true si el autor se registra correctamente, false en caso contrario.
     */
    public boolean registrarAutor(Autor objAutor);
    /**
     * Lista todos los autores almacenados en el repositorio.
     *
     * @return Una lista de todos los autores.
     */
    public ArrayList<Autor> listarAutores();
}
