import java.util.LinkedList;
import java.util.Queue;

class Arbol_Busqueda_Binaria {
    Nodo raiz;

    Arbol_Busqueda_Binaria() {
        raiz = null;
    }

    LinkedList<Nodo> levelOrder() {
        LinkedList<Nodo> lista = new LinkedList<Nodo>();
        Queue<Nodo> queue = new LinkedList<Nodo>();
        queue.add(raiz);
        while (!queue.isEmpty()) {
            Nodo nodo = queue.poll();
            lista.add(nodo);

            if (nodo.izquierdo != null) {
                queue.add(nodo.derecho);
            }

            if (nodo.derecho != null) {
                queue.add(nodo.derecho);
            }
        }
        return lista;
    }

    void postorder(Nodo nodo, LinkedList<Nodo> recorrido) {
        if (nodo == null)
            return;

        postorder(nodo.izquierdo, recorrido);

        postorder(nodo.derecho, recorrido);

        recorrido.add(nodo);
    }

    void inorder(Nodo nodo, LinkedList<Nodo> recorrido) {
        if (nodo == null)
            return;

        inorder(nodo.izquierdo, recorrido);

        recorrido.add(nodo);

        inorder(nodo.derecho, recorrido);
    }

    void preorder(Nodo nodo, LinkedList<Nodo> recorrido) {
        if (nodo == null)
            return;

        recorrido.add(nodo);

        preorder(nodo.izquierdo, recorrido);

        preorder(nodo.derecho, recorrido);
    }

    boolean estaVacio(){
        return (raiz == null)? true : false;
    }

    int cantidad(Nodo nodo){
        if(nodo == null) return 0;
        else return (1 + cantidad(nodo.izquierdo) + cantidad(nodo.derecho));
    }

    int altura(Nodo nodo){
        if(nodo == null) return 0;
        else return (1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho)));
    }

    boolean esHoja(Nodo nodo){
        return (nodo.izquierdo == null && nodo.derecho == null)? true : false;
    }

    int min(Nodo nodo){
        if(nodo.izquierdo == null)
            return nodo.nodo;
        else return min(nodo.izquierdo);
    }

    int max(Nodo nodo){
        if(nodo.derecho == null)
            return nodo.nodo;
        else return max(nodo.derecho);
    }

    Nodo agregarNodo(Nodo raiz, int nodo) {
        if (raiz == null) {
            raiz = new Nodo(nodo);
            return raiz;
        }

        if (nodo < raiz.nodo)
            raiz.izquierdo = agregarNodo(raiz.izquierdo, nodo);
        else if (nodo > raiz.nodo)
            raiz.derecho = agregarNodo(raiz.derecho, nodo);

        return raiz;
    }

    Nodo borrarNodo(Nodo raiz, int nodo) {
        if (raiz == null)
            return raiz;

        if (raiz.nodo > nodo) {
            raiz.izquierdo = borrarNodo(raiz.izquierdo, nodo);
            return raiz;
        } else if (raiz.nodo < nodo) {
            raiz.derecho = borrarNodo(raiz.derecho, nodo);
            return raiz;
        }

        if (raiz.izquierdo == null) {
            Nodo temp = raiz.derecho;
            return temp;
        } else if (raiz.derecho == null) {
            Nodo temp = raiz.izquierdo;
            return temp;
        } else {
            Nodo succParent = raiz;
            Nodo succ = raiz.derecho;

            while (succ.izquierdo!= null) {
                succParent = succ;
                succ = succ.izquierdo;
            }

            if (succParent != raiz)
                succParent.izquierdo = succ.derecho;
            else
                succParent.derecho = succ.derecho;

            raiz.nodo = succ.nodo;

            return raiz;
        }
    }
}
