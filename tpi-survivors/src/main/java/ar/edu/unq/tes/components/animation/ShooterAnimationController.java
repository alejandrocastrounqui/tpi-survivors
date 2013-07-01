package ar.edu.unq.tes.components.animation;

import ar.edu.unq.ts.components.abstracts.SightObserver;
import ar.edu.unq.ts.extra.Direction;

import com.uqbar.vainilla.DeltaState;

public class ShooterAnimationController implements IAnimationObserver {
	
	private double deltaAnimation = 0.1;
	private double countDeltaAnimation = 0.0;
	
	private boolean isShoting;
	private boolean isMoving;
	
	private AnimStateGetter currentAnimGetter;
	
	private AnimStateGetter stopAnimGetter;
	private AnimStateGetter moveAnimGetter;
	private AnimStateGetter shootStopingAnimGetter;
	private AnimStateGetter shootMovingAnimGetter;
	
	private ShooterAnimationState currentAnimState;
	private Direction direction;
	
	public ShooterAnimationController(SightObserver owner) {
		this.initialize(owner);
	}

	private void initialize(SightObserver owner) {
		this.isShoting = false;
		this.isMoving = false;
		this.direction = Direction.SUR;
		String spritePath = "/images/shoter/";
		this.stopAnimGetter = new AnimStateGetter(owner, spritePath , 5, 1);
		this.moveAnimGetter = new AnimStateGetter(owner, spritePath , 2, 4);
		this.shootStopingAnimGetter = new AnimStateGetter(owner, spritePath , 0, 2);
		this.shootMovingAnimGetter = new AnimStateGetter(owner, spritePath , 0, 3);
		this.currentAnimGetter = this.stopAnimGetter;
		setCurrenAnimState();
	}

	private void setCurrenAnimState() {
		this.currentAnimState = this.currentAnimGetter.getAnimState(direction.getIndex());
	}

	public void notifyDirection(Direction direction) {
		this.direction = direction;		
		setCurrenAnimState();
	}

	public void update(DeltaState delta) {
		countDeltaAnimation += delta.getDelta();
		if(countDeltaAnimation > deltaAnimation){
			countDeltaAnimation -= deltaAnimation;
			currentAnimState.step();
		}
	}

	public void setStopState() {
		this.isMoving = false;
		if(isShoting){			
			this.currentAnimGetter = this.shootStopingAnimGetter;
		}
		else{
			this.currentAnimGetter = this.stopAnimGetter;		
		}
		setCurrenAnimState();	
	}

	public void setMovingState(){
		this.isMoving = true;
		if(isShoting){			
			this.currentAnimGetter = this.shootMovingAnimGetter;			
		}
		else{
			this.currentAnimGetter = this.moveAnimGetter;	
		}		
		setCurrenAnimState();	
	}
	
	public void beeginShot(){
		this.isShoting = true;
		if(isMoving){			
			this.currentAnimGetter = this.shootMovingAnimGetter;			
		}
		else{
			this.currentAnimGetter = this.shootStopingAnimGetter;	
		}			
		setCurrenAnimState();
	}

	public void stopShot() {
		this.isShoting = false;
		if(isMoving){			
			this.currentAnimGetter = this.moveAnimGetter;			
		}
		else{
			this.currentAnimGetter = this.stopAnimGetter;	
		}			
		setCurrenAnimState();		
	}
	
	

}
