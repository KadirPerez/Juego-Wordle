package juegowordle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kadir
 */
public class LetraIT {
    
    public LetraIT() {
    }
    @Test
    public void testSetLetraAndToString() {
        System.out.println("setLetra");
        Letra instance = new Letra();
        instance.setLetra(2, "A");
        assertEquals("{ A }  " , instance.toString());
    }
    @Test
    public void testSetAndGetContenido() {
        System.out.println("setContenido");
        Letra instance = new Letra(2,"A");
        instance.setContenido("K");
        assertEquals(instance.getLetra() ,"K");
    }
    @Test
    public void testSetAndGetEstado() {
        System.out.println("setEstado");
        Letra instance = new Letra(2,"A");
        instance.setEstado(1);
        assertEquals(instance.getEstado() , 1);
    }

   
}