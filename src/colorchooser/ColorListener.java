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
import java.util.*;


public interface ColorListener extends EventListener {
    public void changeColor(ColorEvent ce);
}
