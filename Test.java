/*@By Andersson Jafett Beaz Estrada */
import java.util.Scanner;
//Maqueta o plantilla de mi clase Alumnos con sus metodos funciones publicas pero atributos privados
class Alumnos{
    private String curp;
    private int edad;
    private String nombre;
    private String semestre;

    //Constructor Alumnos
    public Alumnos(String curp, int edad, String nombre, String semestre){
        this.curp = curp;
        this.edad = edad;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    //metodos get para mostrar datos o valores almacenados
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
    //validacion de que obj es instancia de Alumnos y es un objeto

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Alumnos)) return false;
        Alumnos alumno = (Alumnos) obj;
        return this.curp == alumno.curp;
    }

    //metodo toString
    public String toString(){
        return ("Curp "+ curp + "Edad " + edad+ "Nombre " + nombre + "Semestre "+semestre); 
    }
}

abstract class Arreglos {
    private Alumnos[] alumnos;
    private int tamano;
    private int add = 0;

    public Arreglo(int tamano, int add,){
        this.tamano = tamano;
        this.add = add;
    }
    public void agregarAlPrincipio(Alumnos alumno){
        if (add == tamano){
            //hace una exepcion o crear un error personalizado
            //se utiliza mucho en el try catch
            //condicionales ternarias
            throw new RuntimeException("Error: El arreglo esta lleno");

        }
        for (int i = add; i > 0; i-- ){
            alumnos[i] = alumnos[i -1];
        }
        alumnos[0] = alumno;
        add ++;
    }

    public void agregarAlFinal(Alumnos alumno){
        if (add == tamano){
            throw new RuntimeException("Error: El arreglo esta lleno.");
        }
        alumnos[add] = alumno;
        add++;
    }
}

public class Test {
    
public static void main(String[] args) {
    //menu ciclado con dowhile tiene 11
}
    
}
