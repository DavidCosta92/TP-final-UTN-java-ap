package org.example.entidades;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    String nombre;
    String apellido;
    Integer legajo;
    Integer dni;
    List<Materia> materiasAprobadas = new ArrayList<>();
    String nombresMateriasAprobadas ;

    public Alumno() { }

    public String getNombresMateriasAprobadas() {
        return nombresMateriasAprobadas;
    }

    public void setNombresMateriasAprobadas(String nombresMateriasAprobadas) {
        this.nombresMateriasAprobadas = nombresMateriasAprobadas;
    }

    public Alumno(String nombre, String apellido, Integer legajo, Integer dni, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.dni = dni;
        this.materiasAprobadas = materiasAprobadas;
    }
    public Alumno(String nombre, String apellido,Integer legajo,Integer dni,String nombresMateriasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.dni = dni;
        this.nombresMateriasAprobadas = nombresMateriasAprobadas;
    }
    public Alumno(String nombre, String apellido,Integer legajo,Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Alumno nombre=" + nombre + ", legajo=" + legajo + ", materiasAprobadas=" + nombresMateriasAprobadas + '}';
    }

}
