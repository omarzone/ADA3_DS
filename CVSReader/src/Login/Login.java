package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Encriptador;
import Model.GUI;
import Model.Usuario;

public class Login {
    private final static String RUTA_USUARIOS = "src/Docs/Usuarios.csv";
    private final static String SEPARADOR = ",";
    private BufferedReader lectorDocumento = null;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    Encriptador encriptador = new Encriptador();
    GUI gui = new GUI();


    public void solicitarCredenciales(){
        Usuario user = new Usuario();
        Scanner entrada = new Scanner(System.in);

        gui.mostrarCabeceraLogin();

        System.out.print("Usuario:");
        user.setUser(entrada.nextLine());
        System.out.print("Password:");
        user.setPassword(entrada.nextLine());

        this.comprobarLogin(user);

    }


    private void comprobarLogin(Usuario usuario) {
        boolean loginOk = false;
        try{
            leerUsuarios();
            for(Usuario usuariodb: listaUsuarios){
                
                if(usuario.getUser().equals(usuariodb.getUser()) && encriptador.encriptar(usuario.getPassword()).equals(usuariodb.getPassword())){
                    loginOk = true;
                }
                
            }
        }catch (Exception exv){
            System.out.println("Ocurrio un problema al verificar los datos");
        }

        if(loginOk){
            gui.mostrarMenuHome(usuario.getUser());
        }else{
            solicitarCredenciales();
        }

    }

    private void leerUsuarios() throws Exception{
        try {
            this.lectorDocumento = new BufferedReader(new FileReader(RUTA_USUARIOS));
            String linea = lectorDocumento.readLine();
            while (linea != null) {
                String[] datosArchivo = linea.split(SEPARADOR);
                listaUsuarios.add(new Usuario(datosArchivo[0],datosArchivo[1]));
                linea = lectorDocumento.readLine();
            }

        } catch (Exception ex) {
            System.out.println("Problema detectado archivo Usuarios " + ex);

        } finally {
            if (null != lectorDocumento) {
                lectorDocumento.close();
            }
        }
    }
}
