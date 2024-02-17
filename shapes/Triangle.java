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
 * @author Admin
 */
public class Triangle extends Shapee {

    private static int n = 0;
    private Point point2;
    private Point point3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color borderColor, Color fillColor) {
        this.setName("Triangle_" + (++n));
        super.setPosition(new Point(x1, y1));
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        this.setColor(borderColor);
        this.setFillColor(fillColor);
        int[] xVertices = {this.getPosition().x, point2.x, point3.x};
        int[] yVertices = {this.getPosition().y, point2.y, point3.y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
        setIsSelected(false);
    }
    
    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Triangle.n = n;
    }
    
    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        this.getXVertices()[0]=position.x;
        this.getYVertices()[0]=position.y;
    }
    
    public void setPoint2(Point point){
        this.point2=point;
        this.getXVertices()[1]=point.x;
        this.getYVertices()[1]=point.y;
    }
    
    public void setPoint3(Point point){
        this.point3=point;
        this.getXVertices()[2]=point.x;
        this.getYVertices()[2]=point.y;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }
    
    

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getFillColor());
        canvas.fillPolygon(this.getXVertices(), this.getYVertices(), 3);
        canvas.setColor(this.getColor());
        canvas.drawPolygon(this.getXVertices(), this.getYVertices(), 3);
    }

    public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    @Override
    public boolean contains(Point point) {
        double A = area(this.getPosition().x, this.getPosition().y, point2.x, point2.y, point3.x, point3.y);
        double A1 = area(point.x, point.y, point2.x, point2.y, point3.x, point3.y);
        double A2 = area(this.getPosition().x, this.getPosition().y, point.x, point.y, point3.x, point3.y);
        double A3 = area(this.getPosition().x, this.getPosition().y, point2.x, point2.y, point.x, point.y);
        return (A == A1 + A2 + A3);
    }

    @Override
    public void moveTo(Point point) {
        if (this.getDraggingPoint() != null) {
            int dx=point.x-this.getDraggingPoint().x;
            int dy=point.y-this.getDraggingPoint().y;
            setPosition(new Point (this.getPosition().x+dx,this.getPosition().y+dy));
            setPoint2(new Point (point2.x+dx,point2.y+dy));
            setPoint3(new Point (point3.x+dx,point3.y+dy));
            //point2=new Point (point2.x+dx,point2.y+dy);
            //point3=new Point (point3.x+dx,point3.y+dy);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void resize(Point point , int i) {
        switch (i) {
            case 0:
                int dx0=point.x-this.getXVertices()[0];
                int dy0=point.y-this.getYVertices()[0];
                Point p0 = new Point(this.getPosition().x+dx0,this.getPosition().y+dy0);
                setPosition(p0);
                break;
            case 1:
                int dx1=point.x-this.getXVertices()[1];
                int dy1=point.y-this.getYVertices()[1];
                Point p1 = new Point(this.getPoint2().x+dx1,this.getPoint2().y+dy1);
                setPoint2(p1);
                break;
            case 2:
                int dx2=point.x-this.getXVertices()[2];
                int dy2=point.y-this.getYVertices()[2];
                Point p2 = new Point(this.getPoint3().x+dx2,this.getPoint3().y+dy2);
                setPoint3(p2);
                break;
        }
    }

}
