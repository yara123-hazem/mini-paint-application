/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author sophi
 */
public interface Shape {
    /* set position */
    public void setPosition(Point position);
    public Point getPosition();
    /* colorize */
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();
    /* redraw the shape on the canvas */
    public void draw(Graphics canvas);
    public void setName(String name);
    public String getName();
}
