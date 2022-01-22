package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {
    private final static String RUTA_ARCHIVO = "CVSReader/src/Docs/Lista.csv";
    private final static String SEPARADOR = ",";
    private BufferedReader lectorDocumento = null;
    

    public void deteleTailTrash(Alumno alumno){
        String data = alumno.getMatricula();
        alumno.setMatricula(data.replaceAll("ï»¿", ""));
    }



    public void leerDocumento(ArrayList<Alumno> listaAlumnos) throws Exception{
        try{
            this.lectorDocumento = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea = lectorDocumento.readLine(); 
            while(linea != null){
                String [] datosArchivo = linea.split(SEPARADOR); 
                listaAlumnos.add(new Alumno(datosArchivo[0], datosArchivo[1], datosArchivo[2], datosArchivo[3]));
                linea = lectorDocumento.readLine(); 
            }
            
        }catch(Exception ex){
            System.out.println("problema detectado " +ex);


        }finally{
            if(null!= lectorDocumento){
                lectorDocumento.close();    
            }
            
        }

    }
}
