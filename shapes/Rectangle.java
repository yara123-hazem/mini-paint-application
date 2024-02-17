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
public class Rectangle extends Shapee {

    private int height, width;
    private static int n = 0;
   

    public Rectangle(int x, int y, int height, int width, Color borderColor, Color fillColor) {
        this.setName("Rectangle_" + (++n));
        super.setPosition(new Point(x, y));//this.getPosition() represents Top Left Corner
        this.height = height;
        this.width = width;
        this.setColor(borderColor);
        this.setFillColor(fillColor);
        int[] xVertices = {this.getPosition().x, this.getPosition().x, this.getPosition().x + width, this.getPosition().x + width};
        int[] yVertices = {this.getPosition().y, this.getPosition().y + height, this.getPosition().y + height, this.getPosition().y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
        setIsSelected(false);
    }
    
    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Rectangle.n = n;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        int[] xVertices = {this.getPosition().x, this.getPosition().x, this.getPosition().x + width, this.getPosition().x + width};
        int[] yVertices = {this.getPosition().y, this.getPosition().y + height, this.getPosition().y + height, this.getPosition().y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
    }

    @Override
//    public void draw(Graphics canvas) {
//        canvas.setColor(this.getFillColor());
//        canvas.fillRect(this.getPosition().x, this.getPosition().y, width, height);        
//        canvas.setColor(this.getColor());
//        canvas.drawRect(this.getPosition().x, this.getPosition().y, width, height);
//    }
    public void draw(Graphics canvas) {

        canvas.setColor(this.getFillColor());
        canvas.fillPolygon(this.getXVertices(), this.getYVertices(), 4);
        canvas.setColor(this.getColor());
        canvas.drawPolygon(this.getXVertices(), this.getYVertices(), 4);
    }

    @Override
    public boolean contains(Point point) {
        return (point.x >= this.getPosition().x) && (point.x <= this.getPosition().x + width) && (point.y >= this.getPosition().y) && (point.y <= height + this.getPosition().y);
    }

    @Override
    public void moveTo(Point point) {
        if (this.getDraggingPoint() != null) {
            int dx = point.x - this.getDraggingPoint().x;
            int dy = point.y - this.getDraggingPoint().y;
            Point newPos = new Point(this.getPosition().x + dx, this.getPosition().y + dy);
            setPosition(newPos);
        }

    }
//////////////////////////////////////////

    @Override
    public void resize(Point point, int i) {
        switch (i) {
            case 0:
                int dx0 = point.x - this.getXVertices()[0];
                int dy0 = point.y - this.getYVertices()[0];
                setWidth(getWidth() - dx0);
                setHeight(getHeight() - dy0);
                Point p0 = new Point(this.getPosition().x + dx0, this.getPosition().y + dy0);
                setPosition(p0);
                break;
            case 1:
                int dx1 = this.getXVertices()[1] - point.x;
                int dy1 = point.y - this.getYVertices()[1];
                setWidth(getWidth() + dx1);
                setHeight(getHeight() + dy1);
                Point p1 = new Point(this.getPosition().x - dx1, this.getPosition().y);
                setPosition(p1);
                break;
            case 2:
                int dx2 = point.x - this.getXVertices()[2];
                int dy2 = point.y - this.getYVertices()[2];
                setWidth(getWidth() + dx2);
                setHeight(getHeight() + dy2);
                setPosition(getPosition());
                break;
            case 3:
                int dx3 = point.x - this.getXVertices()[3];
                int dy3 = this.getYVertices()[3]- point.y;
                setWidth(getWidth() + dx3);
                setHeight(getHeight() + dy3);
                Point p3 = new Point(this.getPosition().x , this.getPosition().y-dy3);
                setPosition(p3);
                break;
        }
    }
}
