
package juegowordle.canvas;

import java.awt.Color;
import java.util.ArrayList;
import juegowordle.Letra;
import juegowordle.interfaces.ITeclado;

    public class TecladoCanvas implements ITeclado{
    ArrayList<Letra> letras = new ArrayList();

        public TecladoCanvas(){
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
            
            int x = 0, y = 0;
            for (int i = 1; i < 28; i++) {
                switch(letras.get(i-1).getEstado()){
                case 0:
                    Canvas.canva.setForegroundColor(Color.decode("#dee1dd"));
                    if(i < 21){
                        Canvas.canva.fillRectangle(60 * x + 205, 60 * y + 500 , 50, 50);
                        Canvas.canva.setForegroundColor(Color.DARK_GRAY);
                        Canvas.canva.drawString(letras.get(i-1).getLetra(), 60*x+220, 60*y+535 );
                    }
                    else{
                        Canvas.canva.fillRectangle(60 * x + 295, 60 * y + 500 , 50, 50);
                        Canvas.canva.setForegroundColor(Color.DARK_GRAY);
                        Canvas.canva.drawString(letras.get(i-1).getLetra(), 60*x+310, 60*y+535 );
                    }
                       
                    break;
                case 1:
                    Canvas.canva.setForegroundColor(Color.GRAY);
                    break;
                case 2:
                    Canvas.canva.setForegroundColor(Color.ORANGE);
                    break;
                case 3:
                    Canvas.canva.setForegroundColor(Color.decode("#5ba946"));
                    break;
                }
                
                if(i < 21 && letras.get(i-1).getEstado() != 0){
                    Canvas.canva.fillRectangle(60 * x + 205, 60 * y + 500 , 50, 50);
                    Canvas.canva.setForegroundColor(Color.WHITE);
                    Canvas.canva.drawString(letras.get(i-1).getLetra(), 60*x+220, 60*y+535 );
                }
                else if (letras.get(i-1).getEstado() != 0){
                    Canvas.canva.fillRectangle(60 * x + 295, 60 * y + 500 , 50, 50);
                    Canvas.canva.setForegroundColor(Color.WHITE);
                    Canvas.canva.drawString(letras.get(i-1).getLetra(), 60*x+310, 60*y+535 );
                }
                
                if(i % 10 == 0){
                    y = y + 1;
                    x = 0;
                }else{
                    x = x + 1;
                }
            }
            
          
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
