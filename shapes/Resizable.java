/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author sophi
 */
public interface Resizable {
    public int[] getXVertices();
    public void setXVertices(int[] xVertices);
    public int[] getYVertices();
    public void setYVertices(int[] yVertices);
    public void showVertices(Graphics g);
    public int vertixCaught(Point point);
    public void resize(Point point , int i);
    
}
