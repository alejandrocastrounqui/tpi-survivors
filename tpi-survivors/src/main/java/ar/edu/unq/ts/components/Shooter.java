package ar.edu.unq.ts.components;

import ar.edu.unq.tes.components.shootstates.NotShootingState;
import ar.edu.unq.tes.components.shootstates.ShootState;
import ar.edu.unq.tes.components.shootstates.ShootingState;
import ar.edu.unq.ts.collidables.CollidableCircle;
import ar.edu.unq.ts.components.abstracts.SightObserver;

import com.uqbar.vainilla.DeltaState;

    /***Gerarquia Shooter -> SightObserver -> CenterableComponent -> MovableComponent -> TSGameComponent -> GameComponent**/

public class Shooter extends SightObserver {
	public static final int DEFAULT_SIZE = 20;
	
	private ShootState currentShootState;
	private ShootState shootingState;
	private ShootState notShootingState;

	public Shooter(double x, double y) {
		super(x, y);
		this.notShootingState = new NotShootingState();
		this.shootingState = new ShootingState();
		currentShootState = notShootingState;
	}

	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.currentShootState.update(deltaState, this);
	}
	
	public double getXShotPosition(){
		return absCenterX() + getDireccion().getXMove()*20;
	}

	public double getYShotPosition(){
		return absCenterY() + getDireccion().getYMove()*20;
	}
	
	public void shootOctoDiagonal() {
		this.getScene().addShot(new Shot(getXShotPosition(), getYShotPosition(), getDireccion().getXMove(), getDireccion().getYMove()));		
	}
	
	public void shootProgresive() {
		this.getScene().addShot(new Shot(absCenterX(), absCenterY(), getLastXVector(), getLastYVector()));		
	}

	@Override
	public double getWidth() {
		return 60;
	}

	@Override
	public double getHeight() {
		return 60;
	}
	
	public void move(double xx, double yy) {
		if(this.isPosibleXMove(xx)){
			this.setX(this.getRealX() + xx);			
		}
		if(this.isPosibleYMove(yy)){
			this.setY(this.getRealY() + yy);
		}
			
	}
	
	private boolean isPosiblePosition(double xx, double yy){
		return this.getScene().getMapManager().isPosiblePosition(xx, yy);
	}

	private boolean isPosibleYMove(double yy) {
		return (isPosiblePosition(this.borderLeft(), this.borderBottom() + yy) &&
				isPosiblePosition(this.borderLeft(), this.relCenterY() + yy ) &&
				isPosiblePosition(this.borderRight(), this.borderBottom() + yy) &&
				isPosiblePosition(this.borderRight(), this.relCenterY() + yy ));
	}

	private boolean isPosibleXMove( double xx) {
		return (isPosiblePosition(this.borderLeft() + xx, this.borderBottom()) && 
				isPosiblePosition(this.borderRight() + xx , this.borderBottom()) && 
				isPosiblePosition(this.borderLeft() + xx, this.relCenterY()) && 
				isPosiblePosition(this.borderRight() + xx , this.relCenterY()));
	}

	@Override
	public void initCollidableBehavior() {
		this.addColidableShape(new CollidableCircle(this, 18, 18, 20));		
	}
	
	public void setShootingState(){
		super.setShotingState();
		currentShootState = shootingState;
	}
	
	public void setNotShootingState(){
		super.setNotShootingState();
		currentShootState = notShootingState;
	}

	
	
	
}