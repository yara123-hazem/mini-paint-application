/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.pow;

/**
 *
 * @author sophi
 */
public class Oval extends Shapee {

    private double Hradius;
    private double Vradius;
    private static int n = 0;

    //constructor takes coordinate of center
    public Oval(int x, int y, int hradius, int vradius, Color borderColor, Color fillColor) {
        this.setName("Oval_" + (++n));
        //super.setPosition(new Point(x, y)); //Position represents center of oval
        super.setPosition(new Point(x - hradius, y - vradius)); //Position represents top left corner of oval
        this.Hradius = hradius;
        this.Vradius = vradius;
        this.setColor(borderColor);
        this.setFillColor(fillColor);
        //int[] xVertices = {(int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) + Hradius) ,(int)((this.getPosition().x) + Hradius)};
        //int[] yVertices = {(int)((this.getPosition().y) - Vradius),(int) ((this.getPosition().y) + Vradius ), (int)((this.getPosition().y) + Vradius ),(int)((this.getPosition().y) - Vradius)};
        int[] xVertices = {this.getPosition().x, this.getPosition().x, this.getPosition().x + (int)(2*Hradius), this.getPosition().x + (int)(2*Hradius)};
        int[] yVertices = {this.getPosition().y, this.getPosition().y + (int)(2*Vradius), this.getPosition().y + (int)(2*Vradius), this.getPosition().y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
        setIsSelected(false);
    }
    //constructor takes coordinate of position(Top Left Corner)
    public Oval(double hradius, double vradius, Color borderColor, Color fillColor,int x, int y) {
        this.setName("Oval_" + (++n));
        //super.setPosition(new Point(x, y)); //Position represents center of oval
        super.setPosition(new Point(x,y)); //Position represents top left corner of oval
        this.Hradius = hradius;
        this.Vradius = vradius;
        this.setColor(borderColor);
        this.setFillColor(fillColor);
        //int[] xVertices = {(int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) + Hradius) ,(int)((this.getPosition().x) + Hradius)};
        //int[] yVertices = {(int)((this.getPosition().y) - Vradius),(int) ((this.getPosition().y) + Vradius ), (int)((this.getPosition().y) + Vradius ),(int)((this.getPosition().y) - Vradius)};
        int[] xVertices = {this.getPosition().x, this.getPosition().x, this.getPosition().x + (int)(2*Hradius), this.getPosition().x + (int)(2*Hradius)};
        int[] yVertices = {this.getPosition().y, this.getPosition().y + (int)(2*Vradius), this.getPosition().y + (int)(2*Vradius), this.getPosition().y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
        setIsSelected(false);
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Oval.n = n;
    }

    public void setHradius(double Hradius) {
        this.Hradius = Hradius;
    }

    public void setVradius(double Vradius) {
        this.Vradius = Vradius;
    }

    public double getHradius() {
        return Hradius;
    }

    public double getVradius() {
        return Vradius;
    }
    

    @Override
    public void setPosition(Point position) {
        super.setPosition(position);
        //int[] xVertices = {(int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) - Hradius), (int)((this.getPosition().x) + Hradius) ,(int)((this.getPosition().x) + Hradius)};
        //int[] yVertices = {(int)((this.getPosition().y) - Vradius),(int) ((this.getPosition().y) + Vradius ), (int)((this.getPosition().y) + Vradius ),(int)((this.getPosition().y) - Vradius)};
        int[] xVertices = {this.getPosition().x, this.getPosition().x, this.getPosition().x + (int)(2*Hradius), this.getPosition().x + (int)(2*Hradius)};
        int[] yVertices = {this.getPosition().y, this.getPosition().y + (int)(2*Vradius), this.getPosition().y + (int)(2*Vradius), this.getPosition().y};
        this.setXVertices(xVertices);
        this.setYVertices(yVertices);
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getXVertices()[0], this.getYVertices()[0], 2 * (int) Hradius, 2 * (int) Vradius);
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getXVertices()[0], this.getYVertices()[0], 2 * (int) Hradius, 2 * (int) Vradius);
    }

    @Override
    public boolean contains(Point point) {
        double h = this.getPosition().x + Hradius;
        double k = this.getPosition().y + Vradius;
        double x = pow(((double) (point.x - h) / Hradius), 2);
        double y = pow(((double) (point.y - k) / Vradius), 2);
        return x + y <= 1;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void resize(Point point, int i) {
        double Hdiameter = 2 * Hradius;
        double Vdiameter = 2 * Vradius;
        switch (i) {
            case 0:
                int dx0 = this.getXVertices()[0] - point.x;
                int dy0 = this.getYVertices()[0] - point.y;
                Hdiameter += dx0;
                Vdiameter += dy0;
                setHradius(Hdiameter / 2);
                setVradius(Vdiameter / 2);
                Point p0 = new Point(this.getPosition().x - dx0, this.getPosition().y - dy0);
                setPosition(p0);
                break;
            case 1:
                int dx1 = this.getXVertices()[1] - point.x;
                int dy1 = point.y - this.getYVertices()[1];
                Hdiameter += dx1;
                Vdiameter += dy1;
                setHradius(Hdiameter / 2);
                setVradius(Vdiameter / 2);
                Point p1 = new Point(this.getPosition().x - dx1, this.getPosition().y);
                setPosition(p1);
                break;
            case 2:
                int dx2 = point.x - this.getXVertices()[2];
                int dy2 = point.y - this.getYVertices()[2];
                Hdiameter += dx2;
                Vdiameter += dy2;
                setHradius(Hdiameter / 2);
                setVradius(Vdiameter / 2);
                setPosition(getPosition());
                break;
            case 3:
                int dx3 = point.x - this.getXVertices()[3];
                int dy3 = this.getYVertices()[3] - point.y;
                Hdiameter += dx3;
                Vdiameter += dy3;
                setHradius(Hdiameter / 2);
                setVradius(Vdiameter / 2);
                Point p3 = new Point(this.getPosition().x, this.getPosition().y - dy3);
                setPosition(p3);
                break;
        }
    }
}
