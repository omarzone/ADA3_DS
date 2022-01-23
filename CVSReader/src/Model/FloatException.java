package Model;

import java.util.InputMismatchException;

public class FloatException extends InputMismatchException{
    
    public FloatException(String mensaje){
        super(mensaje);
    }
}
