public class ArbolBB {
    private Nodo raiz;

    private class Nodo {
        private int valor;
        private Nodo izq, der;

        public Nodo(int valor) {
            this.valor = valor;
        }
    }

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izq = insertar(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = insertar(nodo.der, valor);
        } else {
            // El valor ya existe en el árbol, no se hace nada
        }

        return nodo;
    }

    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    private Nodo eliminar(Nodo nodo, int valor) {
        if (nodo == null) {
            System.out.println("Valor no encontrado");
            return null;
        }

        if (valor < nodo.valor) {
            nodo.izq = eliminar(nodo.izq, valor);
        } else if (valor > nodo.valor) {
            nodo.der = eliminar(nodo.der, valor);
        } else {
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }

            Nodo sucesor = obtenerSucesor(nodo.der);
            nodo.valor = sucesor.valor;
            nodo.der = eliminar(nodo.der, sucesor.valor);

        }

        return nodo;
    }

    private Nodo obtenerSucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.valor) {
            return true;
        } else if (valor < nodo.valor) {
            return buscar(nodo.izq, valor);
        } else {
            return buscar(nodo.der, valor);
        }
    }

    public void recorridoInorden() {
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izq);
            System.out.print(nodo.valor + " ");
            recorridoInorden(nodo.der);
        }
    }

    public void recorridoPreorden() {
        recorridoPreorden(raiz);
    }

    private void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            recorridoPreorden(nodo.izq);
            recorridoPreorden(nodo.der);
        }
    }

    public void recorridoPostorden() {
        recorridoPostorden(raiz);
    }

    private void recorridoPostorden(Nodo nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izq);
            recorridoPostorden(nodo.der);
            System.out.print(nodo.valor + " ");
        }
    }




}
