package ar.edu.unq.ts.components.moving;

import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;


public abstract class MovingHorizontal extends MovingState {


    public abstract void updateH(MovableComponent componente, DeltaState deltaState);

	public boolean releaseHAt(Key key, DeltaState deltaState, MovableComponent componente){
		boolean isReleased = deltaState.isKeyReleased(key);
		if(isReleased){
			componente.setNoneEstadoH();
		}
		return isReleased;
	}

	public abstract void updateToTop(MovableComponent componente, DeltaState deltaState);

	public abstract void updateToBottom(MovableComponent componente, DeltaState deltaState);

}
