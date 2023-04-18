/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juegowordle.consola;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kadir
 */
public class TecladoConsolaIT {
    
    public TecladoConsolaIT() {
    }
    @Test
    public void testTeclado() {
        System.out.println("agregarIntento");
        String intento = "ABABA";
        String palabra = "GARZA";
        TecladoConsola instance = new TecladoConsola();
        instance.agregarIntento(intento, palabra);
        instance.despliegaTeclado();
        System.out.println("\n\n");
    }
    
}
