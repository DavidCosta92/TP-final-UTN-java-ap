package org.example.entidades;

import org.example.controllers.AlumnoController;
import org.example.controllers.MateriaController;

import java.util.Arrays;
import java.util.Date;

public class Inscripcion {
    Date fechaInscripcion = new Date();
    Alumno alumno;
    Materia materia;
    AlumnoController alumnoController = new AlumnoController();
    MateriaController materiaController = new MateriaController();
    boolean estadoDeInscripcion;

    public Inscripcion() { }

    public Inscripcion(Date fechaInscripcion, Alumno alumno, Materia materia) {
        this.fechaInscripcion = fechaInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.estadoDeInscripcion = false;
        this.materiaController = new MateriaController();
        this.alumnoController = new AlumnoController();
    }
    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        this.estadoDeInscripcion = this.corroborarEquivalencia();
        this.materiaController = new MateriaController();
        this.alumnoController = new AlumnoController();
    }

    public boolean getEstadoDeInscripcion() {
        return estadoDeInscripcion;
    }


    public void setEstadoDeInscripcion(boolean estadoDeInscripcion) {
        this.estadoDeInscripcion = estadoDeInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fechaInscripcion=" + fechaInscripcion +
                ", alumno: " + alumno.getApellido() +
                ", materia: " + materia.getNombreMateria() +
                ", estadoDeInscripcion: " + estadoDeInscripcion +
                '}';
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean corroborarEquivalencia(){
        String cadenaNombresCorrelativas = materia.getNombresMateriasCorrelativa();
        String cadenaNombresAprobadas = alumno.getNombresMateriasAprobadas();

        if(cadenaNombresCorrelativas.toUpperCase().equals("NULL")){
            this.setEstadoDeInscripcion(true);
        } else if (cadenaNombresAprobadas != "Sin aprobadas"){
            String [] materiasAprobadas = cadenaNombresAprobadas.split(",");
            String [] materiasCorrelativas = cadenaNombresCorrelativas.split(",");
            if(Arrays.stream(materiasAprobadas).toList().containsAll(Arrays.stream(materiasCorrelativas).toList())){
                this.setEstadoDeInscripcion(true);
            }
        } else{
            this.setEstadoDeInscripcion(false);
        }
/*
        // TRANSFORMA CADENA DE NOMBRES A MATERIAS OBJETO DENTRO DE ALUMNOS
        if (cadenaNombresAprobadas != ""){
            String [] materias = cadenaNombresAprobadas.split(",");
            for (int i = 0; i < materias.length; i++ ){
                Materia matBuscada = this.materiaController.buscarMateriaPorNombre(materias[i]);
                this.alumno.materiasAprobadas.add(matBuscada);
            }
        }
        // TRANSFORMA CADENA DE NOMBRES A MATERIAS OBJETO DENTRO DE ALUMNOS

        if (cadenaNombresCorrelativas != ""){
            String [] materiasCorrelativas = cadenaNombresCorrelativas.split(",");
            for (int i = 0; i < materiasCorrelativas.length; i++ ){
                Materia matCorrelativaBuscada = this.materiaController.buscarMateriaPorNombre(materiasCorrelativas[i]);
                this.materia.materiasCorrelativa.add(matCorrelativaBuscada);
            }
        }
*/

        return this.estadoDeInscripcion;
    }
}
