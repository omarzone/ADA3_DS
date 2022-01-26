package Model;

import java.util.Base64;

public class Encriptador {
    
    public String encriptar(String cadena){
        String cadenaEncriptada;
        
        cadenaEncriptada = Base64.getEncoder().encodeToString(cadena.getBytes());

        return cadenaEncriptada;
    }
    
    public String desencriptar(String cadena){
        byte[] bytesDecodificados = Base64.getDecoder().decode(cadena);
        String cadenaDecodificada = new String(bytesDecodificados);

        return cadenaDecodificada;
    }
}
