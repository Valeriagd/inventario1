package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class menu {

    public static void agenda(String[] args) {
        /*comprobarBD();
        menuOpcionesPrincipal();*/

    }

    public void menuOpcionesPrincipal() {
        Scanner opmenu = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                               INVENTARIO");
            System.out.println("---------------------------------------------------------------------\n");

            System.out.println("Ingresar una de las opciones siguientes:\n");
            System.out.println("1.Agregar Usuario: ");
            System.out.println("2.Agregar Equipo: ");
            System.out.println("3.Agregar un nuevo periodo de asignacion");
            System.out.println("4.Salir del programa");
            //opcion = opmenu.nextInt();
            System.out.println("---------------------------------------------------------------------\n");
            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("                    AGREGAR NUEVO USUARIO                                ");
                        System.out.println("---------------------------------------------------------------------\n");
                        CrearUsuario crear = new CrearUsuario();
                        crear.ListaUsuarios();
                        System.out.println("---------------------------------------------------------------------\n");
                        break;
                    case 2:
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("                      AGREGAR EQUIPO                                ");
                        System.out.println("---------------------------------------------------------------------\n");
                        CrearEquipo crearPaciente = new CrearEquipo();
                        crearPaciente.ListaEquipos();
                        System.out.println("\n---------------------------------------------------------------------");
                        System.out.println("----------------------------------------------------------------------\n\n");
                        break;
                    case 3:
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("                       AGREGAR PERIODO DE ASIGNACION                   ");
                        System.out.println("---------------------------------------------------------------------\n");
                        PeriodoAsignacion crearCita = new PeriodoAsignacion();
                        crearCita.ListaAsignacion();
                        System.out.println("\n---------------------------------------------------------------------");
                        System.out.println("----------------------------------------------------------------------\n\n");
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion no valida");
                scanner.next();
            }

        }

    }
    //Usuario.add(new Usuario())
            /*ImportarCSV();
            ExportarCSV(Usuarios);*/
}
