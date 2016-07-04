
/**
 *
 * @author julioquevedo
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import javax.swing.text.*;

public class _255MaxDocument extends PlainDocument{
    String[] charList;
    
    public _255MaxDocument(String[] charList){
        this.charList = charList;
    }
    
    public boolean validate(String exp){
        
        for(int i=0; i<charList.length; i++){
            if(exp.equals(charList[i])){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
        char[] insertChars = str.toCharArray();
        
        boolean valid = true;
        boolean fit = true;
        
        if(insertChars.length + getLength() <= 3) {
            for(int i = 0; i < insertChars.length; i++) {
                if(!Character.isDigit(insertChars[i])) {
                    valid = false;
                    break;
                }
            }
        }
        else 
            fit = false;
        
        if(fit && valid)
        //if(str == null || !validate(str)){
        //    return;
        //}
        super.insertString(offs, str, a);
    }
}
