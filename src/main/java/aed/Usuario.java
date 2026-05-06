package aed;

public class Usuario implements Comparable<Usuario>,HandleSupport {
    private int id;
    private int monto;
    Object _handle;
   

    public Usuario(int id, int monto){
        this.id = id;
        this.monto = monto;
    }

    @Override
    public Object getHandle() {return _handle;}
    @Override
    public void setHandle(Object handle) {_handle = handle;}


    @Override
    public int compareTo(Usuario otro) {
        if (this.monto != otro.monto()){
            return monto - otro.monto();
        }else{
            return otro.id() - this.id;
        }
    }

    @Override
public String toString() {
    return "Usuario{id=" + id + ", monto=" + monto + "}";
}


    @Override
    public boolean equals(Object otro){
        boolean otroEsnull = otro == null;
        boolean otroOtraClase = otro.getClass() != this.getClass();
        if (otroEsnull || otroOtraClase){
            return false;
        }
        else{
            Usuario otroOtro =(Usuario) otro;
            return this.id == otroOtro.id && this.monto == otroOtro.monto;     
        }
    }

    
    public void setMonto(int montoNuevo){
        monto = montoNuevo;
    }

    public int getMonto(){
        return monto;
    }

    public int id() {
        return id;
    }
    
    public int monto() {
        return monto;
    } 
}
