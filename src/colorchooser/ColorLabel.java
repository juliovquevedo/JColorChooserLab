/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

/**
 *
 * @author julioquevedo
 */
import javax.swing.JLabel;

public class ColorLabel extends JLabel implements ColorListener{

    @Override
    public void changeColor(ColorEvent ce) {
        //setText("Red: " + ce.getColor().getRed() + " Green: " + ce.getColor().getGreen() +
        //        " Blue: " + ce.getColor().getBlue());
        setText("Hex: #" + Integer.toHexString(ce.getColor().getRed()) + Integer.toHexString(ce.getColor().getGreen()) 
                + Integer.toHexString(ce.getColor().getBlue()));
    }
    
    public ColorLabel() {
        super();
        //setText("Red: 0  Green: 0  Blue: 0");
        //setText("Hex: # ");
    }

    
}
