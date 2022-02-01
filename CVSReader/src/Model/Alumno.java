package Model;

public class Alumno {
    private String matricula;
    private String pApellido;
    private String sApellido;
    private String nombres;
    private String calificacion;

    
    public Alumno(String matricula, String pApellido, String sApellido, String nombres) {
        this.matricula = matricula;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.nombres = nombres;
        
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getPApellido() {
        return this.pApellido;
    }

    public String getSApellido() {
        return this.sApellido;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setCalificacion(String calificacionAsignada){
        this.calificacion = calificacionAsignada;
    }

    public String getCalificacion(){
        return this.calificacion;
    }

    public String [] getArray(){
        String[] datos = {matricula, "Diseno de software", String.valueOf(calificacion)};
        return datos;
    }
}   
