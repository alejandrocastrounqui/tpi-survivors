package ar.edu.unq.ts.camera;

public class Camera {

	private double x;
	private double y;
	private double margin;
	
	public Camera() {
		margin = 150;
		x = 0;
		y = 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void move(double xx, double yy) {
		this.x += xx;
		this.y += yy;
	}

	public double getMargin() {		
		return this.margin;
	}

}
