/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jordipc
 */
public class Taulell {
    int [][] tauler_joc;
    
    //constructor
    public Taulell() {
        tauler_joc=new int[3][3];
        reiniciarTaulell();
        
    }
    //representarem el taulell de joc
    
    //mètodes classe
    public void reiniciarTaulell(){
           //reiniciem el taulell de joc          
           for(int x=0;x<3;x++){ 
               for(int y=0;y<3;y++){ //iniciem els 5 taulells, que hauran d'estar disponibles hi per tan al contenidor d'objectes.
                     tauler_joc[x][y]= 0;
               }
           }           
           
    }
    
    public void posicionarTirada(){
        //capturar a quina casella clica el jugador(i quin jugador és) i gestionar-ho
    }
    
     public int estatPosicio(int x,int y){
        //return integer, si 1=PLE 0=BUIT 2=RIVAL
        return tauler_joc[x][y];  //retornem el valor de la posicio
         
    }
    
}
