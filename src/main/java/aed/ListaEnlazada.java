package aed;

public class ListaEnlazada<T> {
    
    private Nodo primero;
    private Nodo ultimo;

    private class  Nodo {
        T valor;
        Nodo sig;
        Nodo ant;

        Nodo (T v) {valor = v;}
    }
    public class ListaHandle {
        Nodo nodo;
        ListaHandle(Nodo nodo) {
            this.nodo = nodo;
        }
    }

    public ListaEnlazada(T[] lista) {
        for(int i = 0; i < lista.length; i++){
            T elem = lista[i];
            agregarAtras(elem);
                    // Asignar el handle al objeto
            if (elem instanceof HandleSupport) {
                ((HandleSupport)elem).setHandle(new ListaHandle(ultimo));
            }
        }

    }

    public int longitud() { 
        if (primero == null){
            return 0;
        }
        Nodo actual = this.primero;
        Nodo sig = this.primero.sig;
        int i = 1;
        if (actual == ultimo){//solo un nodo
            return 1;
        }
        while (sig != ultimo){ //termina cuando mi siguiente es ultimo
            i = i +1;
            actual = sig;
            sig = sig.sig;
        }

        return i + 1; //sumo 1 a mi i, osea el nodo ultimo
    }

//Agrega un nuevo nodo con la transacción al final de la lista.
    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem); //creo nodo con valor 
        nuevo.ant = ultimo;
        nuevo.sig = null;

    if (ultimo == null) { //pregunto si ultimo es null que es lo mismo a preguntar si mi lista es null
        primero = nuevo;
    } else {
        ultimo.sig = nuevo;
    }
    ultimo = nuevo; //me aseguro que mi "puntero ultimo" apunte a nuevo

}

    public void eliminarNodo(T elem){
        Nodo n = null;
        if (elem instanceof HandleSupport) {  //si tiene handle, lo uso
            n = ((ListaHandle) ((HandleSupport) elem).getHandle()).nodo;

        }else{
            n = primero; 
            while(n != null && (n.valor == null ? elem != null : !n.valor.equals(elem))){ //si no tiene handle, busco en la lista
                n = n.sig;
            }
        }
    
        if (n == null) {
            n = primero;
            while (n != null && n.valor != elem) {
                n = n.sig;
            }
        }
            if (n == primero) {//si n es el primer nodo de la lista
                primero = n.sig; //primero va a ser el siguiente de n
                if (primero == null) {//me fijo si no tengo elementos en mi lista
                    ultimo = null;
                } else {
                    primero.ant = null;
                }
            } else if (n == ultimo) { //si n es el ultimo nodo de la lista
                ultimo = n.ant; //ultimo va a ser el anterior a n
                if (ultimo == null) {//me fijo si no tengo elementos en mi lista
                    primero = null;
                } else {
                    ultimo.sig = null;
                }
            } else { //nodo que quiero eliminar esta entre elementos
                n.ant.sig = n.sig;
                n.sig.ant = n.ant;
            }
            //me aseguro que el nodo eliminado no este relacionado/conectado con algun nodo de mi lista
            n.ant = null; 
            n.sig = null;
    }


    public Object[] hacerLista(){
    int n =     longitud();
    Object[] lista = new Object[n]; //creo una lista vacia de tamaño n, es decir del tamaño de la listaEnlazada
    Nodo actual = primero;

    for(int i = 0; i < n; i++) { //recorro cada nodo de la lista
        lista[i] = actual.valor; //copio cada valor del nodo de la listaEnlazada en la nueva lista segun posicion respectivamente
        actual = actual.sig;
    }

    return lista;
    }
}
