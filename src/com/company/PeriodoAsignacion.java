package com.company;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodoAsignacion {
    public void ListaAsignacion() {
        List<Asignacion> Asignaciones = new ArrayList<Asignacion>();

        Scanner numero = new Scanner(System.in);
        System.out.println("¿Cuantas Asignaciones vas a ingresar?");
        var no = numero.nextInt();


        for (int x = 0; x < no; x++) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingresa el nombre del equipo");
            var nombre = entrada.nextLine();

            Scanner leer = new Scanner(System.in);
            System.out.println("Ingresa la fecha de asignacion");
            var fecha = leer.nextLine();

            Scanner entrada1 = new Scanner(System.in);
            System.out.println("Ingresa la hora");
            var hora = entrada1.nextLine();

            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Ingresa el motivo");
            var motivo = entrada2.nextLine();

            Scanner entrada3 = new Scanner(System.in);
            System.out.println("Ingresa el nombre del Usuario");
            var nomusuario = entrada3.nextLine();


            Asignaciones.add(new Asignacion(nombre, fecha, hora, motivo, nomusuario));


            /*ImportarCSV();
            ExportarCSV(Asignaciones);*/

        }
    }

    private static final String RutaAsignacion = System.getProperty("user.home");
    private static final String DocumentoAsignacion = "DataBaseAsignacion.csv";

    public static void ExportarCSV(List<Asignacion> Asignaciones){
        //String salidaArchivo = "DataBaseCitas.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaAsignacion,separador,DocumentoAsignacion);
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoDataBaseAsignaciones = new File(salidaArchivo);
            archivoDataBaseAsignaciones.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Fecha");
            salidaCSV.write("Hora");
            salidaCSV.write("Motivo");
            salidaCSV.write("Usuario");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

            // Recorremos la lista y lo insertamos en el archivo
            for(Asignacion user : Asignaciones) {
                salidaCSV.write(user.getNOMBRE());
                salidaCSV.write(user.getFECHA());
                salidaCSV.write(user.getHORA());
                salidaCSV.write(user.getMOTIVO());
                salidaCSV.write(user.getNOMUSUARIO());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void ImportarCSV() {
        try{
            List<Asignacion> usuarios = new ArrayList<Asignacion>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("DataBaseCitas.csv");
            leerUsuarios.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Nombre = leerUsuarios.get(0);
                String Fecha = leerUsuarios.get(1);
                String Hora = leerUsuarios.get(2);
                String Motivo  = leerUsuarios.get(3);
                String NomUsuario= leerUsuarios.get(4);

                usuarios.add(new Asignacion(Nombre, Fecha, Hora, Motivo, NomUsuario)); // Añade la informacion a la lista
            }

            // leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
          /*  for(Cita user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getFECHA() + " , "
                        +user.getHORA() + " , "
                        +user.getMOTIVO() + " , "
                        +user.getNOMDOCTOR());

            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }*/
}
