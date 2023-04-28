
package juegowordle.canvas;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import juegowordle.Letra;
import juegowordle.interfaces.ITablero;


public class TableroCanvas implements ITablero {
    
    ArrayList<Letra> letras = new ArrayList();
    
    public TableroCanvas(){
        for (int i = 0; i < 30; i++) {
           letras.add(new Letra());
        }
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 30));
    }

    @Override
    public void despliegaTablero() {
        int x = 0, y = 0;
        for (int i = 1; i < 31; i++) {
            switch(letras.get(i-1).getEstado()){
                case 0 -> Canvas.canva.setForegroundColor(Color.decode("#dee1dd"));
                case 1 -> Canvas.canva.setForegroundColor(Color.GRAY);
                case 2 -> Canvas.canva.setForegroundColor(Color.ORANGE);
                case 3 -> Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
            }
            Canvas.canva.fillRectangle(60 * x + 355, 60 * y + 100, 50, 50);
            Canvas.canva.setForegroundColor(Color.WHITE);
            Canvas.canva.drawString(letras.get(i-1).getLetra(), 60 * x + 370, 60 * y + 135);
            if(i % 5 == 0){
                y = y + 1;
                x = 0;
            }else{
                x = x + 1;
            }
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
    }
    
    @Override
    public void mostrarResultado(String palabra, boolean gano){
        Canvas.canva.erase();
        despliegaTablero();
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 20));
        if( gano == true){
            Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
            Canvas.canva.drawString("GANASTE!!", 450, 480);
        }else{
            Canvas.canva.setForegroundColor(Color.decode("#CA0E0E"));
            Canvas.canva.drawString("Fallaste :c", 450, 480);
            Canvas.canva.drawString("Palabra correcta: " + palabra, 320, 510);
        }
    }
    
    public void mostrarInstrucciones(){
    
    }

}