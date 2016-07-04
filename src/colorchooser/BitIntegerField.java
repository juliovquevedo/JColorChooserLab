/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 *
 * @author julioquevedo
 */
public class BitIntegerField extends JTextField{
    
    public BitIntegerField(){
        super();
    }
    
    @Override
    protected Document createDefaultModel(){
        String[] accept = {"0","1","2","3","4","5","6","7","8","9"};
        return new _255MaxDocument(accept);
    }
    
    public int getValue() throws NumberFormatException{
        return Integer.parseInt(getText());
    }
}
