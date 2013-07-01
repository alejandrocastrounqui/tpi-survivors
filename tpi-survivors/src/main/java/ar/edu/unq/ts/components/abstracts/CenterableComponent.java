package ar.edu.unq.ts.components.abstracts;

import com.uqbar.vainilla.DeltaState;

public abstract class CenterableComponent extends MovableComponent {

	public CenterableComponent(double x, double y) {
		super(x, y);
	}

	public void update(DeltaState deltaState){
		super.update(deltaState);
		//check to right
		if(this.borderRight() > camBorderRight()){
			this.moveCameraToX(fixRightCamX());			
		}
		//check to left
		if(this.borderLeft() < camBorderLeft()){
			this.moveCameraToX(fixLeftCamX());	
		}
		//check to bottom
		if(this.borderBottom() > camBorderBottom()){
			this.moveCameraToY(fixBottomCamY());	
		}
		//check to left
		if(this.borderTop() < camBorderTop()){
			this.moveCameraToY(fixTopCamY());
		}
	}

	private double fixLeftCamX() {
		return this.borderLeft() - getCamMargin();
	}
	
	private double fixTopCamY() {
		return this.borderTop() - getCamMargin();
	}

	private double fixRightCamX() {
		return this.borderRight() + getCamMargin() - getDisplayW();
	}
	
	private double fixBottomCamY() {
		return this.borderBottom() + getCamMargin() - getDisplayH();
	}

	private void moveCameraToX(double xx) {
		this.getScene().getCamera().setX(xx);		
	}
	private void moveCameraToY(double yy) {
		this.getScene().getCamera().setY(yy);		
	}

	
	private double camBorderLeft() {
		return getCamX() + getCamMargin();
	}
	private double camBorderTop() {
		return getCamY() + getCamMargin();
	}
	private double camBorderRight() {
		return getCamX() + getDisplayW() - getCamMargin();
	}
	private double camBorderBottom() {
		return getCamY() + getDisplayH() - getCamMargin();
	}

	private int getDisplayW() {
		return this.getGame().getDisplayWidth();
	}
	
	private int getDisplayH() {
		return this.getGame().getDisplayHeight();
	}

	private double getCamX() {
		return this.getScene().getCamera().getX();
	}
	
	private double getCamY() {
		return this.getScene().getCamera().getY();
	}
	
	private double getCamMargin(){
		return this.getScene().getCamera().getMargin();
	}
	


}
