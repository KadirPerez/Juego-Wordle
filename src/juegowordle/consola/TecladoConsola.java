
package juegowordle.consola;

import java.util.ArrayList;
import juegowordle.interfaces.ITeclado;


public class TecladoConsola implements ITeclado{
    
    ArrayList letrasTeclado;
    
    @Override
    public void despliegaTeclado() {
        System.out.println("\n Q    W    E    R    T    Y    U    I    O    P ");
        System.out.println("\n A    S    D    F    G    H    J    K    L    Ñ ");
        System.out.println("\n        Z    X    C    V    B    N    M ");
    }
}
