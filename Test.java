/* @By Andersson Jafett Beaz Estrada */
import java.util.Scanner;

// Clase Alumnos
class Alumnos {
    private String curp;
    private int edad;
    private String nombre;
    private String semestre;

    public Alumnos(String curp, int edad, String nombre, String semestre) {
        this.curp = curp;
        this.edad = edad;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurp() {
        return curp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Alumnos)) return false;
        Alumnos alumno = (Alumnos) obj;
        return this.curp.equals(alumno.curp);
    }

    public String toString() {
        return "Curp: " + curp + ", Edad: " + edad + ", Nombre: " + nombre + ", Semestre: " + semestre;
    }

    public void setCurp(String curp2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurp'");
    }
}

// Clase Arreglo que contiene un arreglo de objetos Alumnos
class Arreglo {
    private Alumnos[] alumnos;
    private int tamano;
    private int contador;

    public Arreglo(int tamano) {
        this.tamano = tamano;
        alumnos = new Alumnos[tamano];
        contador = 0;
    }

    public void agregarAlPrincipio(Alumnos alumno) {
        if (contador == tamano) {
            throw new RuntimeException("Error: El arreglo está lleno");
        }
        for (int i = contador; i > 0; i--) {
            alumnos[i] = alumnos[i - 1];
        }
        alumnos[0] = alumno;
        contador++;
    }

    public void agregarAlFinal(Alumnos alumno) {
        if (contador == tamano) {
            throw new RuntimeException("Error: El arreglo está lleno.");
        }
        alumnos[contador] = alumno;
        contador++;
    }

    public void insertarEnPosicion(Alumnos alumno, int posicion) {
        if (contador == tamano) {
            throw new RuntimeException("Error: El arreglo está lleno");
        }
        if (posicion < 0 || posicion > contador) {
            throw new IllegalArgumentException("Error: Posición inválida");
        }
        for (int i = contador; i > posicion; i--) {
            alumnos[i] = alumnos[i - 1];
        }
        alumnos[posicion] = alumno;
        contador++;
    }

    public void borrarDelPrincipio() {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        for (int i = 0; i < contador - 1; i++) {
            alumnos[i] = alumnos[i + 1];
        }
        alumnos[contador - 1] = null;
        contador--;
    }

    public void borrarDelFinal() {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        alumnos[contador - 1] = null;
        contador--;
    }

    public void borrarEnPosicion(int posicion) {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        if (posicion < 0 || posicion >= contador) {
            throw new IllegalArgumentException("Error: Posición inválida");
        }
        for (int i = posicion; i < contador - 1; i++) {
            alumnos[i] = alumnos[i + 1];
        }
        alumnos[contador - 1] = null;
        contador--;
    }

    public void modificarDelPrincipio(Alumnos alumno) {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        alumno.setCurp(alumnos[0].getCurp()); // No modificar el ID primario
        alumnos[0] = alumno;
    }

    public void modificarDelFinal(Alumnos alumno) {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        alumno.setCurp(alumnos[contador - 1].getCurp()); // No modificar el ID primario
        alumnos[contador - 1] = alumno;
    }

    public void modificarEnPosicion(Alumnos alumno, int posicion) {
        if (contador == 0) {
            throw new RuntimeException("Error: El arreglo está vacío");
        }
        if (posicion < 0 || posicion >= contador) {
            throw new IllegalArgumentException("Error: Posición inválida");
        }
        alumno.setCurp(alumnos[posicion].getCurp()); // No modificar el ID primario
        alumnos[posicion] = alumno;
    }

    public void destruirArreglo() {
        for (int i = 0; i < contador; i++) {
            alumnos[i] = null;
        }
        contador = 0;
    }

    public void mostrar() {
        for (int i = 0; i < contador; i++) {
            System.out.println(alumnos[i]);
        }
    }

    public Object[] getAlumnos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlumnos'");
    }

    public int getContador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContador'");
    }
}

public class Test {
    private static Arreglo arreglo;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("- Andersson Jafett Beaz Estrada");

        int opcion;
        do {
            System.out.println("\nSelecciona una opción:");
            System.out.println("0 Salir");
            System.out.println("1 Crear arreglo");
            System.out.println("2 Agregar al principio");
            System.out.println("3 Agregar al final");
            System.out.println("4 Insertar en posición");
            System.out.println("5 Borrar del principio");
            System.out.println("6 Borrar del final");
            System.out.println("7 Borrar en posición");
            System.out.println("8 Modificar del principio");
            System.out.println("9 Modificar del final");
            System.out.println("10 Modificar en posición");
            System.out.println("11 Destruir arreglo");
            System.out.println("12 Mostrar");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearArreglo();
                    break;
                case 2:
                    agregarAlPrincipio();
                    break;
                case 3:
                    agregarAlFinal();
                    break;
                case 4:
                    insertarEnPosicion();
                    break;
                case 5:
                    borrarDelPrincipio();
                    break;
                case 6:
                    borrarDelFinal();
                    break;
                case 7:
                    borrarEnPosicion();
                    break;
                case 8:
                    modificarDelPrincipio();
                    break;
                case 9:
                    modificarDelFinal();
                    break;
                case 10:
                    modificarEnPosicion();
                    break;
                case 11:
                    destruirArreglo();
                    break;
                case 12:
                    mostrar();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            
        } while (opcion != 0);
    }

    private static void destruirArreglo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destruirArreglo'");
    }

    private static void crearArreglo() {
        System.out.println("Ingrese el tamaño del arreglo:");
        int tamaño = scanner.nextInt();
        arreglo = new Arreglo(tamaño);
        System.out.println("Arreglo creado con éxito.");
    }

    private static void agregarAlPrincipio() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese los datos del alumno (CURP, Edad, Nombre, Semestre):");
            String curp = scanner.next();
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(curp, edad, nombre, semestre);
            arreglo.agregarAlPrincipio(alumno);
            System.out.println("Alumno agregado al principio del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void agregarAlFinal() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese los datos del alumno (CURP, Edad, Nombre, Semestre):");
            String curp = scanner.next();
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(curp, edad, nombre, semestre);
            arreglo.agregarAlFinal(alumno);
            System.out.println("Alumno agregado al final del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertarEnPosicion() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese los datos del alumno (CURP, Edad, Nombre, Semestre):");
            String curp = scanner.next();
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(curp, edad, nombre, semestre);
            System.out.println("Ingrese la posición para insertar:");
            int posicion = scanner.nextInt();
            arreglo.insertarEnPosicion(alumno, posicion);
            System.out.println("Alumno insertado en la posición " + posicion + " del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarDelPrincipio() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            arreglo.borrarDelPrincipio();
            System.out.println("Alumno borrado del principio del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarDelFinal() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            arreglo.borrarDelFinal();
            System.out.println("Alumno borrado del final del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarEnPosicion() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese la posición para borrar:");
            int posicion = scanner.nextInt();
            arreglo.borrarEnPosicion(posicion);
            System.out.println("Alumno borrado en la posición " + posicion + " del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarDelPrincipio() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese los nuevos datos del alumno (Edad, Nombre, Semestre):");
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(((Alumnos) arreglo.getAlumnos()[0]).getCurp(), edad, nombre, semestre);
            arreglo.modificarDelPrincipio(alumno);
            System.out.println("Alumno modificado en el principio del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarDelFinal() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese los nuevos datos del alumno (Edad, Nombre, Semestre):");
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(((Alumnos) arreglo.getAlumnos()[arreglo.getContador() - 1]).getCurp(), edad, nombre, semestre);
            arreglo.modificarDelFinal(alumno);
            System.out.println("Alumno modificado en el final del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarEnPosicion() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        try {
            System.out.println("Ingrese la posición para modificar:");
            int posicion = scanner.nextInt();
            System.out.println("Ingrese los nuevos datos del alumno (Edad, Nombre, Semestre):");
            int edad = scanner.nextInt();
            String nombre = scanner.next();
            String semestre = scanner.next();
            Alumnos alumno = new Alumnos(((Alumnos) arreglo.getAlumnos()[posicion]).getCurp(), edad, nombre, semestre);
            arreglo.modificarEnPosicion(alumno, posicion);
            System.out.println("Alumno modificado en la posición " + posicion + " del arreglo.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrar() {
        if (arreglo == null) {
            System.out.println("Error: Debes crear el arreglo primero.");
            return;
        }
        System.out.println("Contenido del arreglo:");
        arreglo.mostrar();
    }
}