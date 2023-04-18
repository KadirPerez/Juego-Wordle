/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juegowordle;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalabraObjetivoIT {
    
    public PalabraObjetivoIT() {
    }
    @Test
    public void testEscogerAndGetPalabra() {
        System.out.println("escogerPalabra");
        PalabraObjetivo instance = new PalabraObjetivo();
        instance.escogerPalabra();
        String resultado = instance.getPalabra();
        assertEquals(resultado.length(), 5);
    }
    @Test
    public void testBuscarPalabra() {
        System.out.println("buscarPalabra");
        PalabraObjetivo instance = new PalabraObjetivo();
        boolean result = instance.buscarPalabra("ABABA");
        assertEquals(result, true);
    }
    @Test
    public void testComprobarIntentoAndSetPalabra() {
        System.out.println("comprobarIntento");
        String intento = "ABABA";
        PalabraObjetivo instance = new PalabraObjetivo();
        boolean expResult = true;
        instance.setPalabra("ABABA");
        boolean result = instance.comprobarIntento(intento);
        assertEquals(expResult, result);
    }
    
}
