package Test;


import java.util.ArrayList;

import Model.Alumno;
import Model.Archivo;
import Model.Lista;

public class App {
   public static void main(String[] args) throws Exception {
      ArrayList<Alumno> listaAlumnos = new ArrayList<>();
      Archivo archivoAlumnos = new Archivo();
      Lista lista;

      archivoAlumnos.leerDocumento(listaAlumnos);
      archivoAlumnos.deteleTailTrash(listaAlumnos.get(0));

      
      lista = new Lista(listaAlumnos);
      lista.asignarCalificaciones();
     
      
      
   }
}