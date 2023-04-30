package org.example.interfaz;
import org.example.controllers.AlumnoController;
import org.example.controllers.MateriaController;
import org.example.entidades.Alumno;
import org.example.entidades.Inscripcion;
import org.example.entidades.Materia;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    MateriaController controladorMaterias = null;
    AlumnoController controladorAlumnos = null;
    Scanner sn = null;
    boolean terminar = false;
    public Menu() {
        this.controladorMaterias = new MateriaController();
        this.controladorAlumnos = new AlumnoController();
        this.sn = new Scanner(System.in);
    }
    public void saludar(){
        System.out.println("*****************************");
        System.out.println("***** Hola, bienvenido! *****");
        System.out.println("*****************************");
    }
    public void ingresarMateria() throws SQLException {
        this.sn.nextLine(); //limpiar el buffer de entrada
        System.out.println("Ingresa el nombre de la materia");
        String nombreMateria = this.sn.nextLine();
        String nombresMateriasCorrelativas = "Sin correlativas";

        System.out.println("¿ Tiene materias correlativas ? S / N");
        String correlativas = this.sn.next().toUpperCase();

        if(correlativas.equals("S")) {
            System.out.println("Por favor ingresa los NOMBRES de las materias correlativas..");
            System.out.println("Colocalos separados por coma y sin espacios por favor. DEBEN SER MATERIAS PREVIAMENTE CREADAS");
            System.out.println("Por ejemplo: lengua I,matematica II,fisica I");
            this.sn.nextLine(); //limpiar el buffer de entrada
            nombresMateriasCorrelativas = this.sn.nextLine();
        }
        System.out.println(controladorMaterias.crearMateria(nombreMateria , nombresMateriasCorrelativas));
    }
    public void subMenuMaterias() throws SQLException {
        System.out.println("Empezaremos por agregar algunas materias");
        System.out.println("Estas de acuerdo? S / N");
        String iniciarSubMenu = this.sn.next().toUpperCase();
        if(iniciarSubMenu.equals("S")) {
            boolean salir = false;
            int opcion;
            while(!salir){
                System.out.println("<--- Elige una opcion por favor --->");
                System.out.println("1 - Ingresar nueva materia");
                System.out.println("2 - Eliminar materia (PENDIENTE)");
                System.out.println("3 - Editar materia (PENDIENTE)");
                System.out.println("9 - << TERMINAR MENU >>");
                opcion = this.sn.nextInt();

                switch(opcion){
                    case 1:
                        this.ingresarMateria();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2, aun esta PENDIENTE ESTA FUNCIONALIDAD");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3, aun esta PENDIENTE ESTA FUNCIONALIDAD");
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes elegir numeros entre las opciones unicamente");
                }
            }
        }
    }
    public Integer solicitarLegajo() {
        this.sn.nextLine(); //limpiar el buffer de entrada
        boolean legajoCorrecto = false;
        Integer legajo = null;

        System.out.println("Ingresa el legajo del alumno");
        while(!legajoCorrecto){
            legajo = this.sn.nextInt();
            if (legajo<100000 && legajo >9999) {
                legajoCorrecto = true;
            } else {
                System.out.println("Recuerda que el legajo debe ser un numero de 5 digitos");
            }
        }
        return legajo;
    }
    public void ingresarAlumno(){
        this.sn.nextLine(); //limpiar el buffer de entrada
        System.out.println("Ingresa el nombre del alumno");
        String nombre = this.sn.nextLine();
        System.out.println("Ingresa el apellido del alumno");
        String apellido = this.sn.nextLine();

        Integer legajo = this.solicitarLegajo();

        System.out.println("Ingresa el dni del alumno");
        Integer dni = this.sn.nextInt();

        System.out.println("¿Alumno tiene materias aprobadas? S / N");
        this.sn.nextLine(); //limpiar el buffer de entrada
        String aprobadas = this.sn.next().toUpperCase();

        String nombresMateriasAprobadas = "Sin aprobadas";
        if(aprobadas.equals("S")) {
            System.out.println("Por favor ingresa los NOMBRES de las materias aprobadas..");
            System.out.println("Colocalos separados por coma y sin espacios por favor. DEBEN SER MATERIAS PREVIAMENTE CREADAS");
            System.out.println("Por ejemplo: lengua I,matematica II,fisica I");
            this.sn.nextLine(); //limpiar el buffer de entrada
            nombresMateriasAprobadas = this.sn.nextLine();
        }
        System.out.println(controladorAlumnos.crearAlumno(nombre , apellido , legajo , dni , nombresMateriasAprobadas));
    }
    public void subMenuAlumnos() throws SQLException {
        System.out.println("Agreguemos alumnos");
        System.out.println("Estas de acuerdo? S / N");
        String iniciarSubMenu = this.sn.next().toUpperCase();

        if(iniciarSubMenu.equals("S")) {
            boolean salir = false;
            int opcion;
            while(!salir){
                System.out.println("<--- Elige una opcion por favor --->");
                System.out.println("1 - Ingresar nuevo alumno");
                System.out.println("2 - Eliminar alumno (PENDIENTE)");
                System.out.println("3 - Editar alumno (PENDIENTE)");
                System.out.println("9 - << TERMINAR MENU >>");
                opcion = this.sn.nextInt();

                switch(opcion){
                    case 1:
                        this.ingresarAlumno();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2, aun esta PENDIENTE ESTA FUNCIONALIDAD");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3, aun esta PENDIENTE ESTA FUNCIONALIDAD");
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes elegir numeros entre las opciones unicamente");
                }
            }
        }
    }
    public Materia solicitarMateria(){
        boolean nombreMateriaCorrecta = false;
        String nombreMateria = null;
        Materia materiaBuscada = null;

        System.out.println("Ingresa el nombre de la materia por favor");
        while(!nombreMateriaCorrecta){
            this.sn.nextLine(); //limpiar el buffer de entrada
            nombreMateria = this.sn.nextLine();
            materiaBuscada = controladorMaterias.buscarMateriaPorNombre(nombreMateria);
            if (materiaBuscada !=null) {
                nombreMateriaCorrecta = true;
            } else {
                System.out.println("No econtrarmos ese nombre de materia, vuelve a intentar por favor");
            }
        }
        return materiaBuscada;
    }
    public void ingresarInscripcion(){
        Alumno alumno = controladorAlumnos.buscarAlumnoByLegajo(this.solicitarLegajo());
        Materia materia = this.solicitarMateria();
        Inscripcion nuevaInscripcion = new Inscripcion(alumno , materia);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxx RESULTADO DE INSCRIPCION xxxxxxxxxxx");
        System.out.println(nuevaInscripcion);
        System.out.println("xxxxxxxxx FIN RESULTADO DE INSCRIPCION xxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    public void subMenuInscripcion() throws SQLException {
        System.out.println("Es hora de inscribir alumnos");
        System.out.println("Estas de acuerdo? S / N");
        String iniciarSubMenu = this.sn.next().toUpperCase();

        if(iniciarSubMenu.equals("S")) {
            boolean salir = false;
            int opcion;
            while(!salir){
                System.out.println("<--- Elige una opcion por favor --->");
                System.out.println("1 - Inscribir un alumno a una materia");
                System.out.println("2 - Eliminar inscripcion (PENDIENTE)");
                System.out.println("9 - << TERMINAR MENU>>");
                opcion = this.sn.nextInt();

                switch(opcion){
                    case 1:
                        this.ingresarInscripcion();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2, aun esta PENDIENTE ESTA FUNCIONALIDAD");
                        break;
                    case 9:
                        this.terminar = true;
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes elegir numeros entre las opciones unicamente");
                }
            }
        }
    }
    public void despedir(){
        System.out.println("*****************************");
        System.out.println("***** ¡ Hasta luego ! *****");
        System.out.println("*****************************");
    }

    public void iniciar () throws SQLException {
        /*
        saludar();
        subMenuMaterias();
        subMenuAlumnos();

         */
        subMenuInscripcion();
        despedir();
    }
}



