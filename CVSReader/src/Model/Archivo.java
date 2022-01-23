package Model;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private final static String RUTA_ARCHIVO = "CVSReader/src/Docs/listac.csv";
    private final static String SEPARADOR = ",";
    private BufferedReader lectorDocumento = null;

    public void deteleTailTrash(Alumno alumno) {
        String data = alumno.getMatricula();
        alumno.setMatricula(data.replaceAll("ï»¿", ""));
    }

    public void leerDocumento(ArrayList<Alumno> listaAlumnos) throws Exception {
        try {
            this.lectorDocumento = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea = lectorDocumento.readLine();
            while (linea != null) {
                String[] datosArchivo = linea.split(SEPARADOR);
                listaAlumnos.add(new Alumno(datosArchivo[0], datosArchivo[1], datosArchivo[2], datosArchivo[3]));
                linea = lectorDocumento.readLine();
            }

        } catch (Exception ex) {
            System.out.println("problema detectado " + ex);

        } finally {
            if (null != lectorDocumento) {
                lectorDocumento.close();
            }

        }

    }

    private void generarArchivoSalida(ArrayList<Alumno> listaCalificaciones) throws IOException {
        String MATERIA = "Diseño de software";
        FileOutputStream archivoCsv = new FileOutputStream("CVSReader/src/Docs/salida.csv");
        OutputStreamWriter salida = new OutputStreamWriter(archivoCsv, "UTF-8");

        for (Alumno alumno : listaCalificaciones) {
            try {
                salida.write(
                        alumno.getMatricula() + "," + MATERIA + "," + String.valueOf(alumno.getCalificacion() + "\n"));
            } catch (IOException ex) {
                System.out.print(ex);
            }

        }

        salida.close();

    }

    public void opcionSalida(ArrayList<Alumno> listaCalificaciones) throws IOException {
        char caracter;
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("¿Desea generar un archivo con las califaciones? (S/N)");
            caracter = entrada.next().charAt(0);
            if (caracter == 's' || caracter == 'S') {
                this.generarArchivoSalida(listaCalificaciones);
                System.out.println("Archivo generado en salida.csv");
            } else if(caracter == 'n' || caracter == 'N'){

                System.out.println("Programa terminado");
            }else {

                throw new IOException();
            }
        } catch (Exception e) {
            System.out.println("Ingrese una opcion correcta");
            opcionSalida(listaCalificaciones);
        }
    }
}
