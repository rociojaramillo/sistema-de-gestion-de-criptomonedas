package aed;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class BloqueTests{
@Test
public void agregarBloques(){
    
    //test con DOS RAICES IGUALES
    Transaccion[] transacciones = {
        new Transaccion(1, 7, 3, 45),
        new Transaccion(5, 0, 1, 45),
        new Transaccion(0, 0, 6, 1),
    };
    Bloque bloque = new Bloque(transacciones);
    assertEquals(transacciones[1], bloque.maximo());
    
    //test con raices distintas
    Transaccion[] transacciones2 ={
        new Transaccion(12, 5, 3, 4),
        new Transaccion(6, 10, 3, 77),
        new Transaccion(7, 0, 3, 1),
    };
    
    bloque = new Bloque(transacciones2);
    assertEquals(transacciones2[1], bloque.maximo());
}
@Test
public void quieroMaximo(){
//no especifico adentro el tipo porque no es de tipo T
    Transaccion[] transacciones = {
    new Transaccion(1, 0, 3, 45),
    new Transaccion(5, 0, 3, 45),
    new Transaccion(0, 0, 3, 1),
    };
    Bloque bloque = new Bloque(transacciones); 

    assertEquals(transacciones[1], bloque.maximo());
    bloque.sacarMaximo();
    assertEquals(transacciones[0], bloque.maximo());
    //el maximo lo agrego a lo ultimo
    Transaccion[] transacciones1 = {
    new Transaccion(12, 5, 3, 4),
    new Transaccion(6, 10, 3, 7),
    new Transaccion(7, 0, 3, 77),
    };
    
    bloque = new Bloque(transacciones1);

    assertEquals(transacciones1[2], bloque.maximo());
    bloque.sacarMaximo();
    assertEquals(transacciones1[1], bloque.maximo());

}
 @Test   
 public void promedioMonto(){ //CUANDO ES DE CREACION(ID = 0) NO SUMA LOS MONTOS
      //no especifico adentro el tipo porque no es de tipo T
    Transaccion[] transacciones = {
     new Transaccion(1, 10, 3, 10),
      new Transaccion(5, 110, 3, 10),
      new Transaccion(0, 20, 3, 4),
     };

     Bloque bloque = new Bloque(transacciones);
     assertEquals(8, bloque.promedioTransacciones());
     bloque.sacarMaximo();
     assertEquals(7, bloque.promedioTransacciones());
     bloque.sacarMaximo();
     bloque.sacarMaximo();
     assertEquals(0, bloque.promedioTransacciones());
     }
    
@Test
public void sacarMaximoDeBloque(){
    Transaccion[] transacciones = {
     new Transaccion(1, 100, 5, 45),
      new Transaccion(5, 300, 5, 45),
      new Transaccion(7, 200, 5, 45),
     };

     Bloque bloque = new Bloque(transacciones);

    // Primero el maximo es la transaccion 3 
    assertEquals(transacciones[2], bloque.maximo());

    // Sacamos el maximo
    bloque.sacarMaximo();

    // Después el maximo debería ser transaccion 2
    assertEquals(transacciones[1], bloque.maximo());

    // Sacamos nuevamente el maximo
    bloque.sacarMaximo();

    // Después el maximo debería ser transaccion 1 
    assertEquals(transacciones[0], bloque.maximo());

    // Sacamos el último
    bloque.sacarMaximo();

    // La estructura ahora debería quedar sin elementos
    assertEquals(0, bloque.promedioTransacciones()); // 0
}
} 