
package juegowordle.consola;


import java.util.ArrayList;
import java.util.Collections;
import juegowordle.Letra;
import juegowordle.interfaces.ITablero;


public class TableroConsola implements ITablero {
    
    ArrayList<Letra> letras = new ArrayList();
    
    
    public TableroConsola(){
        for (int i = 0; i < 30; i++) {
           letras.add(new Letra());
        }
    }

    @Override
    public void despliegaTablero() {
        System.out.print("               ");
        for (int i = 1; i < 31; i++) {
            System.out.print(letras.get(i-1));
            if(i % 5 == 0) System.out.print("\n\n               ");
        }
    }
    
    @Override
    public void agregarIntento(String intento, String palabra,int ni){
        
        ArrayList<String> intentoSeparado = new ArrayList<>();
        Collections.addAll(intentoSeparado, intento.split(""));
        
        ArrayList<String> palabraSeparada = new ArrayList<>();
        Collections.addAll(palabraSeparada, palabra.split(""));
        
        ArrayList<String> copiaPalabra  = new ArrayList<>();

        copiaPalabra.addAll(palabraSeparada);
       
        for (int i = 0; i < 5; i++) {
            letras.get(i + (ni * 5)).setLetra(1, intentoSeparado.get(i));
            if(intentoSeparado.get(i).equals(palabraSeparada.get(i))){
                letras.get(i + (ni * 5)).setEstado(3);
                copiaPalabra.remove(intentoSeparado.get(i));
            }else if(copiaPalabra.contains(intentoSeparado.get(i))){
                letras.get(i + (ni * 5)).setEstado(2);
                copiaPalabra.remove(intentoSeparado.get(i));
            }
        }
        
         
    }
   
    @Override
    public void limpiarPantalla(){
        for (int i = 0; i < 10; i++) {
            System.out.println("\n\n\n\n");
        }
    }
    
    @Override
    public void mostrarResultado(String palabra, boolean gano){
        if( gano == true){
            System.out.print("\nGanaste!!");
        }else{
            System.out.print("\n\nFallaste :c\n\nPalabra correcta: " 
                    + palabra);
        }
    }
    
    @Override
    public void mostrarInstrucciones(){
        System.out.println("<> La letra no se encuentra en la palabra");
        System.out.println("{} La letra se encuentra en la palabra pero no esta en posicion");
        System.out.println("() La letra se encuentra en la palabra y en su posicion\n\n");
    }

}
