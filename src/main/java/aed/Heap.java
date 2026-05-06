package aed;

public class Heap <T extends Comparable<T>> {
    private T[] lista;
    private int cardinal;


    private class HeapHandle {
        int pos;
        HeapHandle(int pos) {
            this.pos = pos;
        }
    }
    // Se crea el heap tomando como base una lista en O(n)
    public Heap(T[] v){
        lista = (T[]) new Comparable[v.length];
        for (int i = 0; i < v.length; i++) {
            T elem = v[i];
            lista[i] = elem;
            if (elem instanceof HandleSupport) {
                ((HandleSupport)elem).setHandle(new HeapHandle(i));
            }
            
        }
        cardinal = v.length;
        heapify();        
    }
    // Dado un elemento revisa si tiene un handle de heap y si es asi lo usa para reordenarlo en la lista
    public void modificarPos(T elem) {
        if (elem instanceof HandleSupport) {
            int pos = ((HeapHandle)((HandleSupport)elem).getHandle()).pos;
            subir(pos);
            bajar(pos);

        }
    }
    // Dado un indice, baja el elemento si es que es posible
    private void bajar(int pos) {
        int i_actual = pos;
        while (2 * i_actual + 1 < cardinal) {
            int hijo_izq = 2 * i_actual + 1;
            int hijo_der = 2 * i_actual + 2;
    
            int hijoMax = hijo_izq;
    
            if (hijo_der < cardinal && lista[hijo_der].compareTo(lista[hijo_izq]) > 0) {
                hijoMax = hijo_der;
            }
    
            if (lista[i_actual].compareTo(lista[hijoMax]) >= 0) {
                break;
            }
    
            T temporal = lista[i_actual];
            lista[i_actual] = lista[hijoMax];
            lista[hijoMax] = temporal;
            intercambia_handle(i_actual, hijoMax);
            i_actual = hijoMax;
        }
    }
    // Dado un indice, sube el elemento si es que es posible
    private void subir (int pos) {

        int i_actual = pos;
        while (i_actual > 0) {
            int padre = (i_actual - 1) / 2;

            if (lista[padre].compareTo(lista[i_actual]) < 0) {
                // Intercambiamos
                T temporal = lista[padre];  //guardo el elemto de padre
                lista[padre] = lista[i_actual];  // actualizo padre con el actual
                lista[i_actual] = temporal;  // pongo el padre abajo
                intercambia_handle(padre, i_actual);
                i_actual = padre; // actualizo el iterador
                
            } else {
                break;
            }
        }
    }
    // Si dos elementos tienen handle de heap los intercambia
    private void intercambia_handle (int p, int j) {
        T elemP = lista[p];
        T elemJ = lista[j];
        if(elemP instanceof HandleSupport && elemJ instanceof HandleSupport ){
            Object handleP = ((HandleSupport) elemP).getHandle();
            Object handleJ = ((HandleSupport) elemJ).getHandle();
            if(handleP instanceof Heap.HeapHandle && handleJ instanceof Heap.HeapHandle){
                ((HeapHandle)((HandleSupport) elemP).getHandle()).pos = p;
                ((HeapHandle)((HandleSupport) elemJ).getHandle()).pos = j;
            }
            
    }
}
    // ordena la lista
    private void heapify() {
    for(int i = lista.length/2 - 1 ; i >= 0; i--) {  // desde el ultimo nodo No hoja 
        bajar(i);      
        }
        
        }

    //Devuelve el cardinal
    public int cardinal(){
        return cardinal;
    }

    // Veo el valor del maximo
    public T verMaximo(){
        if(cardinal== 0) return null;
        return lista[0]; 
    }
    

    //Saco el Nodo maximo
    public void sacarPrimero(){
        if (cardinal == 0) 
        return;
        T ultimo = lista[--cardinal];
        if (cardinal == 0) {
            // Heap vacío tras sacar el último elemento
            lista = (T[]) new Comparable[0];
            return;
        }
        lista[0] = ultimo;
        bajar(0);
    }
}