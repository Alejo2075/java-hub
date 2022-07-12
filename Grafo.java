import com.sun.source.tree.BinaryTree;

import java.util.*;

public class Grafo<T> {
    protected LinkedList<T> v;
    protected int[][] matriz;

    public Grafo(int n){
        v = new LinkedList<>();
        matriz = new int[n][n];
    }

    boolean estaVacio(){
        return v.size()==0? true : false;
    }

    int numeroVertices(){
        return v.size();
    }

    int numeroArcos(){
        int c = 0;
        for (int i = 0; i < v.size(); i++) {
            for (int j = i; j < v.size(); j++) {
                if(matriz[i][j] > 0) c++;
            }
        }
        return c;
    }

    boolean estaVertice(T v){
        return this.v.contains(v)? true : false;
    }

    boolean estaArco(T v1, T v2){
        return this.matriz[this.v.indexOf(v1)][this.v.indexOf(v2)] > 0? true : false;
    }

    void insertarVertice(T v){ //arreglar
        int[][] aux = Arrays.copyOf(matriz, this.v.size());
        this.v.add(v);
        matriz = new int[this.v.size()][this.v.size()];
        for (int i = 0; i < this.v.size()-1; i++) {
            for (int j = 0; j < this.v.size()-1; j++) {
                matriz[i][j] = aux[i][j];
            }
        }
    }

    void insertarArco(T v1, T v2, int peso){
        matriz[this.v.indexOf(v1)][this.v.indexOf(v2)] = peso;
        matriz[this.v.indexOf(v2)][this.v.indexOf(v1)] = peso;
    }

    void eliminarVertice(T v){
        int[][] aux = Arrays.copyOf(matriz, this.v.size());
        int indice = this.v.indexOf(v);
        this.v.remove(v);
        matriz = new int[this.v.size()][this.v.size()];
        for (int i = 0; i < this.v.size(); i++) {
            for (int j = 0; j < this.v.size(); j++) {
                if(i < indice && j < indice)matriz[i][j] = aux[i][j];
                else if(j < indice) matriz[i][j] = aux[i+1][j];
                else if(i < indice) matriz[i][j] = aux[i][j+1];
                else matriz[i][j] = aux[i+1][j+1];
            }
        }
    }

    void eliminarArco(T v1, T v2){
        matriz[this.v.indexOf(v1)][this.v.indexOf(v2)] = 0;
        matriz[this.v.indexOf(v2)][this.v.indexOf(v1)] = 0;
    }

    LinkedList<T> adyacentesA(T v){
        LinkedList<T> lista = new LinkedList<T>();
        for (int i = 0; i < this.v.size(); i++) {
            if(matriz[this.v.indexOf(v)][i] > 0)lista.add(this.v.get(i));
        }
        return lista;
    }

    void reemplazar(T v, T n){
        this.v.set(this.v.indexOf(v), n);
    }

    LinkedList<T> recorrerALoAncho(T inicio){
        LinkedList<T> lista = new LinkedList<T>();
        boolean[] visitados = new boolean[this.v.size()];
        Queue<T> cola = new LinkedList<T>();
        lista.add(inicio);
        cola.add(inicio);
        visitados[this.v.indexOf(inicio)] = true;
        while(!cola.isEmpty()){
            int actual = v.indexOf(cola.poll());
            for (int i = 0; i < this.v.size(); i++) {
                if(matriz[actual][i]>0 && !visitados[i]){
                    cola.add(this.v.get(i));
                    lista.add(this.v.get(i));
                    visitados[i] = true;
                }
            }
        }
        return lista;
    }

    LinkedList<T> recorrerEnProfundidad(T inicio, boolean[] visitados){
        LinkedList<T> lista = new LinkedList<T>();
        visitados[this.v.indexOf(inicio)] = true;
        for (int i = 0; i < this.v.size(); i++) {
            if(matriz[this.v.indexOf(inicio)][i]>0 && !visitados[i]){
                lista.add(this.v.get(i));
                recorrerEnProfundidad(this.v.get(i), visitados);
            }
        }
        return lista;
    }

    boolean esConexo(){
        return (recorrerALoAncho(this.v.get(0)).size() == this.v.size()) ? true : false;
    }

    int[]  dijkstra(T v){
        int[] distancia = new int[this.v.size()];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[this.v.indexOf(v)] = 0;
        boolean[] visitados = new boolean[this.v.size()];
        PriorityQueue<Peso> colaP = new PriorityQueue<Peso>();

        colaP.add(new Peso(v, 0));

        while (!colaP.isEmpty()){
            T actual = colaP.poll().nodo;
            System.out.println(actual);
            visitados[this.v.indexOf(actual)] = true;
            for (int j = 0; j < this.v.size(); j++) {
                if (distancia[this.v.indexOf(actual)] + matriz[this.v.indexOf(actual)][j] < distancia[j] && !visitados[j] && matriz[this.v.indexOf(actual)][j] > 0) {
                    distancia[j] = distancia[this.v.indexOf(actual)] + matriz[this.v.indexOf(actual)][j];
                    colaP.add(new Peso(this.v.get(j), distancia[j]));
                }
            }
        }
        return distancia;
    }

    int[][] floydWarshall(int[][] matriz){
        int dist[][] = matriz;

        for (int i = 0; i < this.v.size(); i++) {
            for (int j = 0; j < this.v.size(); j++) {
                if(dist[i][j] == 0 && i!=j) dist[i][j] = 10000;
            }
        }

        for (int k = 0; k < this.v.size(); k++) {
            for (int i = 0; i < this.v.size(); i++) {
                for (int j = 0; j < this.v.size(); j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }

    private class Peso implements Comparable<Peso>{
        T nodo;
        int peso;

        public Peso(T v, int i) {
            this.nodo = v;
            this.peso = i;
        }

        @Override
        public int compareTo(Peso o) {
            if(this.peso > o.peso) return 1;
            else if (this.peso < o.peso) return -1;
            else return 0;
        }

    }



}
