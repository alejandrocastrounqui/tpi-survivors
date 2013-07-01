package ar.edu.unq.ts.components.abstracts;

import ar.edu.unq.ts.application.TSGameComponent;

public abstract class PlaceableComponent extends TSGameComponent {

	public PlaceableComponent(double x, double y) {
		super(x, y);
	}
	
	public double borderLeft(){
		return this.getRealX();
	}	
	public double borderRight(){
		return this.getRealX() + this.getWidth();
	}	

	public double borderTop(){
		return this.getRealY();
	}
	
	public double borderBottom(){
		return this.getRealY() + this.getHeight();
	}
	
	public double centerY() {
		return this.getY() + (this.getHeight() / 2);
	}

	public double centerX() {
		return this.getX() + (this.getWidth() / 2);
	}
	
	public double relCenterY() {
		return this.getRealY() + (this.getHeight() / 2);
	}

	public double relCenterX() {
		return this.getRealX() + (this.getWidth() / 2);
	}
	
	public double absCenterY() {
		return this.getRealY() + (this.getHeight() / 2);
	}

	public double absCenterX() {
		return this.getRealX() + (this.getWidth() / 2);
	}
	
	public void move(double xx, double yy) {
		this.setX(this.getRealX() + xx);
		this.setY(this.getRealY() + yy);
	}
	
	public abstract double getWidth();
	
	public abstract double getHeight();

}
