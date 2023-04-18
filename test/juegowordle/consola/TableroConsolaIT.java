/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juegowordle.consola;

import org.junit.Test;

public class TableroConsolaIT {
    
    public TableroConsolaIT() {
    }
    @Test
    public void testTablero() {
        System.out.println("tablero");
        String intento = "ABABA";
        String palabra = "GARZA";
        int ni = 0;
        TableroConsola instance = new TableroConsola();
        instance.agregarIntento(intento, palabra, ni);
        instance.despliegaTablero();
        System.out.println("\n\n");
    }
    
}
