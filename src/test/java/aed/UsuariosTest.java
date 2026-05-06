package aed;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class UsuariosTest {
    
    @Test 
    void agregarUno(){
        Usuarios nuevo = new Usuarios(1);
        Usuario u = new Usuario(1, 100);
        nuevo.actualizarMonto(1, 100);
        System.out.println("Agregar uno");
        System.out.println(u + "==" + nuevo.maximoTenedor());


    }

    @Test 
    void agregarVarios(){
        System.out.println("agregar Varios");
        Usuarios nuevo = new Usuarios(4);
        
        System.out.println("Todos deben ser 0 al empezar, " + nuevo.maximoTenedor());

        nuevo.actualizarMonto(4, 60);
        System.out.println("El 4 debe ser el maximo ," + nuevo.maximoTenedor());
        nuevo.actualizarMonto(2, 140);
        System.out.println("El 2 debe ser el maximo ," + nuevo.maximoTenedor());
        nuevo.actualizarMonto(3, 10);
        System.out.println("El 2 debe ser el maximo ," + nuevo.maximoTenedor());
        nuevo.actualizarMonto(1, 200);
        System.out.println("El 1 debe ser el maximo ," + nuevo.maximoTenedor());
        nuevo.actualizarMonto(1, -120);
        System.out.println("El 2 debe ser el maximo ," + nuevo.maximoTenedor());

    }


     @Test
    void actualizarMontoUno(){
        Usuarios nuevo = new Usuarios(2);
       
        nuevo.actualizarMonto(1, 50);

        assertEquals(1, nuevo.maximoTenedor());

    }

    @Test
    void actualizarMontoDos(){
        Usuarios nuevo = new Usuarios(2);
        
        nuevo.actualizarMonto(1, 50);
        nuevo.actualizarMonto(2, 60);
         assertEquals(2, nuevo.maximoTenedor());

        nuevo.actualizarMonto(2, -60);
        assertEquals(1, nuevo.maximoTenedor());

    }

    @Test 
    void maximoTenedor(){
    Usuarios nuevo = new Usuarios(3);

        nuevo.actualizarMonto(1, 20);
        nuevo.actualizarMonto(2, 60);
        nuevo.actualizarMonto(3, 40);

    System.out.println("Estado inicial:");
    System.out.println("El maximo tenedor debe ser 2 y es " + nuevo.maximoTenedor());


    nuevo.actualizarMonto(1, 100);
    nuevo.actualizarMonto(3, -10);
    nuevo.actualizarMonto(1, -100);
    nuevo.actualizarMonto(2, 100);
    nuevo.actualizarMonto(2, -160);

    // Después de actualizaciones
    System.out.println("Estado final:");

    
    System.out.println("Máximo tenedor esperado: 3");
    System.out.println("Máximo tenedor real: " + nuevo.maximoTenedor());

    assertEquals(3, nuevo.maximoTenedor());
}


}