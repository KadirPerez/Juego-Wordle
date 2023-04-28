
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
    }

    @Override
    public void despliegaTablero() {
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 20));
        Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
        Canvas.canva.drawString("WORDLE",15,25);
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 30));
        int x = 0, y = 0;
        for (int i = 1; i < 31; i++) {
            switch(letras.get(i-1).getEstado()){
                case 0 -> Canvas.canva.setForegroundColor(Color.decode("#dee1dd"));
                case 1 -> Canvas.canva.setForegroundColor(Color.GRAY);
                case 2 -> Canvas.canva.setForegroundColor(Color.ORANGE);
                case 3 -> Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
            }
            Canvas.canva.fillRectangle(60 * x + 205, 60 * y + 75, 50, 50);
            Canvas.canva.setForegroundColor(Color.WHITE);
            Canvas.canva.drawString(letras.get(i-1).getLetra(), 60 * x + 220, 60 * y + 110);
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
        Canvas.canva.erase();
    }
    
    @Override
    public void mostrarResultado(String palabra, boolean gano){
        Canvas.canva.erase();
        despliegaTablero();
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 25));
        if( gano == true){
            Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
            Canvas.canva.drawString("GANASTE!!", 275, 520);
        }else{
            Canvas.canva.setForegroundColor(Color.decode("#CA0E0E"));
            Canvas.canva.drawString("Fallaste :c", 280, 500);
            Canvas.canva.drawString("Palabra correcta: " + palabra, 182, 550);
        }
    }
    
    public void mostrarInstrucciones(){
        Canvas.canva.setForegroundColor(Color.decode("#dde6ec"));
        Canvas.canva.fillRectangle(80, 20, 540, 50);
        Canvas.canva.fillRectangle(115, 320, 460, 190);
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 25));
        Canvas.canva.setForegroundColor(Color.BLACK);
        Canvas.canva.drawString("Cómo jugar", 260, 55);
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 14));
        Canvas.canva.drawString("Tienes que adivinar la palabra oculta en 6 "
                + "intentos y el color de las letras cambia", 25, 125);
        Canvas.canva.drawString("para mostrar lo cerca que estás.", 215, 155);
        Canvas.canva.drawString(" Para comenzar el juego, simplemente ingrese "
                + "cualquier palabra, por ejemplo: ", 35, 185);
        
   
        Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
        Canvas.canva.fillRectangle(205, 235, 50, 50);
        
        Canvas.canva.setForegroundColor(Color.GRAY);
        Canvas.canva.fillRectangle(265, 235, 50, 50);
        
        Canvas.canva.setForegroundColor(Color.ORANGE);
        Canvas.canva.fillRectangle(325, 235, 50, 50);
        
        Canvas.canva.setForegroundColor(Color.GRAY);
        Canvas.canva.fillRectangle(385, 235, 50, 50);
        
        Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
        Canvas.canva.fillRectangle(445, 235, 50, 50);
        
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 30));
        Canvas.canva.setForegroundColor(Color.WHITE);
        Canvas.canva.drawString("M", 215, 270);
        Canvas.canva.drawString("E", 278, 270);
        Canvas.canva.drawString("D", 338, 270);
        Canvas.canva.drawString("I", 405, 270);
        Canvas.canva.drawString("O", 458, 270);
        
        
        
        Canvas.canva.setForegroundColor(Color.BLACK);
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 14));
        Canvas.canva.drawString("no está en la palabra objetivo en absoluto.", 190, 360);
        Canvas.canva.drawString("está en la palabra pero en el lugar equivocado.", 190, 415);
        Canvas.canva.drawString("está en la palabra y en el lugar correcto.", 190, 470);
        
        Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
        Canvas.canva.fillRectangle(129, 455, 20, 20);
        
        Canvas.canva.setForegroundColor(Color.GRAY);
        Canvas.canva.fillRectangle(129, 345, 20, 20);
        
        Canvas.canva.setForegroundColor(Color.ORANGE);
        Canvas.canva.fillRectangle(129, 400, 20, 20);
        
        Canvas.canva.setForegroundColor(Color.GRAY);
        Canvas.canva.fillRectangle(159, 345, 20, 20);
        
        Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
        Canvas.canva.fillRectangle(159, 455, 20, 20);
    
        Canvas.canva.setForegroundColor(Color.WHITE);
        Canvas.canva.setFont(new Font("a", Font.CENTER_BASELINE, 14));
        Canvas.canva.drawString("M", 133, 467);
        Canvas.canva.drawString("E", 133, 357);
        Canvas.canva.drawString("D", 133, 415);
        Canvas.canva.drawString("I", 165, 357);
        Canvas.canva.drawString("O", 163, 467);
    }

}