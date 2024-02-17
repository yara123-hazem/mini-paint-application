/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import shapes.Shape;
import shapes.Shapee;
import java.awt.Graphics;
import java.util.ArrayList;
import shapes.LineSegment;
import shapes.Oval;
import shapes.Rectangle;
import shapes.Triangle;

/**
 *
 * @author sophi
 */
public class MyPanel extends javax.swing.JPanel implements DrawingEngine {

    private ArrayList<Shape> shapes;

    /**
     * Creates new form MyPanel
     */
    public MyPanel() {
        this.shapes = new ArrayList<>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);
            Shapee s = (Shapee) shapes.get(i);
            if (s.isIsSelected()) {
                s.showVertices(g);
            }
        }

    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public boolean removeShape(Shape shape) {
        return shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        Shape[] shapesArray = new Shape[shapes.size()];
        shapesArray = shapes.toArray(shapesArray);
        return shapesArray;
    }

    @Override
    public void refresh(Graphics canvas) {
        repaint();
    }

    public Shape getShape(String name) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getName().equals(name)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    public void clear() {
        shapes.clear();
        refresh(null);
        Oval.setN(0);
        Rectangle.setN(0);
        LineSegment.setN(0);
        Triangle.setN(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
