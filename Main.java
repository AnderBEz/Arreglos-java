/*@By Andersson Jafett Beaz Estrada */
import java.util.Scanner;
public class Main
{
    private static Scanner teclado = new Scanner(System.in);
    private static Persona per;
    private static Nodo actual;
    private static ListaDobleCircular lista;

    public static void main(String[] args) {
        System.out.println("Andersson Jafett Beaz Estrada");
        int opcion=-1;
        do{
            System.out.println("0 Salir");
            System.out.println("1 Crear Arreglo");
            System.out.println("2 Agregar al principio");
            System.out.println("3 Agregar al Final");
            System.out.println("4 Insertar Posicion ");
            System.out.println("5 Borrar del Principio");
            System.out.println("6 Buscar al Final");
            System.out.println("7  Borrar en Posicion");
            System.out.println("8 Modificar del Principio");
            System.out.println("9 Modificar del final");
            System.out.println("10 Modificar en Posicion");
            System.out.println("11 Destruir arreglo");
            System.out.println("12 Mostrar");

            opcion=teclado.nextInt();
            switch(opcion){
                case 0: Salir(); break;
                case 1: CrearArreglo(); break;
                case 2: AgregarPrincipio(); break;
                case 3: AgregarFinal(); break;
                case 4: InsertarPosicion(); break;
                case 5: BorrarPrincipio(); break;
                case 6: BuscarFinal(); break;
                case 7: BorrarPosicion();break;
                case 8: ModificarPrincipio();break;
                case 9: ModificarFinal();break;
                case 10: ModificarEnPosicion();break;
                case 11: DestruirArreglo();break;
                case 12: Mostrar();break;
                default:noValido(); break;
            }
        }while(opcion!=0);

        System.out.println("");
        System.out.println(" FIN DEL PROGRAMA");
        System.out.println("Andersson Jafett Beaz Estrada");
    }

    private static void Salir(){
        System.out.println("Ya llegale \n");
    }
    private static void CrearArreglo(){
        System.out.println("opcion de crear \n");
        if(lista==null ){
            lista=new ListaDobleCircular();
            System.out.println("la lista ya a sido creada");

        }else{
            System.out.println("la lista ya existe");


        }
    }
    private static void AgregarPrincipio(){
        System.out.println("Opcion de Agregar al principio");
        per=new Persona();
        capturarDatos();
        actual=new Nodo(per);
        if(lista.insertarPrincipio(actual)){
            System.out.println("elemento agregado");
        }else{

            System.out.println("elemento NO agregado");
        }
    }


    private static void InsertarPosicion(){
        System.out.println("Opcion de agregar Posicion \n");
        if (lista != null) {
            int posicion = teclado.nextInt();
            per = new Persona();
            capturarDatos();
            actual = new Nodo(per);
            if (lista.insertarPosicion(actual, posicion)) {
                System.out.println("Elemento agregado en la posición " + posicion);
            } else {
                System.out.println("Elemento NO agregado.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }


    private static void AgregarFinal(){
        System.out.println("Opcion de agregar final \n");
        if (lista != null) {
            per = new Persona();
            capturarDatos();
            actual = new Nodo(per);
            if (lista.insertarFinal(actual)) {
                System.out.println("Elemento agregado al final.");
            } else {
                System.out.println("Elemento NO agregado.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }
    private static void  BorrarPrincipio(){

        if(lista==null){
            System.out.println("La lista no a sido creada");
        } else{
            System.out.println("Opcion de borrar del principio");
            actual=lista.removerPrincipio();
            if(actual==null){
                System.out.println("la lista esta vacia");
            }else{
                System.out.println("La lista removida es "+actual.per);
            }
            
        }
    }


    private static void BuscarFinal(){
        System.out.println("Opcion de Buscar al Final");
        if (lista != null) {
            Persona personaEncontrada = lista.buscarPosicion(lista.getCantidad());
            if (personaEncontrada != null) {
                System.out.println("Elemento encontrado al final: " + personaEncontrada);
            } else {
                System.out.println("No se encontró elemento al final.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }
    private static void BorrarPosicion(){
        if(lista==null){
            System.out.println("La lista no a sido creada");
        } else{
            System.out.println("Opcion de borrar del principio");
            System.out.println("Introduca la posicion a quitar");
            int posicion=teclado.nextInt();
            actual=lista.removerPrincipio(posicion);
            if(actual==null){
                System.out.println("la lista esta vacia");
            }else{
                System.out.println("La lista removida es "+actual.per);
            }
            
        }
    }
    private static void ModificarPrincipio(){
        System.out.println("Opcion de modificar del principio \n");
        if (lista != null) {
            Persona per = new Persona();
            capturarDatos();
            if (lista.actualizarPosicion(per, 1)) {
                System.out.println("Elemento modificado en el principio.");
            } else {
                System.out.println("No se pudo modificar elemento en el principio.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }
    private static void ModificarFinal(){
        System.out.println("Opcion de Modificar del final");
        if (lista != null) {
            Persona per = new Persona();
            capturarDatos();
            if (lista.actualizarPosicion(per, lista.getCantidad())) {
                System.out.println("Elemento modificado en el final.");
            } else {
                System.out.println("No se pudo modificar elemento en el final.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }

private static void ModificarEnPosicion(){
    System.out.println("Opcion de modificar posicion");
    if(lista!= null){
        System.out.println("Introduce la posición deseada a modificar");
            int posicion = teclado.nextInt();
            if (posicion >= 1 && posicion <= lista.getCantidad()){
                System.out.println("Posicion Correcta Seleccionada");
            }
            System.out.println("Introduce la posicion nueva");
            int posicion1 = teclado.nextInt();
            if (posicion1 >= 1 && posicion1 <= lista.getCantidad()){
                posicion=posicion1;
                System.out.println("Posicion modificada");
            }
        
    }
    else if(lista==null){
        System.out.println("Debe de creearse primero los elementos para poderles modificar su posicion");
    }
    
}

    private static void Mostrar(){
        System.out.println("Opcion de Mostrar listas");
        System.out.println(""+lista.mostrarLista());
    }
    
    private static void ModificarPosicion(){
        System.out.println("Opcion de Modificar la Posicion");
        if (lista != null) {
            System.out.println("Introduce la posición a modificar");
            int posicion = teclado.nextInt();
            if (posicion >= 1 && posicion <= lista.getCantidad()) {
                Persona per = new Persona();

                per=new Persona();
                capturarDatos();
                actual=new Nodo(per);
                if (lista.actualizarPosicion(per, posicion)) {
                    System.out.println("Elemento modificado en la posición " + posicion);
                } else {
                    System.out.println("No se pudo modificar elemento en la posición " + posicion);
                }
            } else {
                System.out.println("Posición no válida.");
            }
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }


    private static void DestruirArreglo(){
        System.out.println("Opcion de Destruir Arreglo");
        if (lista != null) {
            lista.destruirLista();
            System.out.println("La lista ha sido destruida correctamente.");
        } else {
            System.out.println("La lista no ha sido creada.");
        }
    }

    private static void noValido(){
        System.out.println("Opcion no valida");
    }

    private static void capturarDatos(){
        per = new Persona();
        System.out.println("Introduce la curp");
        per.setCurp(teclado.next());
        System.out.println("Introduce la Nombre");
        per.setNombre(teclado.next());
        System.out.println("Introduce la Edad");
        per.setEdad(teclado.nextInt());




    }
}