public class Main {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();

        // Insertar elementos
        arbol.insertar(5);
        arbol.insertar(2);
        arbol.insertar(8);
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(6);
        arbol.insertar(9);

        // Recorridos
        System.out.print("Inorden: ");
        arbol.recorridoInorden(); // 1 2 3 5 6 8 9
        System.out.println();

        System.out.print("Preorden: ");
        arbol.recorridoPreorden(); // 5 2 1 3 8 6 9
        System.out.println();

        System.out.print("Postorden: ");
        arbol.recorridoPostorden(); // 1 3 2 6 9 8 5
        System.out.println();


        // Eliminar elementos
        arbol.eliminar(3);
        arbol.eliminar(1);
        arbol.eliminar(8);

        // Recorridos
        System.out.print("Inorden: ");
        arbol.recorridoInorden(); // 1 2 3 5 6 8 9
        System.out.println();

        System.out.print("Preorden: ");
        arbol.recorridoPreorden(); // 5 2 1 3 8 6 9
        System.out.println();

        System.out.print("Postorden: ");
        arbol.recorridoPostorden(); // 1 3 2 6 9 8 5
        System.out.println();

        // Recorrido inorden después de eliminar elementos
        System.out.print("Inorden después de eliminar: ");
        arbol.recorridoInorden(); // 2 5 6 9
        System.out.println();


        // Buscar elementos
        System.out.println(arbol.buscar(3)); // true
        System.out.println(arbol.buscar(7)); // false

        // Recorridos
        System.out.print("Inorden: ");
        arbol.recorridoInorden(); // 1 2 3 5 6 8 9
        System.out.println();

        System.out.print("Preorden: ");
        arbol.recorridoPreorden(); // 5 2 1 3 8 6 9
        System.out.println();

        System.out.print("Postorden: ");
        arbol.recorridoPostorden(); // 1 3 2 6 9 8 5
        System.out.println();

    }
}