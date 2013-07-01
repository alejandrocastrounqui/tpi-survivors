package ar.edu.unq.ts.components.abstracts;

import ar.edu.unq.ts.collidables.Collidable;
import ar.edu.unq.ts.components.moving.MovingHorizontal;
import ar.edu.unq.ts.components.moving.MovingNoneH;
import ar.edu.unq.ts.components.moving.MovingNoneV;
import ar.edu.unq.ts.components.moving.MovingState;
import ar.edu.unq.ts.components.moving.MovingToBottom;
import ar.edu.unq.ts.components.moving.MovingToLeft;
import ar.edu.unq.ts.components.moving.MovingToRight;
import ar.edu.unq.ts.components.moving.MovingToTop;
import ar.edu.unq.ts.components.moving.MovingVertical;

import com.uqbar.vainilla.DeltaState;

public abstract class MovableComponent extends Collidable {
	
	public MovingHorizontal hMovingState;
	public MovingVertical vMovingState;
	public double speed;
	public double speedDiagonal;
	public boolean isMoving;

	public MovableComponent(double x, double y) {
		super(x, y);
		this.speed = 300;
		this.speedDiagonal = 200;
		this.isMoving = false;
		this.hMovingState = MovingNoneH.getInstance();
		this.vMovingState = MovingNoneV.getInstance();
	}
	
	@Override
	public void update(DeltaState deltaState) {		
		super.update(deltaState);
		this.getMovingStateV().updateV(this, deltaState);
	}

	public MovingVertical getMovingStateV() {
		return vMovingState;
	}
	
	public MovingHorizontal getMovingStateH() {
		return hMovingState;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getSpeed() {
		return speed;
	}
	
	
	public MovingState getVMovingState() {
		return vMovingState;
	}
	
	public MovingState getHMovingState() {
		return hMovingState;
	}

	public void setRightEstado() {
		this.hMovingState = MovingToRight.getInstance();
		this.setMoving();
	}

	public void setLeftEstado() {
		this.hMovingState = MovingToLeft.getInstance();	
		this.setMoving();			
	}

	public void setTopEstado() {
		this.vMovingState = MovingToTop.getInstance();
		this.setMoving();
	}
	
	public void setBottomEstado() {
		this.vMovingState = MovingToBottom.getInstance();
		this.setMoving();
	}	

	public void setNoneEstadoH() {
		this.hMovingState = MovingNoneH.getInstance();
		vMovingState.confirmMovingState(this);
		
	}
	public void setNoneEstadoV() {
		this.vMovingState = MovingNoneV.getInstance();
		hMovingState.confirmMovingState(this);
	}

	public double getSpeedDiagonal() {
		return speedDiagonal;
	}
	
	public void setMoving(){
		if(!isMoving){
	    	this.isMoving = true;
			setMovingState();
		}
	}
	
	public void setStoping(){
		if(isMoving){
			this.isMoving = false;
			setStopState();
		}
	}
	
	public abstract void setStopState();
	
	public abstract void setMovingState();
}
