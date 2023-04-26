
package juegowordle.consola;

import java.util.ArrayList;
import juegowordle.Letra;
import juegowordle.interfaces.ITeclado;


public class TecladoConsola implements ITeclado{
    
    ArrayList<Letra> letras = new ArrayList();
    
    public TecladoConsola(){
        letras.add(new Letra(0,"Q")); 
        letras.add(new Letra(0,"W"));
        letras.add(new Letra(0,"E"));
        letras.add(new Letra(0,"R"));
        letras.add(new Letra(0,"T"));
        letras.add(new Letra(0,"Y"));
        letras.add(new Letra(0,"U"));
        letras.add(new Letra(0,"I"));
        letras.add(new Letra(0,"O"));
        letras.add(new Letra(0,"P"));
        letras.add(new Letra(0,"A"));
        letras.add(new Letra(0,"S"));
        letras.add(new Letra(0,"D"));
        letras.add(new Letra(0,"F"));
        letras.add(new Letra(0,"G"));
        letras.add(new Letra(0,"H"));
        letras.add(new Letra(0,"J"));
        letras.add(new Letra(0,"K"));
        letras.add(new Letra(0,"L"));
        letras.add(new Letra(0,"Ñ"));
        letras.add(new Letra(0,"Z"));
        letras.add(new Letra(0,"X"));
        letras.add(new Letra(0,"C"));
        letras.add(new Letra(0,"V"));
        letras.add(new Letra(0,"B"));
        letras.add(new Letra(0,"N"));
        letras.add(new Letra(0,"M"));
        
    }
    
    @Override
    public void despliegaTeclado() {
        System.out.println("");
        for (int i = 1; i < 21; i++) {
            System.out.print(letras.get(i-1));
            if(i % 10 == 0) System.out.print("\n\n");
        }
        System.out.print("         ");
        for (int i = 21; i < 28; i++) {
            System.out.print(letras.get(i-1));
        }
        System.out.print("\n");
    }
    
    @Override
    public void agregarIntento(String intento, String palabra){
        int j;
        String[] intentoSeparado = intento.split("");
        String[] palabraSeparada = palabra.split("");
        
        for (int i = 0; i < 5; i++) {
            j = 0;
            while(letras.get(j).getLetra().equals(intentoSeparado[i]) == false){
                j = j + 1;
            }
            
            if(letras.get(j).getEstado() == 0) letras.get(j).setEstado(1);
            
            if(palabra.contains(intentoSeparado[i]) && letras.get(j).getEstado() < 3){
                letras.get(j).setEstado(2);
                if(intentoSeparado[i].equals(palabraSeparada[i])){
                    letras.get(j).setEstado(3);
                }
            }
        } 
        
    }
}
