package ar.edu.unq.ts.components.moving;

import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;


public abstract class MovingVertical extends MovingState {
	
    public abstract void updateV(MovableComponent componente, DeltaState deltaState);
    
	public boolean releaseVAt(Key key, DeltaState deltaState, MovableComponent componente){
		boolean isReleased = deltaState.isKeyReleased(key);
		if(isReleased){
			componente.setNoneEstadoV();
		}
		return isReleased;
	}

}
