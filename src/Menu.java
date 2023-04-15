import java.util.Scanner;

public class Menu {
    static ArbolBB arbol = new ArbolBB();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }



    public static void opcion1() {
        System.out.println("--- Arbol Binario de Busqueda ---");

        Scanner sc = new Scanner(System.in);
        int opcionab;
        do {
            mostrarMenuBusqueda();
            opcionab = sc.nextInt();
            switch (opcionab) {
                case 1:
                    opcion1ab();
                    break;
                case 2:
                    opcion2ab();
                    break;
                case 3:
                    opcion3ab();
                    break;
                case 4:
                    opcion4ab();
                    break;
                case 5:
                    System.out.println("¡Regresando...!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionab != 5);



    }

    public static void opcion2() {
        System.out.println("--- Árbol BB AVL ---");
       // Scanner sc = new Scanner(System.in);
        int opcionbb;
        do {
            mostrarMenuBusqueda();
            opcionbb = sc.nextInt();
            switch (opcionbb) {
                case 1:
                    opcion1bb();
                    break;
                case 2:
                    opcion2bb();
                    break;
                case 3:
                    opcion3bb();
                    break;
                case 4:
                    opcion4bb();
                    break;
                case 5:
                    System.out.println("¡Regresando...!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionbb != 5);

    }

    public static void opcion1ab() {
        System.out.println("--- Insertar ---");
        int ValorI;
        System.out.print("Ingrese el  valor del nodo:");
        ValorI = sc.nextInt();
        // Insertar elementos
        arbol.insertar(ValorI);



    }
    public static void opcion2ab() {
        System.out.println("--- Eliminar ---");
        int NodoBorrar;
        System.out.print("Ingrese Nodo que desea borrar:");
        NodoBorrar = sc.nextInt();
        arbol.eliminar(NodoBorrar);
        /*arbol.eliminar(1);
        arbol.eliminar(8);*/

    }
    public static void opcion3ab() {
        System.out.println("--- Buscar ---");
        // Buscar elementos
        System.out.println(arbol.buscar(3)); // true
        System.out.println(arbol.buscar(7)); // false
    }
    public static void opcion4ab() {
        System.out.println("--- Recorrido ---");

        //Scanner sc = new Scanner(System.in);
        int opcionabr;
        do {
            mostrarMenuRecorridos();
            opcionabr = sc.nextInt();
            switch (opcionabr) {
                case 1:
                    opcion1Recoriidosab();
                    break;
                case 2:
                    opcion2Recoriidosab();
                    break;
                case 3:
                    opcion3Recoriidosab();
                    break;
                case 4:
                    System.out.println("¡Regresando...!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionabr != 4);

    }
    public static void opcion1Recoriidosab() {

        System.out.println("--- Inorden ---");
        arbol.recorridoInorden(); // 1 2 3 5 6 8 9
        System.out.println();
    }
    public static void opcion2Recoriidosab() {
        System.out.println("--- Preorden ---");
        arbol.recorridoPreorden(); // 5 2 1 3 8 6 9
        System.out.println();
    }
    public static void opcion3Recoriidosab() {
        System.out.println("--- Postorden ---");
        arbol.recorridoPostorden(); // 1 3 2 6 9 8 5
        System.out.println();
    }


    public static void opcion1bb() {
        System.out.println("--- Insertar ---");
    }
    public static void opcion2bb() {
        System.out.println("--- Eliminar ---");
    }
    public static void opcion3bb() {
        System.out.println("--- Buscar ---");
    }
    public static void opcion4bb() {
        System.out.println("--- Recorrido ---");

       // Scanner sc = new Scanner(System.in);
        int opcionbbr;
        do {
            mostrarMenuRecorridos();
            opcionbbr = sc.nextInt();
            switch (opcionbbr) {
                case 1:
                    opcion1Recoriidosbb();
                    break;
                case 2:
                    opcion2Recoriidosbb();
                    break;
                case 3:
                    opcion3Recoriidosbb();
                    break;
                case 4:
                    System.out.println("¡Regresando...!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionbbr != 4);

    }

    public static void opcion1Recoriidosbb() {
        System.out.println("--- Inorden ---");
    }
    public static void opcion2Recoriidosbb() {
        System.out.println("--- Preorden ---");
    }
    public static void opcion3Recoriidosbb() {
        System.out.println("--- Postorden ---");
    }


    public static void mostrarMenuRecorridos() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Inorden ");
        System.out.println("2. Preorden ");
        System.out.println("3. Postorden ");
        System.out.println("4. Regresar");
        System.out.print("Seleccione una opción: ");
    }
    public static void mostrarMenu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Arbol Binario de Busqueda");
        System.out.println("2. Árbol BB AVL ");
        System.out.println("3. Salir ");
        System.out.print("Seleccione una opción: ");
    }
    public static void mostrarMenuBusqueda() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Insertar");
        System.out.println("2. Eliminar ");
        System.out.println("3. Buscar");
        System.out.println("4. Recorrido");
        System.out.println("5. Regresar");
        System.out.print("Seleccione una opción: ");
    }


}
