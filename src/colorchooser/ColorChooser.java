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
import javax.swing.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.JSlider;

public class ColorChooser extends javax.swing.JPanel implements ChangeListener, ActionListener {

    Color color = new Color(0,0,0);

    
    private Vector listeners;
    /**
     * Creates new form ColorChooser
     */
    public ColorChooser() {
        initComponents();
        txfRed.setText("0");
        txfGreen.setText("0");
        txfBlue.setText("0");
        listeners = new Vector();
        sldRed.addChangeListener(this);
        sldGreen.addChangeListener(this);
        sldBlue.addChangeListener(this);
        txfRed.addActionListener(this);
        txfGreen.addActionListener(this);
        txfBlue.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRed = new javax.swing.JLabel();
        txfRed = new colorchooser.BitIntegerField();
        sldRed = new javax.swing.JSlider();
        lblGreen = new javax.swing.JLabel();
        txfGreen = new colorchooser.BitIntegerField();
        sldGreen = new javax.swing.JSlider();
        lblBlue = new javax.swing.JLabel();
        txfBlue = new colorchooser.BitIntegerField();
        sldBlue = new javax.swing.JSlider();

        setPreferredSize(new java.awt.Dimension(390, 350));

        lblRed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRed.setText("Red");
        lblRed.setPreferredSize(new java.awt.Dimension(36, 16));
        add(lblRed);

        txfRed.setPreferredSize(new java.awt.Dimension(40, 26));
        add(txfRed);

        sldRed.setMajorTickSpacing(50);
        sldRed.setMaximum(255);
        sldRed.setMinorTickSpacing(10);
        sldRed.setPaintLabels(true);
        sldRed.setPaintTicks(true);
        sldRed.setValue(0);
        sldRed.setMinimumSize(new java.awt.Dimension(36, 36));
        sldRed.setPreferredSize(new java.awt.Dimension(270, 40));
        add(sldRed);

        lblGreen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGreen.setText("Green");
        add(lblGreen);

        txfGreen.setPreferredSize(new java.awt.Dimension(40, 26));
        add(txfGreen);

        sldGreen.setMajorTickSpacing(50);
        sldGreen.setMaximum(255);
        sldGreen.setMinorTickSpacing(10);
        sldGreen.setPaintLabels(true);
        sldGreen.setPaintTicks(true);
        sldGreen.setValue(0);
        sldGreen.setPreferredSize(new java.awt.Dimension(270, 40));
        add(sldGreen);

        lblBlue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBlue.setText("Blue");
        lblBlue.setPreferredSize(new java.awt.Dimension(36, 16));
        add(lblBlue);

        txfBlue.setPreferredSize(new java.awt.Dimension(40, 26));
        add(txfBlue);

        sldBlue.setMajorTickSpacing(50);
        sldBlue.setMaximum(255);
        sldBlue.setMinorTickSpacing(10);
        sldBlue.setPaintLabels(true);
        sldBlue.setPaintTicks(true);
        sldBlue.setValue(0);
        sldBlue.setPreferredSize(new java.awt.Dimension(270, 40));
        add(sldBlue);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblGreen;
    private javax.swing.JLabel lblRed;
    private javax.swing.JSlider sldBlue;
    private javax.swing.JSlider sldGreen;
    private javax.swing.JSlider sldRed;
    private colorchooser.BitIntegerField txfBlue;
    private colorchooser.BitIntegerField txfGreen;
    private colorchooser.BitIntegerField txfRed;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e) {
        int r = sldRed.getValue();
        txfRed.setText("" + r);
        int g = sldGreen.getValue();
        txfGreen.setText("" + g);
        int b = sldBlue.getValue();
        txfBlue.setText("" + b);
        Color color = new Color(r,g,b);
        fireColorEvent(new ColorEvent(this,color));
    }

    //public JSlider getSldRed() {
    //    return sldRed;
    //}

    //public void setSldRed(JSlider sldRed) {
    //    this.sldRed = sldRed;
    //}

    //public BitIntegerField getTxfRed() {
    //    return txfRed;
    // }

   // public void setTxfRed(BitIntegerField txfRed) {
   //      this.txfRed = txfRed;
   // }
    
       
    public void fireColorEvent(ColorEvent colorEvent) {
        Vector v;
        synchronized(this) {
            v = (Vector)listeners.clone();
        }
        int size = v.size();
        for(int i = 0; i < size; i++) {
            ColorListener colorListener = (ColorListener)v.elementAt(i);
            colorListener.changeColor(colorEvent);
        }
    }
    
    public void addColorListener(ColorListener colorListener) {
        listeners.addElement(colorListener);
    }
    
    public void removeColorListener(ColorListener colorListener) {
        listeners.removeElement(colorListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try{
        int r = Integer.parseInt(txfRed.getText());
        sldRed.setValue(r);
        int g = Integer.parseInt(txfGreen.getText());
        sldGreen.setValue(g);
        int b = Integer.parseInt(txfBlue.getText());
        sldBlue.setValue(b);
        Color color = new Color(r,g,b);
        fireColorEvent(new ColorEvent(this,color));}
        catch(Exception ex){
            return;
        }
    }

    
}