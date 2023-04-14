public class ArbolBBAVL {

    private Nodo<T> raiz;

    public void insertar(T valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo<T> insertar(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return new Nodo<T>(valor);
        }

        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecho = insertar(nodo.derecho, valor);
        } else {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = balance(nodo);

        if (balance > 1 && valor.compareTo(nodo.izquierdo.valor) < 0) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor.compareTo(nodo.derecho.valor) > 0) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && valor.compareTo(nodo.izquierdo.valor) > 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor.compareTo(nodo.derecho.valor) < 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public void eliminar(T valor) {
        raiz = eliminar(raiz, valor);
    }

    private Nodo<T> eliminar(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecho = eliminar(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null || nodo.derecho == null) {
                Nodo<T> temp = null;

                if (temp == nodo.izquierdo) {
                    temp = nodo.derecho;
                } else {
                    temp = nodo.izquierdo;
                }

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                Nodo<T> temp = minimo(nodo.derecho);
                nodo.valor = temp.valor;
                nodo.derecho = eliminar(nodo.derecho, temp.valor);
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = balance(nodo);

        if (balance > 1 && balance(nodo.izquierdo) >= 0) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && balance(nodo.derecho) <= 0) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && balance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && balance(nodo.derecho) > 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public boolean buscar(T valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return false;
        }

        if (valor.compareTo(nodo.valor) < 0) {
            return buscar(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            return buscar(nodo.derecho, valor);
        } else {
            return true;
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo<T> nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }
    }

    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(Nodo<T> nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    private Nodo<T> rotarDerecha(Nodo<T> y) {
        Nodo<T> x = y.izquierdo;
        Nodo<T> temp = x.derecho;

        x.derecho = y;
        y.izquierdo = temp;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    private Nodo<T> rotarIzquierda(Nodo<T> x) {
        Nodo<T> y = x.derecho;
        Nodo<T> temp = y.izquierdo;

        y.izquierdo = x;
        x.derecho = temp;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        return nodo.altura;
    }

    private int balance(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private Nodo<T> minimo(Nodo<T> nodo) {
        Nodo<T> actual = nodo;

        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }

        return actual; }

    private Nodo<T> eliminar(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecho = eliminar(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null || nodo.derecho == null) {
                Nodo<T> temp = null;

                if (nodo.izquierdo == null) {
                    temp = nodo.derecho;
                } else {
                    temp = nodo.izquierdo;
                }

                if (temp == null) {
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                Nodo<T> temp = minimo(nodo.derecho);

                nodo.valor = temp.valor;

                nodo.derecho = eliminar(nodo.derecho, temp.valor);
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;

        int balance = balance(nodo);

        if (balance > 1 && balance(nodo.izquierdo) >= 0) {
            return rotarDerecha(nodo);
        }

        if (balance > 1 && balance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && balance(nodo.derecho) <= 0) {
            return rotarIzquierda(nodo);
        }

        if (balance < -1 && balance(nodo.derecho) > 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    }
