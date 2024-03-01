import java.util.Scanner;

class Alumnos{
    private String curp;
    private int edad;
    private String nombre;
    private String semestre;

    public Alumnos(String curp, int edad, String nombre, String semestre){
        this.curp = curp;
        this.edad = edad;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public int getEdad(){
        return edad;
    }

    public String getCurp(){
        return curp;
    }
    public String getNombre(){
        return nombre;
    }
    public String getSemestre(){
        return semestre;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Alumnos)) return false;
        Alumnos alumno = (Alumnos) obj;
        return this.curp == alumno.curp;
    }

    public String toString(){
        return ("Curp "+ curp + "Edad " + edad+ "Nombre " + nombre + "Semestre "+semestre);
    }
}





public class Test {
    
public static void main(String[] args) {
    
}
    
}