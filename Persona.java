/*By Andersson Jafett Beaz Estrada */
import java.util.ArrayList;
public class Persona{
    private String curp;// atributo primario
    private String nombre;
    private Integer edad;


    public Persona(){

    }

    public Persona(String curp, String nombre, Integer edad){
        this.curp= curp;
        this.nombre= nombre;
        this.edad= edad;
    }

    public void setCurp(String curp){
        this.curp=curp;
    }
    public String getCurp(){
        return curp;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setEdad(Integer edad){
        this.edad=edad;
    }
    public Integer getEdad(){
        return edad;
    }


    public boolean equals(Persona p){    //equals sirve para comparar
        if(p==null) return false;
        if(this.curp.equals(p.getCurp()))  //compara objetos
            return false;  //si no coincide, lo negara
        return true;  //si coincide, lo aceptara
    }

    public String toString(){
        return "Persona{ curp:"+curp+" nombre:"+nombre+" edad:"+edad+"}\n";
    }
}