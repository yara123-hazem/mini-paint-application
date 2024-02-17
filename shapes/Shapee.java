/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author sophi
 */
public abstract class Shapee implements Shape, Moveable, Resizable {

    private Point position;
    private Color borderColor, fillColor;
    private String name;
    private Point draggingPoint;
    private int[] xVertices;
    private int[] yVertices;
    private boolean isSelected;
    
    public Shapee(){}

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public Color getColor() {
        return borderColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    @Override
    public int[] getXVertices() {
        return xVertices;
    }

    @Override

    public void setXVertices(int[] xVertices) {
        this.xVertices = xVertices;
    }

    public int[] getYVertices() {
        return yVertices;
    }

    @Override
    public void setYVertices(int[] yVertices) {
        this.yVertices = yVertices;
    }

    @Override
    public void showVertices(Graphics g) {
        int x=10;
        for (int i = 0; i < xVertices.length; i++) {
            g.setColor(java.awt.Color.BLACK);
            g.fillRect(xVertices[i]-(x/2), yVertices[i]-(x/2), x, x);
        }
    }
    
    @Override
    public int vertixCaught(Point point){
        for(int i=0;i<xVertices.length;i++){
            if((point.x>xVertices[i]-5)&&(point.x<xVertices[i]+5)&&(point.y>yVertices[i]-5)&&(point.y<yVertices[i]+5)){
                return i;
            }
        }  
        return -1;
    }
}
