import java.util.LinkedList;
import java.util.Queue;

class Arbol_Binario {
    Nodo raiz;

    Arbol_Binario() {
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

    void agregarNodo(int nodo) {
        Queue<Nodo> q = new LinkedList<Nodo>();
        q.add(raiz);

        while (!q.isEmpty()) {
            Nodo temp = q.poll();

            if (temp.izquierdo == null) {
                temp.izquierdo = new Nodo(nodo);
                break;
            } else q.add(temp.izquierdo);

            if (temp.derecho == null) {
                temp.derecho = new Nodo(nodo);
                break;
            } else q.add(temp.derecho);
        }
    }

    void borrarNodo(Nodo raiz, int nodo) {
        if (raiz == null)
            return;

        if (raiz.izquierdo == null && raiz.derecho == null) {
            if (raiz.nodo == nodo) {
                raiz = null;
                return;
            } else return;
        }

        Queue<Nodo> q = new LinkedList<Nodo>();
        q.add(raiz);
        Nodo temp = null, nodoBorrar = null;

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.nodo == nodo) {
                nodoBorrar = temp;
            }

            if (temp.izquierdo != null)
                q.add(temp.izquierdo);

            if (temp.derecho != null)
                q.add(temp.derecho);
        }

        if (nodoBorrar != null) {
            nodoBorrar.nodo = temp.nodo;
            borrarUltimoNodo(raiz, temp);
        }
    }

    void borrarUltimoNodo(Nodo raiz, Nodo ultimo) {
        Queue<Nodo> q = new LinkedList<Nodo>();
        q.add(raiz);

        while (!q.isEmpty()) {
            Nodo nodo = q.poll();

            if (nodo == ultimo) {
                nodo = null;
                return;
            }
            if (nodo.derecho != null) {
                if (nodo.derecho == ultimo) {
                    nodo.derecho = null;
                    return;
                }
                else q.add(nodo.derecho);
            }
            if (nodo.izquierdo != null) {
                if (nodo.izquierdo == ultimo) {
                    nodo.izquierdo = null;
                    return;
                }
                else q.add(nodo.izquierdo);
            }
        }
    }

}

