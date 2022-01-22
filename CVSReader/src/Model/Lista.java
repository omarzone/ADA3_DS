package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    private ArrayList<Alumno> alumnos;

    public Lista(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void asignarCalificaciones(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------DISEÑO DE SOFTWARE--------------------");
        System.out.println("Ingrese las calificaciones de los alumnos");
        System.out.println("Matricula                  Calificación");
        
        for (Alumno alumno : alumnos) {
            System.out.print(alumno.getMatricula().toString()+ ":");
            alumno.setCalificacion(scanner.nextInt());
        }
    }

}
