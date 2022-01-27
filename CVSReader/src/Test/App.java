package Test;

import java.util.ArrayList;
import Model.Alumno;
import Model.Archivo;
import Model.Encriptador;
import Model.Lista;
import Model.Usuario;
import Model.GUI;
import java.util.Scanner;
import Login.Login;


public class App {
   public static void main(String[] args) throws Exception {
      ArrayList<Alumno> listaAlumnos = new ArrayList<>();
      ArrayList<Alumno> listaCalificaciones = new ArrayList<>();
      Archivo archivoAlumnos = new Archivo("CVSReader/src/Docs/Lista.csv");
      Lista lista;
      archivoAlumnos.leerDocumento(listaAlumnos);
      archivoAlumnos.deteleTailTrash(listaAlumnos.get(0));

      GUI gui = new GUI();
      Scanner entrada = new Scanner(System.in);
      int opcion;
      Encriptador encriptador = new Encriptador();
      ArrayList<Usuario> listaLogins = new ArrayList<>();
      

      //System.out.println(encriptador.encriptar("1"));
      //System.out.println(encriptador.desencriptar("SG9sYSBtZSBodWVsZSBsYSBjb2xhIGEgcGlsaW4="));



      lista = new Lista(listaAlumnos);
      
      Login login = new Login("Fredy", "caca");
      login.ObtenerUsuarios();
      listaLogins = login.getLista();

      for (Usuario usuario : listaLogins) {
         System.out.println(usuario.getUser() + " " + usuario.getPassword());
      }
      //Codigo para mostrar el MenuHome
      //gui.mostrarMenuHome("Juan");
      //opcion = entrada.nextInt();
      
      //gui.mostrarCabeceraLogin();
      
      



      //Codigo old 

      //lista.asignarCalificaciones(0,true);
      //listaCalificaciones = lista.obtenerCalificaciones();
      //archivoAlumnos.opcionSalida(listaCalificaciones);

      

   }
}