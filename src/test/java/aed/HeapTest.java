package aed;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


public class HeapTest {

    @Test
    void nuevoHeap(){
    Integer[] datos = {4, 7, 1, 3};
    Heap<Integer> h = new Heap<>(datos);

     assertEquals(4, h.cardinal());
     }

    @Test
    void agregarUsuario(){
        Usuario u0 = new Usuario(5,10);
        Usuario u1 = new Usuario(2,10);
        Usuario u2 = new Usuario(3,5);
        Usuario[] usuarios = new Usuario[3];
        usuarios[0] = u0;
        usuarios[1] = u1;
        usuarios[2] = u2;
        Heap<Usuario> nuevo = new Heap<>(usuarios);
        
        assertEquals(usuarios[1], nuevo.verMaximo());
    }



    @Test
    void agregarTransaccion(){
         Transaccion[] elementos = {
            new Transaccion(01, 2, 3, 10),
            new Transaccion(02, 4, 3, 15),
            new Transaccion(03, 5, 6, 15),
            new Transaccion(04, 9, 5, 5),
        };
        Heap<Transaccion> nuevo = new Heap<>(elementos);

        assertEquals(elementos[2], nuevo.verMaximo());
        }

    @Test
    void eliminarRaiz(){
         Transaccion[] elementos = {
            new Transaccion(01, 2, 3, 10),
            new Transaccion(02, 4, 3, 15),
            new Transaccion(03, 5, 6, 15),
            new Transaccion(04, 9, 5, 5),
        };
        Heap<Transaccion> nuevo = new Heap<>(elementos);

        nuevo.sacarPrimero();
        assertEquals(elementos[1], nuevo.verMaximo());

        nuevo.sacarPrimero();
        assertEquals(elementos[0], nuevo.verMaximo());
    } 
    
 }
 
