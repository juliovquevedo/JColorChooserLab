/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author 01648765
 */
public class ColorLabel2 extends JLabel implements ColorListener{
    @Override
    public void changeColor(ColorEvent ce) {
        //setText("Red: " + ce.getColor().getRed() + " Green: " + ce.getColor().getGreen() + " Blue: " + ce.getColor().getBlue());
        setForeground(ce.getColor());
    }
    
    public ColorLabel2(){
        super();
        //setText("Red: 0 Green: 0 Blue: 0");
        setText("Color Label Test");
        setForeground(Color.BLACK);
    }
    
}
