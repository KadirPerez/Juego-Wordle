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
    
    public void escogerPalabra(){
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
        }
        finally{
            try{                    
                if( null != fr ) fr.close();                
            }
            catch (IOException e2){ 
            }
        }
        palabraObjetivo = linea;
    
    } 
    
    public String getPalabra(){return palabraObjetivo;}
    
    public boolean buscarPalabra(String palabra){
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String linea = null;
        boolean existe = false;
        
        try {
            archivo = new File ("src/juegowordle/PalabrasDe5Letras.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
            linea = br.readLine();
            while(linea != null){
                if(linea.equals(palabra)) {existe = true;}
                linea = br.readLine();
            }
       
        }
        catch(IOException e){
        }
        finally{
            try{                    
                if( null != fr ) fr.close();                
            }
            catch (IOException e2){ 
            }
        }
        
        return existe;
    }
    
    public boolean comprobarIntento(String intento){
        return palabraObjetivo.equals(intento);
    }
    
    public void setPalabra(String palabraObjetivo){
        this.palabraObjetivo = palabraObjetivo;
    }
}
