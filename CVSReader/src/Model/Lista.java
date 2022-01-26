package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista extends GUI {
    private ArrayList<Alumno> alumnos;

    public Lista(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void asignarCalificaciones(int index, boolean mostrarGUI) throws FloatException {
        Scanner scanner = new Scanner(System.in);
        int calificacion = 1;
        
        if (mostrarGUI) {
            mostrarCabeceraRc();
        }

        for (int i = index; i < this.alumnos.size(); i++) {
            //System.out.print("contador: "+ i +"\n");
            System.out.print(alumnos.get(i).getMatricula().toString() + ":                  ");
            try {
                do {
                    if (calificacion < 1 || calificacion > 100) {
                        System.out.println("No ingrese calificaciones invalidas");
                        System.out.print(alumnos.get(i).getMatricula().toString() + ":                  ");
                    }
                    calificacion = scanner.nextInt();
                } while (calificacion < 1 || calificacion > 100);
                alumnos.get(i).setCalificacion(calificacion);

            } catch (InputMismatchException ex) {
                System.out.println("No ingrese calificaciones que no sean enteras");
                scanner.reset();
                
                
                this.asignarCalificaciones(i, false);
                //asignamos el valor del contador i igual al tamano del array para que finalize el for padre;
                i = this.alumnos.size();
            }
        }

    }

    public ArrayList<Alumno> obtenerCalificaciones() {
        return this.alumnos;
    }

}
