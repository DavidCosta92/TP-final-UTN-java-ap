package org.example.controllers;
import org.example.entidades.Alumno;
import org.example.persistencia.Conexion;

public class AlumnoController {
    private final Conexion conexionBD;

    public AlumnoController() {
        this.conexionBD = new Conexion();
    }
    public Alumno crearAlumno(String nombre , String apellido , Integer legajo , Integer dni , String nombresMateriasAprobadas){
        this.conexionBD.establecerConexion();
        Alumno nuevoAlumno = new Alumno(nombre , apellido , legajo , dni , nombresMateriasAprobadas);
        this.conexionBD.guardarAlumno(nuevoAlumno);
        return  nuevoAlumno;
    }


    public Alumno buscarAlumnoByLegajo(Integer legajo){
        this.conexionBD.establecerConexion();
        Alumno alumnoBuscado = this.conexionBD.buscarAlumnoByLegajo(legajo);
        return  alumnoBuscado;
    }
}
