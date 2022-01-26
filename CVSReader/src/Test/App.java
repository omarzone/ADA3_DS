package Test;

import java.util.ArrayList;
import Model.Alumno;
import Model.Archivo;
import Model.Encriptador;
import Model.Lista;
import Model.GUI;
import java.util.Scanner;

import com.csvreader.CsvReader;


public class App {
   public static void main(String[] args) throws Exception {
      ArrayList<Alumno> listaAlumnos = new ArrayList<>();
      ArrayList<Alumno> listaCalificaciones = new ArrayList<>();
      Archivo archivoAlumnos = new Archivo();
      Lista lista;
      archivoAlumnos.leerDocumento(listaAlumnos);
      archivoAlumnos.deteleTailTrash(listaAlumnos.get(0));

      GUI gui = new GUI();
      Scanner entrada = new Scanner(System.in);
      int opcion;
      Encriptador encriptador = new Encriptador();
      

      //System.out.println(encriptador.encriptar("1"));
      //System.out.println(encriptador.desencriptar("SG9sYSBtZSBodWVsZSBsYSBjb2xhIGEgcGlsaW4="));



      lista = new Lista(listaAlumnos);

      //Codigo para mostrar el MenuHome
      //gui.mostrarMenuHome("Juan");
      //opcion = entrada.nextInt();
      
      gui.mostrarCabeceraLogin();





      //Codigo old 

      //lista.asignarCalificaciones(0,true);
      //listaCalificaciones = lista.obtenerCalificaciones();
      //archivoAlumnos.opcionSalida(listaCalificaciones);

      

   }
}