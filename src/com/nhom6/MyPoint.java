package com.nhom6;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
public class MyPoint {
//Tao diem
private Point2D.Double Point;
//So chi diem
private int indexPoint=0;
public MyPoint(double x, double y, int indexPoint) {
	Point = new Point2D.Double(x,y);
	this.indexPoint=indexPoint;
}
public void draw(Graphics g) {
	//Ve diem mau sac diem so chi diem
	g.setColor(Color.BLACK);
	//((Graphics2D) g).draw((Shape) Point);
	g.drawOval((int)Point.getX(),(int)Point.getY(),5,5);
	if(indexPoint>0) {
		String s="";
		g.drawString(s+indexPoint,(int)Point.getX(),(int)(Point.getY()+20));
	}
}
public int getIndexPoint() {
	return indexPoint;
}
public void setIndexPoint(int indexPoint) {
	this.indexPoint = indexPoint;
}
}
