
package juegowordle;

import juegowordle.consola.TableroConsola;
import juegowordle.consola.TecladoConsola;
import juegowordle.interfaces.ITablero;
import juegowordle.interfaces.ITeclado;


public class Wordle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ITeclado teclado = new TecladoConsola();
        ITablero tablero = new TableroConsola();
        JuegoWordle juego = new JuegoWordle(tablero, teclado);
        
        juego.jugar();
    }
    
}
