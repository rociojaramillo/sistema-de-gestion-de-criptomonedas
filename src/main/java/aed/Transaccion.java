package aed;

public class Transaccion implements Comparable<Transaccion>,HandleSupport{
    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;
    Object _handle;


    public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {
        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
    }

    @Override
    public Object getHandle() {return _handle;}
    @Override
    public void setHandle(Object handle) {_handle = handle;}


    @Override
    public int compareTo(Transaccion otro) {
        if (this.monto != otro.monto()){
            return this.monto - otro.monto();
        }else{
            return this.id - otro.id();
        }
    }

    @Override
    public String toString() {
        return "Transaccion{id=" + id + ", id comprador" + id_comprador + ", id vendedor" + id_vendedor + ", monto=" + monto + "}";
    }

    @Override
    public boolean equals(Object otro){
        boolean otroEsnull = otro == null;
        boolean otroOtraClase = otro.getClass() != this.getClass();
        if (otroEsnull || otroOtraClase){
            return false;
        }
        else{
            Transaccion otroOtro =(Transaccion) otro;
            return this.id == otroOtro.id && this.id_comprador == otroOtro.id_comprador && this.id_vendedor == otroOtro.id_vendedor && this.monto == otroOtro.monto;     
        }
    }

    
    public void setMonto(int montoNuevo){
        monto = montoNuevo;
    }

    public int id() {
        return id;
    }
    
    public int monto() {
        return monto;
    }

    public int id_comprador() {
        return id_comprador;
    }
    
    public int id_vendedor() {
        return id_vendedor;
    }
}