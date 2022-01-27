package Model;

import java.util.Scanner;

public class GUI {

    public int mostrarMenuHome(String usuario) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("       Registro de calificaciones V1");
        System.out.println("             Hola: " + usuario);
        System.out.println("==============================================");
        System.out.println("    Selecione una opcion del menu:");
        System.out.println("        1. Registrar calificaciones");
        System.out.println("        2. Generar archivo de salidad");
        System.out.println("        3. Salir");
        System.out.println("");
        try{
            return entrada.nextInt();
        }catch(Exception ex){
            System.out.println("No ingrese opciones invalidas");
            mostrarMenuHome(usuario);
            return 0;
        }
        
    }

    public void mostrarCabeceraRc() {
        System.out.println("==============DISEÑO DE SOFTWARE==============");
        System.out.println("Ingrese las calificaciones de los alumnos");
        System.out.println("Matricula                  Calificación");
    }

    public void mostrarCabeceraGs() {
        System.out.println("==============================================");
        System.out.println("");
        System.out.println("       Exportar calificaciones");
        System.out.println("");
        System.out.println("==============================================");
        System.out.println("    Selecione el formato para exportar:");
        System.out.println("        1. PDF");
        System.out.println("        2. CSV");
    }

    public void mostrarCabeceraLogin(){

        System.out.println("==============================================");
        System.out.println("                    LOGIN");
        System.out.println("Proporcione un nombre de usuario y contrasena");
        System.out.println("               para continuar");
        System.out.println("==============================================");



     
    }

}
