import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 * Write a description of class Checkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * holaaaa  que hace
 */
public class Checkers
{
    private Table zonaJuego;
    private Table zonaConfiguracion;
    /**
     * Checkers realiza el tablero de configuracion y de juego
     * @param width un entero para determinar el tamaño del tablero (width*width)
     */
   
    public Checkers(int width){
        zonaJuego = new Table(width,30,30);
        zonaConfiguracion = new Table(width,width*30+60,30);
    }
    
    public void makeVisible(){
        zonaJuego.makeVisible();
        zonaConfiguracion.makeVisible();
    }
    
    public void add(boolean white, boolean king ,int row, int column){
        zonaConfiguracion.add(white ,king ,row ,column);
    }
    
    public void add(boolean white, int [][] men){
        for(int i = 0; i<men.length; i++){
            zonaConfiguracion.add(white, false, men[i][0], men[i][1]);
        }
    }
    
    public void select(int row, int column){
        zonaConfiguracion.select(row,column);
    }
    
    public void shift(boolean top, boolean right){
        zonaConfiguracion.shift(top,right);
    }
    
    public void jump(boolean top, boolean right){
        zonaConfiguracion.jump(top, right);
    }
}
