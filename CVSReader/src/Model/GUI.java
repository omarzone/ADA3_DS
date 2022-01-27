package Model;



public class GUI {

    public void mostrarMenuHome(String usuario) {

        System.out.println("==============================================");
        System.out.println("       Registro de calificaciones V1");
        System.out.println("             Hola: " + usuario);
        System.out.println("==============================================");
        System.out.println("    Selecione una opcion del menu:");
        System.out.println("        1. Registrar calificaciones");
        System.out.println("        2. Generar archivo de salidad");
        System.out.println("        3. Salir");
        System.out.println("");
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
