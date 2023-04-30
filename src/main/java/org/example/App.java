package org.example;

import org.example.interfaz.Menu;

import java.sql.*;

public class App 
{
    public static void main( String[] args ) throws SQLException {

        Menu menuInicial = new Menu();
        menuInicial.iniciar();

    }
}
