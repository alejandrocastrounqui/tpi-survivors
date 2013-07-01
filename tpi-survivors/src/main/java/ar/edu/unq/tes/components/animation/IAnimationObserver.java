package ar.edu.unq.tes.components.animation;

import com.uqbar.vainilla.DeltaState;

import ar.edu.unq.ts.extra.Direction;

public interface IAnimationObserver {	
	public void notifyDirection(Direction direction);	
	public void update(DeltaState delta);
	public void setStopState();
	public void setMovingState();
	public void beeginShot();
	public void stopShot();
}
