
package juegowordle;

import java.util.Scanner;
import juegowordle.interfaces.ITablero;
import juegowordle.interfaces.ITeclado;


public class JuegoWordle {
    ITablero tablero;
    ITeclado teclado;
    PalabraObjetivo palabra;

    public JuegoWordle(ITablero tablero, ITeclado teclado) {
        this.tablero = tablero;
        this.teclado = teclado;
        palabra = new PalabraObjetivo();
    }
    
    public void jugar() {
        Scanner leer = new Scanner(System.in);
        palabra.escogerPalabra();
        tablero.despliegaTablero();
        teclado.despliegaTeclado();
        System.out.println(palabra.getPalabra());
        System.out.print("\nDigita el intento: ");
        String intento = leer.nextLine();
        while(palabra.buscarPalabra(intento) != true){
            if(palabra.buscarPalabra(intento) != true) System.out.println("La palabra no esta en la lista, intente otra vez");
            System.out.print("\nDigita el intento: ");
            intento = leer.nextLine();
        }
        
        tablero.agregarIntento(intento,palabra.getPalabra());
        for (int i = 0; i < 50; i++) {
            System.err.println("");
        }
        tablero.despliegaTablero();
        teclado.despliegaTeclado();
    }    
    
}
