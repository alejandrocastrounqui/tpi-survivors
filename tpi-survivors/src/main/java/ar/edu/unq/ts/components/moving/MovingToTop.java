package ar.edu.unq.ts.components.moving;

import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;

public class MovingToTop extends MovingVertical {

    public static MovingVertical instancia;
	
	public static MovingVertical getInstance(){
		if(instancia == null){
			instancia = new MovingToTop();
		}
		return instancia;
	}

	@Override
	public void updateV(MovableComponent componente, DeltaState deltaState) {
		if(!releaseVAt(KEY_UP, deltaState, componente)){
			super.checkBottom(componente, deltaState);
			componente.hMovingState.updateToTop(componente, deltaState);			
		}
		else{
			if(deltaState.isKeyBeingHold(KEY_DOWN)){
				componente.setBottomEstado();
			}
		}
	}
	
}
