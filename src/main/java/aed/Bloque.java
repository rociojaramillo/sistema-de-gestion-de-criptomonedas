package aed;


public class Bloque {
    private int cardinal;
    private int sumaDeTransaccion;
    private ListaEnlazada<Transaccion> listaEn;
    private Heap<Transaccion> listaHeap;


    //Se crea un bloque vacio
    public Bloque(Transaccion[] t) {
        listaHeap = new Heap<Transaccion>(t);
        for(int i = 0; i < t.length; i++){
            if(t[i].id_comprador() != 0){ //si no es Transaccion de creacion
                cardinal ++;           // se suma al cardinal
                sumaDeTransaccion = sumaDeTransaccion + t[i].monto(); // Y se suma su monto a la suma de montos
            }
        }
        listaEn = new ListaEnlazada<Transaccion>(t);
    }

    //se saca el promedio de todas las transaccion, sin contar las de creacion
    public int promedioTransacciones() {
    if (cardinal == 0) return 0; // evita división por cero
    return sumaDeTransaccion / cardinal;
}

    //ver la Transaccion del Nodo maximo en el heap
    public Transaccion maximo(){
        return listaHeap.verMaximo();
    }

//Saco la Transaccion del Nodo maximo tanto del heap como de la lista enlazada
    public void sacarMaximo(){
    if(listaHeap.cardinal() == 1){ //Si en el heap hay un solo elemento, se queda el bloque vacio
        cardinal = 0;
        sumaDeTransaccion = 0;
        Transaccion[] vacio = new Transaccion[0];
        listaEn = new ListaEnlazada<Transaccion>(vacio);
        listaHeap = new Heap<Transaccion>(vacio);
    }else{ 
        cardinal --; //se resta al cardinal
        Transaccion maximo = listaHeap.verMaximo(); //veo cual es el maximo del heap
        sumaDeTransaccion = sumaDeTransaccion - maximo.monto(); //actualizo la suma de transacciones
        listaHeap.sacarPrimero(); //saco el maximo del heap
        listaEn.eliminarNodo(maximo);} // saco el Nodo al cual apunta en la lista enlazada
    }

    //a partir de las Transacciones que tengo en la lista enlazada, hago una lista
    public Transaccion[] convertirALista(){
        Object[] temp = listaEn.hacerLista();
        Transaccion[] res = new Transaccion[temp.length];
        for(int i = 0; i < temp.length; i++){
            res[i] = (Transaccion) temp[i];
        }
        return res;
    }

}
