/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juegowordle;

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
public class PalabraObjetivoIT {
    
    public PalabraObjetivoIT() {
    }
    
   
    @Test
    public void testEscogerPalabra() {
        System.out.println("escogerPalabra");
        PalabraObjetivo instance = new PalabraObjetivo();
        instance.escogerPalabra();
        System.out.println(instance.getPalabra());
        assertNotEquals(instance.getPalabra(), null);
    }
    
}
