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

public class CrearEquipo {
    public void ListaEquipos() {
        List<Equipo> Equipos = new ArrayList<Equipo>();

        Scanner numero = new Scanner(System.in);
        System.out.println("¿Cuantos equipos vas a ingresar?");
        var no = numero.nextInt();


        for (int x = 0; x < no; x++) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingresa el nombre del equipo");
            var nombre = entrada.nextLine();

            Scanner leer = new Scanner(System.in);
            System.out.println("Ingresa el ID");
            var id = leer.nextLine();

            Scanner entrada1 = new Scanner(System.in);
            System.out.println("Numero de serie");
            var numeros = entrada1.nextLine();

            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Ingresa la fecha de compra");
            var fecha = entrada2.nextLine();

            Scanner entrada3 = new Scanner(System.in);
            System.out.println("Ingresa el modelo");
            var modelo = entrada3.nextLine();


            Equipos.add(new Equipo(nombre, id, numeros, fecha, modelo));

            //Usuarios.add(new Usuario())
            /*();
            ExportarCSV(Equipos);*/

        }
    }

    private static final String RutaEquipo = System.getProperty("user.home");
    private static final String DocumentoEquipo = "DataBaseEquipo.csv";

    public static void ExportarCSV(List<Equipo> Equipos){
        //String salidaArchivo = "DataBasePaciente.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaEquipo,separador,DocumentoEquipo);
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoDataBaseEquipo = new File(salidaArchivo);
            archivoDataBaseEquipo.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("ID");
            salidaCSV.write("Numero");
            salidaCSV.write("Fecha");
            salidaCSV.write("Modelo");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

            // Recorremos la lista y lo insertamos en el archivo
            for(Equipo user : Equipos) {
                salidaCSV.write(user.getNOMBRE());
                salidaCSV.write(user.getID());
                salidaCSV.write(user.getNUMERO());
                salidaCSV.write(user.getFECHA());
                salidaCSV.write(user.getMODELO());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void ImportarCSV() {
        try{
            List<Equipo> usuarios = new ArrayList<Equipo>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("DataBaseEquipo.csv");
            leerUsuarios.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Nombre = leerUsuarios.get(0);
                String ID = leerUsuarios.get(1);
                String Numero = leerUsuarios.get(2);
                String Fecha  = leerUsuarios.get(3);
                String Modelo = leerUsuarios.get(4);

                usuarios.add(new Equipo(Nombre, ID, Numero, Fecha, Modelo)); // Añade la informacion a la lista
            }

            //leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
            /*for(Paciente user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getTELEFONO() + " , "
                        +user.getCORREO() + " , "
                        +user.getEDAD() + " , "
                        +user.getGENERO());

            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }*/
}
