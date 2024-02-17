/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import shapes.Shape;


/**
 *
 * @author sophi
 */
public abstract class Node extends javax.swing.JFrame {
    private Node ParentNode;
    
    public Node getParentNode() {
        return ParentNode;
    }

    public void setParentNode(Node ParentNode) {
        this.ParentNode = ParentNode;
    }
    public abstract void setData(Shape[] shapes);
}
