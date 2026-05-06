package aed;

public class Berretacoin {
    private Usuarios usuarios;
    private Bloque bloque;


    /* Complejidad requerida : O(P)
    como usuarios hace un heapify con el arreglo completo es O(P).*/
    public Berretacoin(int n_usuarios){
        usuarios = new Usuarios(n_usuarios);
        
    }
    
    /* Complejidad requerida : O(nb * log P)
    crear un nuevo bloque hace un heapify con el arreglo completo es  O(nb)
    usuarios.actualizarMonto() actualiza la posicion en el heap de usuarios es O(log P)
    Complejidad: O(nb * log P)*/
    public void agregarBloque(Transaccion[] transacciones){
        Bloque ultimo = new Bloque(transacciones);
        for (int i = 0; i < transacciones.length; i++){
            Transaccion nuevo = transacciones [i];
            if (nuevo.id_comprador() != 0)
            {usuarios.actualizarMonto(nuevo.id_comprador(), -nuevo.monto()); }

            usuarios.actualizarMonto(nuevo.id_vendedor(), nuevo.monto());
            }
        bloque = ultimo;
    }

   // Complejidad requerida : O(1)
    // llama a Bloque.maximo() que devuelve el primer elemento del heap, esto es O(1)
    public Transaccion txMayorValorUltimoBloque(){
        return bloque.maximo();
    }

    // Complejidad requerida : O(nb)
    // llama a bloque.convertirALista() que recorre la lista enlazada una vez, esto es O(nb)
    public Transaccion[] txUltimoBloque(){
        return bloque.convertirALista();
    }

    // Complejidad requerida : O(1)
    //llama a el primer elemento del heap de usuarios, tienen acceso directo ya que es la raiz, esto es O(1)
    public int maximoTenedor(){
        return usuarios.maximoTenedor();
    }

    // Complejidad requerida : O(1)
    // bloque mantiene suma y cantidad de transacciones acumuladas, esto es O(1)
    public int montoMedioUltimoBloque(){
        return bloque.promedioTransacciones();
    }

    /* Complejidad requerida : O(log nb + log P)
    llama a bloque.maximo(), esto es O(1)
    usuarios.actualizarMonto() reorganiza el heap de usuarios esto es O(log P)
    bloque.sacarMaximo() reorganiza el heap de transacciones, esto es O(log n)
    complejidad : O(log n + log P)
    */ 
    public void hackearTx(){
        Transaccion maximo = bloque.maximo();
     
        int idVendedorHakeado = maximo.id_vendedor();
        int idCompradorHakeado = maximo.id_comprador();
        int montoHackeado = maximo.monto();
        
        usuarios.actualizarMonto(idVendedorHakeado, -montoHackeado);
        
        if(idCompradorHakeado != 0) { 
        usuarios.actualizarMonto(idCompradorHakeado, montoHackeado);
        }
        
        bloque.sacarMaximo();
    }

}
