/*By Andersson Jafett Beaz Estrada */
public class ListaDobleCircular{
    private Nodo primero;
    private Nodo ultimo;
    private int cantidad=0;

    public ListaDobleCircular(){




    }
    public int getCantidad() {
        return cantidad;
    }

    public boolean insertarPrincipio(Nodo nuevo){
        if(primero==null){
            primero=nuevo;
            ultimo=primero;
        }else{
            primero.anterior=nuevo;
            nuevo.siguiente=primero;
            primero=nuevo;

            //ListaDobleCircular
            ultimo.siguiente=primero;
            primero.anterior=ultimo;
        }
        cantidad++;

        return true;

    }
    public boolean insertarPosicion(Nodo nuevo, int posicion){
        Nodo actual=primero;
        while(actual!=null && posicion<=cantidad ){
            if(actual==ultimo){
                break;
            }
            actual=actual.siguiente;//recorrido

        }
        nuevo.siguiente=actual;
        actual.anterior.siguiente=nuevo;
        nuevo.anterior=actual.anterior;
        actual.anterior=nuevo;
        cantidad--;
        return true;

    }
    public boolean insertarFinal(Nodo nuevo){
        if(ultimo==null){//cuANDO LA LIST ESTA VACIA
            ultimo=nuevo;
            primero=ultimo;
            //return true;
        }else{//a partir de un nodo
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
            //ListaDobleCircular
            ultimo.siguiente=primero;
            primero.anterior=ultimo;
            //return true;

        }
        cantidad++;
        return true;




    }
    public Persona buscarPosicion(int posicion){
        if (posicion < 1 || posicion > cantidad) {
            System.out.println("Posición no válida");
            return null;
        }

        Nodo actual = primero;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.per;
    }

    public Persona buscarDato(Persona per){
        Nodo actual = primero;
        while (actual != null) {
            if (actual.per.equals(per)) {
                return actual.per;
            }
            if (actual == ultimo) {
                break;
            }
            actual = actual.siguiente;
        }
        return null;
    }



    public Nodo removerPrincipio(){
        Nodo actual = null;
        if (primero == null) {//la lista esta vacia 
           // System.out.println("Lista vacía, no se puede remover del principio");
            return null;
        } else if(primero.siguiente==null){//la lista tiene un solo nodo
            actual = primero;
            primero=null;
            ultimo=null;
            cantidad--;
            return actual;
        } else if(primero.siguiente!=null){
            actual=primero;//guardar el primer nodo 
            primero.anterior=null;// enlace circular al ultimo nodo
            ultimo.siguiente=primero.siguiente;//apunta al nuevo primero nodo 
            primero.siguiente.anterior=ultimo;//nuevo primero apunto a ultimo
            primero=primero.siguiente;//reasigna el primer nodo
            actual.siguiente=null;//rompe el enlace al nuevp primero
            cantidad--;
            return actual;//devuelve el nodo quitado
        }

    return null;
}
    public Persona removerPosicion(int posicion){
         Nodo actual=primero;
        while(actual!=null && posicion >=1 && posicion<=cantidad ){
            if(actual==ultimo){
                break;
            }
            actual=actual.siguiente;//recorrido

        }
       Nodo quitar=actual;
       actual.anterior.siguiente=actual.siguiente;
       actual.siguiente.anterior=actual.anterior;
       actual.anterior=null;
       actual.siguiente=null;
        return actual;//si falla intentar con quitar
    }



    public Persona removerFinal(){
        Nodo actual = null;
        if (ultimo == null) {//la lista esta vacia 
           // System.out.println("Lista vacía, no se puede remover del principio");
            return null;
        } else if(ultimo.anterior==null){//la lista tiene un solo nodo
            actual = ultimo;
            primero=null;
            ultimo=null;
            cantidad--;
            return actual;
        } else if(ultimo.anterior!=null){
            actual=ultimo;//guardar el primer nodo 
            ultimo.siguiente=null;// enlace circular al ultimo nodo
            primero.anterior=ultimo.anterior;//apunta al nuevo primero nodo 
            ultimo.anterior.siguiente=primero;//nuevo primero apunto a ultimo
            ultimo=ultimo.anterior;//reasigna el primer nodo
            actual.anterior=null;//rompe el enlace al nuevp primero
            cantidad--;
            return actual;//devuelve el nodo quitado
        }
    }




    public String mostrarLista(){
        Nodo actual=primero;
        if(actual==null){
            return "lista vacia";
        }
        String datos="";
        while(actual!=null ){
            datos=datos+actual.per;//sacar el dato
            if(actual==ultimo){
                break;
            }
            actual=actual.siguiente;//recorrido

        }
        return datos;


    }
    public boolean actualizarPosicion(Persona per,int posicion) {

        if (posicion < 1 || posicion > cantidad) {
            System.out.println("Posición no válida");
            return false;
        }


            Nodo actual = primero;
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }

            actual.per = per;
            return true;


        }

    public boolean reemlazarPosicion(Persona per, int posicion){
            if(posicion < 1 || posicion > cantidad) {
                System.out.println("Posición no válida");
                return false;
            }

            Nodo actual = primero;
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }

            Nodo nuevo = new Nodo(per);

            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual.anterior;

            actual.anterior.siguiente = nuevo;
            actual.siguiente.anterior = nuevo;

            return true;
        }


    public boolean destruirLista(){
        primero = null;
        ultimo = null;
        cantidad = 0;
        return true;
    }







}