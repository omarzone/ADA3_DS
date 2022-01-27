package Login;

import java.util.ArrayList;

import Model.Archivo;
import Model.Usuario;

public class Login {
    private String usuario;
    private String password;
    private ArrayList<Usuario> listaUsuarios;
 
    public Login(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }

    public void ObtenerUsuarios(){
        listaUsuarios = new ArrayList<>();
        Archivo archivoUsuarios = new Archivo("CVSReader/src/Docs/Usuarios.csv");
        try{
            this.listaUsuarios = archivoUsuarios.leerDocumento();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    
    }

    public boolean comprobarLogin(){
        boolean flag = false;

        for(Usuario Usuario : this.listaUsuarios){
            if((this.usuario.toLowerCase() == Usuario.getUser().toLowerCase()) && (this.password == Usuario.getPassword().toLowerCase())){
                flag = true;
            }
        }
        return flag;

    }
    
    public ArrayList<Usuario> getLista(){

        return this.listaUsuarios;
    }
    

    


}


