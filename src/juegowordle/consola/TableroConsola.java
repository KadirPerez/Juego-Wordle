
package juegowordle.consola;


import java.util.ArrayList;
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
        System.out.print("     ");
        for (int i = 1; i < 31; i++) {
            System.out.print(letras.get(i-1));
            if(i % 5 == 0) System.out.print("\n\n     ");
        }
    }
    
    @Override
    public void agregarIntento(String intento, String palabra){
        ArrayList<String> intentoSeparado = new ArrayList();
        ArrayList<String> palabraSeparada = new ArrayList();
        ArrayList<Integer> posiciones = new ArrayList();
        Letra aux;
        
        String[] aIntentoSeparado = intento.split("");
        String[] aPalabraSeparada = palabra.split("");
        
        for (int i = 0; i < 5; i++) {
            intentoSeparado.add(aIntentoSeparado[i]);
            palabraSeparada.add(aPalabraSeparada[i]);
        }
        
        for(int i = 0; i < 5; i++) {
            aux = letras.get(i);
            aux.setLetra(1,intentoSeparado.get(i));
            if(palabraSeparada.contains(intentoSeparado.get(i)) == true){
                posiciones.add(i);
                aux = letras.get(i);
                aux.setLetra(2,intentoSeparado.get(i));
            }
        }
        
        for(int i = 0; i < posiciones.size(); i++) {
            if(palabraSeparada.get(posiciones.get(i)).equals(intentoSeparado.get(posiciones.get(i)))){
                aux = letras.get(i);
                aux.setLetra(3,intentoSeparado.get(i));
            }
        }
        
        
    }
   
}
