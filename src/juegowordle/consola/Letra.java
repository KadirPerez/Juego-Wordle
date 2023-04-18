/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegowordle.consola;

public class Letra {
    int estado;
    String letra;
    
    public Letra(){
        estado = 0;
        letra = " ";
    }
    
    public Letra(int estado, String letra){
        this.estado = estado;
        this.letra = letra;
    }

    public String toString(){
        
        if (estado == 0)
            return "[ " + letra + " ]  ";
        if (estado == 1)
            return "< " + letra + " >  ";
        if (estado == 2)
            return "{ " + letra + " }  ";
        if (estado == 3)
            return "( " + letra + " )  ";
        else
            return "error";
        
    }
    
    public void setLetra(int estado, String letra){
        this.estado = estado;
        this.letra = letra;
    }
    
    public void setContenido(String letra){
        this.letra = letra;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public String getLetra(){
        return letra;
    }
    
    public int getEstado(){
        return estado;
    }
}
