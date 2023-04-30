package org.example.persistencia;

import org.example.entidades.Alumno;
import org.example.entidades.Materia;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

   // Conexion conexionBD= null;
    Connection conectar = null;
    String usuario = "root";
    String constraseña = "154647572";
    String ruta = "jdbc:mysql://localhost:3306/utn";


    public Conexion() {
       // this.conexionBD = new Conexion();
    }

    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(ruta, usuario,constraseña);
            // System.out.println("supuestamente se conecto la bd");
            // JOptionPane.showMessageDialog(null, "SE CONECTO CORRECTAMENTE");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE CONECTOOOOOO"+e);
        }
        return conectar;
    }

    public void guardarAlumno(Alumno alumno){
        String nombre = alumno.getNombre();
        String apellido = alumno.getApellido();
        Integer legajo = alumno.getLegajo();
        Integer dni = alumno.getDni();
        String nombresMateriasAprobadas = alumno.getNombresMateriasAprobadas();

        try {
            Connection connection =  this.establecerConexion();
            Statement stmt =connection.createStatement();

            if(nombresMateriasAprobadas.length()==0){
                String execute = "INSERT INTO alumnos (nombre, apellido, legajo, dni)\n"
                        +"VALUES ('" + nombre + "', '"+ apellido +"', "+legajo+","+dni+")";
                stmt.executeUpdate(execute);
            } else {
                String execute = "INSERT INTO alumnos (nombre, apellido, legajo, dni, materiasAprobadas)\n"
                        +"VALUES ('" + nombre + "', '"+ apellido +"', "+legajo+","+dni+",'"+nombresMateriasAprobadas+"')";
                stmt.executeUpdate(execute);
            }

            connection.close();
        } catch (Exception e){ System.out.println(e);};
    }

    public void guardarMateria(Materia materia){
        String nombreMateria = materia.getNombreMateria();
        List<Materia> materiasCorrelativas = materia.getCorrelativas();
        try {
            Connection connection =  this.establecerConexion();
            Statement stmt =connection.createStatement();

            if(materiasCorrelativas.size()==0){
                String execute = "INSERT INTO materias (nombreMateria, materiasCorrelativas)\n"
                        +"VALUES ('" + nombreMateria + "', '"+ null +"')";
                stmt.executeUpdate(execute);
            } else {
                String materiasString = "";
                for (int i = 0; i < materiasCorrelativas.size(); i++ ){
                    materiasString += materiasCorrelativas.get(i).getNombreMateria() + ",";
                }
                String execute = "INSERT INTO materias (nombreMateria, materiasCorrelativas)\n"
                        +"VALUES ('" + nombreMateria + "', '"+ materiasString +"')";
                stmt.executeUpdate(execute);
            }
            connection.close();
        } catch (Exception e){ System.out.println(e);};
    }

    public Materia buscarMateriaByNombre (String nombreMateria){
        Materia materiaBuscada = null;
        try {
            Connection connection =  this.establecerConexion();
            Statement stmt =connection.createStatement();
            String query = "SELECT * FROM materias WHERE nombreMateria = '"+ nombreMateria +"'";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                materiaBuscada = new Materia();
                materiaBuscada.setNombreMateria(rs.getString("nombreMateria"));
                materiaBuscada.setNombresMateriasCorrelativa(rs.getString("materiasCorrelativas"));
            }
            connection.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE CONECTOOOOOO"+e);
        }
        return materiaBuscada;
    }

    public List<Materia> leerMaterias (){
        List<Materia> materias = new ArrayList<>();
        try {
            Connection connection =  this.establecerConexion();
            Statement stmt =connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM materias");

            while(rs.next())
                materias.add(new Materia(rs.getString("nombreMateria"), rs.getString("materiasCorrelativas")));
            connection.close();
        } catch (Exception e){ System.out.println(e);};
        return materias;
    }

    public ResultSet leerEstudiantes (Conexion conexionBD){
        ResultSet rs = null;
        try {
            Connection connection =  conexionBD.establecerConexion();
            Statement stmt =connection.createStatement();
            rs= stmt.executeQuery("SELECT * FROM alumnos");
            /*
            while(rs.next())
                System.out.println(rs.getString("nombre"));
            */
            connection.close();
        } catch (Exception e){ System.out.println(e);};

        return rs;
    }


    public Alumno buscarAlumnoByLegajo (Integer legajo){
        Alumno alumnoBuscado = null;
        try {
            Connection connection =  this.establecerConexion();
            Statement stmt =connection.createStatement();
            String query = "SELECT * FROM alumnos WHERE legajo = "+ legajo;
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
                alumnoBuscado = new Alumno(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("legajo"), rs.getInt("dni") , rs.getString("materiasAprobadas"));
            connection.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "NO SE CONECTOOOOOO"+e);
        }
        return alumnoBuscado;
    }








    /*
    public ResultSet ejecutarQuery (String query){
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conectar.prepareStatement(query);
            rs = stmt.executeQuery();
            //while (rs.next())
             //   System.out.println (rs.getString("country"));

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return  rs;
    }
*/
    public void cerrarConexion() throws SQLException {
        conectar.close();
    }


    // metodo de cierre de conexion

    // metodo de crear statement y ejecutarlo

    // estos metodos luegos los immpiorto en app y los uso




}
