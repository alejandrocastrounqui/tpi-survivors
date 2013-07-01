package ar.edu.unq.ts.components.moving;

import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;

public class MovingToBottom extends MovingVertical {

    public static MovingVertical instancia;
	
	public static MovingVertical getInstance(){
		if(instancia == null){
			instancia = new MovingToBottom();
		}
		return instancia;
	}

	@Override
	public void updateV(MovableComponent componente, DeltaState deltaState) {
		if(!releaseVAt(KEY_DOWN, deltaState, componente)){		
			super.checkTop(componente, deltaState);
			componente.hMovingState.updateToBottom(componente, deltaState);	
		}
		else{
			if(deltaState.isKeyBeingHold(KEY_UP)){
				componente.setTopEstado();
			}
		}
	}
	
}
