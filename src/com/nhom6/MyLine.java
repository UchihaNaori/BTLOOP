package com.nhom6;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Polygon;
public class MyLine {
	// so chi hai diem dau va cuoi
	private int indexP1;
	private int indexP2;
	// duong di qua 2 diem
	private Line2D.Double line;
	// chi so cua duong thang duoc them vao
	private int indexLine = 0;
	// ban kinh hinh tron cua point
	private final double radius = 15;
	public MyLine(Point p1, Point p2, int indexP1, int indexP2) {
		line = new Line2D.Double(p1, p2);
		this.indexP1 = indexP1;
		this.indexP2 = indexP2;
	}
    // ve duong thang di qua tam 2 point
	public void drawLineMiddle(Graphics2D g) {
		g.setColor(Color.black);
		// tang do rong cua line
		g.setStroke(new BasicStroke(3));
		g.draw(line);
		// ve chi so cua duong thang
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
		
	}
	// ve duong thang ben trai qua 2 point khi giua hai diem co 2 duong thang
	public void drawLineLeft(Graphics2D g) {
		g.setColor(Color.black);
		// tang do rong cua line
		g.setStroke(new BasicStroke(3) );
		// do dai duong thang qua 2 diem 
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2) );
		// tao 2 diem va duong thang di qua 2 diem ben trai (bien doi toan hoc)
		Point p1 = new Point((int) (line.x1 + (line.y2 - line.y1) * radius / range), (int) (line.y1 + (line.x1 - line.x2) * radius / range) );
		Point p2 = new Point((int) (line.x2 + (line.y2 - line.y1) * radius / range), (int) (line.y2 + (line.x1 - line.x2) * radius / range) );
		Line2D.Double line1 = new Line2D.Double(p1, p2);
		g.draw(line1);
		// ve chi so cua duong thang
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
	}
	// ve duong thang ben phai qua 2 point khi giua hai diem co 2 duong thang
	public void drawLineRight(Graphics2D g) {
		g.setColor(Color.black);
		// tang do rong cua line
		g.setStroke(new BasicStroke(3));
		// tao 2 diem va duong thang di qua 2 diem ben phai (bien doi toan hoc)
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2) );
		Point p1 = new Point((int) (line.x1 + (line.y1-line.y2) * radius / range),(int) (line.y1 + (line.x2 - line.x1) * radius / range) );
		Point p2 = new Point((int) (line.x2 + (line.y1-line.y2) * radius / range),(int) (line.y2 + (line.x2 - line.x1) * radius / range) );
		Line2D.Double line1 = new Line2D.Double(p1, p2);
		g.draw(line1);
		// ve chi so cua duong thang
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
	}
	// ve mui ten cho truong hop drawLine1
	public void drawArrowMiddle(Graphics2D g) {
		g.setColor(Color.black);
		// tim toa do 3 diem tạo thanh tam giac mui ten
		// range la khoang cach 2 point
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2) );
		// line1 la duong noi ngan nhat giua 2 diem nam tren hai duong tron co tam la 2 point
		Line2D.Double line1= new Line2D.Double(line.x1 + radius * (line.x2 - line.x1) / range, line.y1 + radius * (line.y2 - line.y1) / range, line.x2 - radius * (line.x2 -line.x1) / range, line.y2 - radius * (line.y2 - line.y1) / range);
		// range1 la chieu dai cua line1
		double range1 = Math.sqrt(Math.pow((line1.x2 - line1.x1), 2) + Math.pow((line1.y2 - line1.y1), 2) );
		// xPoint, yPoint chua toa do 3 diem tao thanh tam giac mui ten
		int[] xPoint = {(int) line1.x2, (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range1 + 4 * (line1.y2 - line.y1) / range1), (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range1 - 4 * (line1.y2 - line1.y1) / range1) };
		int[] yPoint = {(int) line1.y2, (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range1 + 4 * (line1.x1 - line.x2) / range1), (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range1 - 4 * (line1.x1 - line1.x2) / range1) };
		// ve mui ten
		Polygon p = new Polygon(xPoint, yPoint, 3);
		g.fillPolygon(p);
		g.drawPolygon(xPoint, yPoint, 3);
	}
	// ve mui ten cho truong hop drawLine2 va drawLine3
	public void drawArrowLeftRight(Graphics2D g) {
		g.setColor(Color.black);
		// tim qua do 3 diem tao thanh tam giac mui ten 
		// range la khoang cach 2 point
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2) );
		// xPoint, yPoint chua toa do 3 diem tao thanh tam giac mui ten
		int[] xPoint = {(int) line.x2, (int) (line.x2 + 10 * (line.x1 - line.x2) / range + 4 * (line.y2 - line.y1) / range), (int) (line.x2 + 10 * (line.x1 - line.x2) / range - 4 * (line.y2 - line.y1) / range) };
		int[] yPoint = {(int) line.y2, (int) (line.y2 + 10 * (line.y1 - line.y2) / range + 4 * (line.x1 - line.x2) / range), (int) (line.y2 + 10 * (line.y1 - line.y2) / range - 4 * (line.x1 - line.x2) / range) };
		// ve mui ten
		Polygon p = new Polygon(xPoint, yPoint, 3);
		g.fillPolygon(p);
		g.drawPolygon(xPoint, yPoint, 3);
	}

	public int getIndexP1() {
		return indexP1;
	}

	public void setIndexP1(int indexP1) {
		this.indexP1 = indexP1;
	}

	public int getIndexP2() {
		return indexP2;
	}

	public void setIndexP2(int indexP2) {
		this.indexP2 = indexP2;
	}

	public int getIndexLine() {
		return indexLine;
	}

	public void setIndexLine(int order) {
		this.indexLine = indexLine;
	}
	    
}