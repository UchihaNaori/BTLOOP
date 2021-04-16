
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.geom.Path2D;
import java.awt.geom.AffineTransform;
public class MyLine {
	// so chi diem 
	private int indexP1; 
	private int indexP2;
	//mau sac cho doan thang
	private Color color[] = { Color.white, Color.red };
	// duong thang
	private Line2D.Double line;
	private int type = 0;
	// so chi vi tri duong trong thuat toan
	private int indexLine = 0;
	
	public MyLine(Point p1, Point p2, int indexP1, int indexP2) {
		line = new Line2D.Double(p1, p2);
		this.indexP1 = indexP1;
		this.indexP2 = indexP2;
	}

	public void draw(Graphics2D g) {
		// ve line va mau sac cua line
		g.setColor(color[type]);
		g.draw(line);
		if (indexLine > 0) {
			// them indexLine vao duong
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIndexLine() {
		return indexLine;
	}

	public void setIndexLine(int indexLine) {
		this.indexLine = indexLine;
	}

}
