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
public class LineSegment extends Shapee {

    private Point endPoint;
    private static int n = 0;
    public LineSegment(){}

    public LineSegment(int x1, int y1, int x2, int y2, Color color) {
        this.setName("Line_" + (++n));
        super.setPosition(new Point(x1, y1)); //this.getPosition() represents start point
        endPoint = new Point(x2, y2);
        this.setColor(color);
        this.setFillColor(color);
        int[] xVertices = {this.getPosition().x, endPoint.x};
        int[] yVertices = {this.getPosition().y, endPoint.y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
        setIsSelected(false);
    }
    
    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        LineSegment.n = n;
    }
    
    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        this.getXVertices()[0]=position.x;
        this.getYVertices()[0]=position.y;
    }
    
    public void setEndPoint(Point endPoint){
        this.endPoint=endPoint;
        this.getXVertices()[1]=endPoint.x;
        this.getYVertices()[1]=endPoint.y;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    

    @Override
//    public void draw(Graphics canvas) {
//        canvas.setColor(this.getColor());
//        canvas.drawLine(this.getPosition().x,this.getPosition().y,endPoint.x,endPoint.y);
//    }
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawPolygon(this.getXVertices(), this.getYVertices(), 2);
    }

    @Override
    public boolean contains(Point point) {
        int l = (int) this.getPosition().distance(endPoint);
        return (int) (point.distance(this.getPosition()) + point.distance(endPoint)) == l;
    }

    @Override
    public void moveTo(Point point) {
        if (this.getDraggingPoint() != null) {
            int dx = point.x - this.getDraggingPoint().x;
            int dy = point.y - this.getDraggingPoint().y;
            Point startPoint = new Point(this.getPosition().x + dx, this.getPosition().y + dy);
            setPosition(startPoint);
            Point endP = new Point(endPoint.x + dx, endPoint.y + dy);
            setEndPoint(endP);
            //endPoint = endP;
        }

    }

    @Override
    public void resize(Point point, int i) {
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
                Point p1 = new Point(this.getEndPoint().x+dx1,this.getEndPoint().y+dy1);
                setEndPoint(p1);
                break;
        }
    }
}
