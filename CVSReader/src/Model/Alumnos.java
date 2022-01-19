package Model;

public class Alumnos {
    private int matricula;
    private String pApellido;
    private String sApellido;
    private String nombres;
    private int calificacion;

    
    public Alumnos(int matricula, String pApellido, String sApellido, String nombres) {
        this.matricula = matricula;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.nombres = nombres;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getPApellido() {
        return pApellido;
    }

    public String getSApellido() {
        return sApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setCalificacion(int calificacionAsignada){
        this.calificacion = calificacionAsignada;
    }

    public int getCalificacion(){
        return this.calificacion;
    }
}   
