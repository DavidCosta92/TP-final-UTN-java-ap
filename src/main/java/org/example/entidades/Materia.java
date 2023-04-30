package org.example.entidades;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    String nombreMateria;
    public List<Materia> materiasCorrelativa = new ArrayList<>();
    public String nombresMateriasCorrelativa ;

    public Materia() { }
    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    public Materia(String nombreMateria, List<Materia> materiasCorrelativa) {
        this.nombreMateria = nombreMateria;
        this.materiasCorrelativa = materiasCorrelativa;
    }
    public Materia(String nombreMateria, String nombresMateriasCorrelativa) {
        this.nombreMateria = nombreMateria;
        this.nombresMateriasCorrelativa = nombresMateriasCorrelativa;
    }

    public List<Materia> getMateriasCorrelativa() {
        return materiasCorrelativa;
    }

    public void setMateriasCorrelativa(List<Materia> materiasCorrelativa) {
        this.materiasCorrelativa = materiasCorrelativa;
    }

    public String getNombresMateriasCorrelativa() {
        return nombresMateriasCorrelativa;
    }

    public void setNombresMateriasCorrelativa(String nombresMateriasCorrelativa) {
        this.nombresMateriasCorrelativa = nombresMateriasCorrelativa;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public List<Materia> getCorrelativas() {
        return this.materiasCorrelativa;
    }

    public void setCorrelativa(List<Materia> materiasCorrelativa) {
        this.materiasCorrelativa = materiasCorrelativa;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombreMateria='" + nombreMateria + '\'' +
                ", materiasCorrelativa=" + materiasCorrelativa +
                '}';
    }
}
