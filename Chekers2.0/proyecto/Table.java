import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 * Write a description of class Table here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Table
{
    private Rectangle[][] casillas;
    private Ficha[][] listaDeFichas;
    public Table(int width,int moverX, int moverY){
        casillas = new Rectangle[width][width];
        listaDeFichas = new Ficha[width][width];
        table(width,moverX,moverY);
    }
    public void table(int width, int moverX, int moverY){
        String colorActual =  "black";
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++  ){
                String color ="";
                if (width%2 == 0 && j ==0 && i>0)color = colorActual;
                else if (colorActual.equals("black"))color = "white";
                else if (colorActual.equals("white"))color = "black";
                casillas[i][j] = new Rectangle(30,30,moverX+30*j,moverY*i+30,color);
                casillas[i][j].makeVisible();
                colorActual = color;
            }
        }
    
    }

    public void makeVisible(){
            for (int i = 0; i < casillas.length; i++){
                for (int j = 0; j < casillas.length; j++){
                    casillas[i][j].makeVisible();
                }
            }
    }

    public void add(boolean white,boolean king ,int row, int column){
        if (white){
            if (listaDeFichas[row][column] == null){
                crearFicha(row,column,white);
            }else{
                JOptionPane.showMessageDialog(null,"ya hay una ficha en esa posición");
            }
        }else{
            if (listaDeFichas[row][column] == null){
                crearFicha(row,column,white);
            }else{
                JOptionPane.showMessageDialog(null,"ya hay una ficha en esa posición");
            }
        }
    }
        
    private void crearFicha(int row, int column, boolean white ){
        Rectangle asignarFicha = casillas[row][column];
        if (white){
            String color = "green";
            Ficha peon = new Ficha(asignarFicha.getPositionX(),asignarFicha.getPositionY(),color);
            peon.darColor(true);
            peon.setFicha(row,column);
            listaDeFichas[row][column] = peon;
            peon.makeVisible();
        }else{
            String color = "red";
            Ficha peon = new Ficha(asignarFicha.getPositionX(),asignarFicha.getPositionY(),color);
            peon.setFicha(row,column);
            listaDeFichas[row][column] = peon;
            peon.makeVisible();
        } 
    }
    
    public void select(int row , int column){
        if (listaDeFichas[row][column] != null){
            Ficha seleccion = listaDeFichas[row][column];
            seleccion.setPossion(true);
            seleccion.changeColor("blue");
        }
    }
    
    public void shift(boolean top, boolean right){
        for(int i = 0; i<listaDeFichas.length; i++){
            for (int j = 0; j<listaDeFichas.length; j++){
                if (listaDeFichas[i][j]!= null){
                    if(listaDeFichas[i][j].getSelect()){
                        listaDeFichas[i][j].shift(top,right,listaDeFichas,casillas,i,j);
                        return;
                    }
                }
            }
        }
    }
    
    public void jump(boolean top, boolean right){
        for(int i = 0; i<listaDeFichas.length; i++){
            for (int j = 0; j<listaDeFichas.length; j++){
                if (listaDeFichas[i][j]!= null){
                    if(listaDeFichas[i][j].getSelect()){
                        listaDeFichas[i][j].jump(top,right,listaDeFichas,casillas,i,j);
                        return;
                    }
                }
            }
        }
    }
}
