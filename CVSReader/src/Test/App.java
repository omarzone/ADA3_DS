package Test;

import java.util.ArrayList;
import Model.Alumno;
import Model.Archivo;
import Model.GUI;
import Model.Lista;
import Model.Usuario;

import java.util.Scanner;

import Login.Login;

public class App {
   public static void main(String[] args) throws Exception {
      ArrayList<Alumno> listaAlumnos = new ArrayList<>();
      ArrayList<Alumno> listaCalificaciones = new ArrayList<>();
      Archivo archivoAlumnos = new Archivo();
      Lista lista;
      GUI menu = new GUI();
      Usuario usuario;
      int opcion;
      boolean mostrarCalificaciones = false;
      int opcionSalida;

      archivoAlumnos.leerDocumento(listaAlumnos);
      archivoAlumnos.deteleTailTrash(listaAlumnos.get(0));

      Scanner entrada = new Scanner(System.in);
      Login loginSystem = new Login();

      lista = new Lista(listaAlumnos);
      usuario = loginSystem.solicitarCredenciales();
      opcion = menu.mostrarMenuHome(usuario.getUser());

      // Usuario para test
      // Usuario: omar
      // Password: 1

      while (opcion != 3) {

         if (opcion == 1) {
            lista.asignarCalificaciones(0, true);
            mostrarCalificaciones = true;
            opcion = menu.mostrarMenuHome(usuario.getUser());
         } else if (opcion == 2 && mostrarCalificaciones) {
            listaCalificaciones = lista.obtenerCalificaciones();
            // archivoAlumnos.opcionSalida(listaCalificaciones);
            opcionSalida = menu.mostrarCabeceraGs();
            if(opcionSalida == 1){
               archivoAlumnos.generarPdf(listaCalificaciones);
            }else{
               archivoAlumnos.opcionSalida(listaCalificaciones);
            }
            System.out.println("Se ha generado el archivo de salida");
            opcion = menu.mostrarMenuHome(usuario.getUser());

         } else {
            System.out.println("Primero Ingrese las calificaciones");
            opcion = menu.mostrarMenuHome(usuario.getUser());
         }

      }

      // Test para generar PDF

   }
}