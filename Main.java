import java.util.LinkedList;

public class Main {
    public static void main(String[] src){
       /* Grafo<Integer> g= new Grafo<>(1);

        g.insertarVertice(1);
        g.insertarVertice(2);
        g.insertarVertice(3);
        g.insertarVertice(4);
        g.insertarVertice(5);
        g.insertarVertice(6);
        g.insertarVertice(7);



        g.insertarArco(1, 2, 5);
        g.insertarArco(1, 3, 2);
        g.insertarArco(1, 4, 3);
        g.insertarArco(3, 5, 8);
        g.insertarArco(4, 5, 4);
        g.insertarArco(5, 6, 3);
        g.insertarArco(5, 7, 2);

        g.floydWarshall(g.matriz);

        //imprimirM(g);*/

        Arbol_Busqueda_Binaria a = new Arbol_Busqueda_Binaria();
        a.raiz = new Nodo(12);
        a.raiz.izquierdo = new Nodo(4);
        a.raiz.izquierdo.izquierdo = new Nodo(2);
        a.raiz.izquierdo.derecho = new Nodo(7);
        a.raiz.derecho = new Nodo(14);
        a.raiz.derecho.izquierdo = new Nodo(13);
        a.raiz.derecho.derecho = new Nodo(19);

        //int[] arr = {1, 4 ,5, 12, 13, 14, 19};

        LinkedList<Nodo> lista = new LinkedList<Nodo>();
        System.out.print("Inorder traversal " +
                "before deletion:");
        a.inorder(a.raiz, lista);
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).nodo+ " ");
        }


        int key = 6;
        //a.agregarNodo(a.raiz, key);
        //a.borrarNodo(a.raiz, 4);
        System.out.println(a.altura(a.raiz));
        System.out.println(a.cantidad(a.raiz));
        System.out.println(a.max(a.raiz));
        System.out.println(a.min(a.raiz));
        //System.out.println(a.estaVacio());
        //System.out.println(a.esHoja(a.raiz.derecho.derecho));

        lista.clear();;
        System.out.print("\nInorder traversal " +
                "after deletion:");
        a.inorder(a.raiz, lista);
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).nodo+ " ");
        }

    }

    static void imprimirM(Grafo g){
        for (int i = 0; i < g.matriz[0].length; i++) {
            for (int j = 0; j < g.matriz[0].length; j++) {
                System.out.print(g.matriz[i][j] +" ");
            }
            System.out.println();
        }
    }


}
