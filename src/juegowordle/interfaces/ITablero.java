
package juegowordle.interfaces;


public interface ITablero {
    
    public void despliegaTablero();   
   
    public void agregarIntento(String intento, String palabra, int ni);
    
    public void mostrarResultado(String palabra,boolean gano);
    
    public void mostrarInstrucciones();
    
    public void limpiarPantalla();
    
}
