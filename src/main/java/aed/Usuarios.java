package aed;

public class Usuarios {
    private Heap<Usuario> heap;
    private Usuario[] listaUsuarios;

    // Crea n usuarios en O(n)
    public Usuarios(int n) {   // creo usuarios
        listaUsuarios = new Usuario[n];
        for (int i = 0; i < n; i++) {
            listaUsuarios[i] = new Usuario(i+1, 0);            
        }
        heap = new Heap<Usuario>(listaUsuarios);
    }

    public void actualizarMonto (int id, int monto) {
        Usuario u = listaUsuarios[id-1];
        u.setMonto(u.getMonto()+monto);
        heap.modificarPos(u);
    }

    public int maximoTenedor() {
        return heap.verMaximo().id();
    }


}