package Test;

import java.util.ArrayList;
import Model.Alumno;
import Model.Archivo;
import Model.Lista;
import java.util.Scanner;
import Login.Login;
public class App {
   public static void main(String[] args) throws Exception {
      ArrayList<Alumno> listaAlumnos = new ArrayList<>();
      ArrayList<Alumno> listaCalificaciones = new ArrayList<>();
      Archivo archivoAlumnos = new Archivo();
      Lista lista;
      archivoAlumnos.leerDocumento(listaAlumnos);
      archivoAlumnos.deteleTailTrash(listaAlumnos.get(0));


      Scanner entrada = new Scanner(System.in);
      Login loginSystem = new Login();
      

      //System.out.println(encriptador.encriptar("1"));
      //System.out.println(encriptador.desencriptar("SG9sYSBtZSBodWVsZSBsYSBjb2xhIGEgcGlsaW4="));



      lista = new Lista(listaAlumnos);

      //Codigo para mostrar el MenuHome
      //gui.mostrarMenuHome("Juan");
      //opcion = entrada.nextInt();
      
      loginSystem.solicitarCredenciales();
      





      //Codigo old 

      //lista.asignarCalificaciones(0,true);
      //listaCalificaciones = lista.obtenerCalificaciones();
      //archivoAlumnos.opcionSalida(listaCalificaciones);

      

   }
}