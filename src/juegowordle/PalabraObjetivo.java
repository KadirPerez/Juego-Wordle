/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegowordle;
import java.io.*;
import java.util.Random;

public class PalabraObjetivo {
    
    private String palabraObjetivo;
    
    public PalabraObjetivo(){
        palabraObjetivo = null;
    }
    
    public String escogerPalabra(){
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String linea = null;
        Random rdm = new Random();

        try {
            archivo = new File ("src/juegowordle/PalabrasDe5Letras.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            int posicion = rdm.nextInt(10856);
            
            linea=br.readLine();
            for (int i = 0; i < posicion; i++) {
                linea =br.readLine();
            }
       
        }
          catch(IOException e){
          }finally{
             try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
             }catch (IOException e2){ 
        }
    }
        return linea;
    
}
    
    
}
