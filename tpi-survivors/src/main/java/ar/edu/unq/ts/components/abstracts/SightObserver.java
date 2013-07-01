package ar.edu.unq.ts.components.abstracts;

import java.awt.geom.Point2D.Double;

import ar.edu.unq.tes.components.animation.IAnimationObserver;
import ar.edu.unq.tes.components.animation.ShooterAnimationController;
import ar.edu.unq.ts.extra.Direction;

import com.uqbar.vainilla.DeltaState;

public abstract class SightObserver extends CenterableComponent {
	
	
	private IAnimationObserver animationObserver;
	
	private Direction direction;
	
	private double lastXVector;
	private double lastYVector;
	
	private final static double PIX2 = Math.PI * 2;
	private final static double PID4 = Math.PI / 4;
	private final static double PID8 = Math.PI / 8;

	public SightObserver(double x, double y) {
		super(x, y);
		animationObserver = new ShooterAnimationController(this);
		this.setDireccion(Direction.SUR);		
	}
	
	@Override
	public void update(DeltaState delta) {
		super.update(delta);
		this.updatePosition(delta.getCurrentMousePosition());
	    this.animationObserver.update(delta);
	}
	
	

	private void updatePosition(Double currentMousePosition) {
		if(lastXVector != currentMousePosition.getX() - this.centerX() || //
		   lastYVector != currentMousePosition.getY() - this.centerY()){			
			lastXVector = currentMousePosition.getX() - this.centerX();
			lastYVector = currentMousePosition.getY() - this.centerY();
			setPosition(currentMousePosition);
		}
	}

	private void setPosition(Double currentMousePosition) {
		
		double angle = 0.0;
		int dIndex = 6;
		angle = - StrictMath.atan2(lastYVector , lastXVector);
		if(angle < 0.0){
			angle += PIX2;
		}
		dIndex = (int) Math.floor((angle + PID8) / (PID4));
		if(dIndex == 8){
			dIndex = 0;
		}
		this.getScene().prompt("DIndex: " + Direction.values()[dIndex]);
		this.setDireccion(Direction.values()[dIndex]);
	}

	public Direction getDireccion() {
		return direction;
	}
	
	public void setDireccion(Direction direction) {
		this.direction = direction;
		animationObserver.notifyDirection(direction);
	}
	

	public static void main(String[] args) {
		System.out.println(Math.acos(0/1));	}
	
	@Override
	public void setStopState() {
		this.animationObserver.setStopState();		
	}
	
	@Override
	public void setMovingState() {
		this.animationObserver.setMovingState();		
	}
	

	public void setShotingState() {
		this.animationObserver.beeginShot();		
	}

	public void setNotShootingState() {
		this.animationObserver.stopShot();		
	}
	
	
	public double getLastXVector() {
		return lastXVector;
	}
	
	public double getLastYVector() {
		return lastYVector;
	}

}
