package org.example.controllers;

import org.example.persistencia.Conexion;
import org.example.entidades.Materia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaController {


    private final Conexion conexionBD;

    public MateriaController() {
        this.conexionBD = new Conexion();
    }

    public List<Materia> buscarMaterias(){
        List<Materia> materias = this.conexionBD.leerMaterias();
        return  materias;
    }


    public Materia buscarMateriaPorNombre( String nombreMateria){
        Materia materiaBuscada = this.conexionBD.buscarMateriaByNombre(nombreMateria);
        return  materiaBuscada;
    }

    public Materia crearMateria(String nombreMateria, String cadenaNombresMaterias) throws SQLException {
        this.conexionBD.establecerConexion();
        List<Materia> materiasCorrelativas = new ArrayList<Materia>();

        if (cadenaNombresMaterias != "Sin correlativas"){
            // BUSCAR Y CREAR MATERIAS CORRELATIVAS
            String [] materias = cadenaNombresMaterias.split(",");
            for (int i = 0; i < materias.length; i++ ){
                String nombreMat = materias[i];
                Materia matBuscada = this.conexionBD.buscarMateriaByNombre(nombreMat);
                materiasCorrelativas.add(matBuscada);
            }
        }
        // CREAR LA NUEVA MATERIA
        Materia nuevaMateria = new Materia(nombreMateria);
        if (materiasCorrelativas.size() != 0){
            // AGREGAR MATERIAS CORRELATIVAS
            materiasCorrelativas.forEach((materia)-> {
                nuevaMateria.materiasCorrelativa.add(materia);
            });
        }
        // GUARDAR LA NUEVA MATERIA
        this.conexionBD.guardarMateria(nuevaMateria);
        return nuevaMateria;
    }
}
