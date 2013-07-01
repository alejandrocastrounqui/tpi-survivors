package ar.edu.unq.ts.components.moving;


import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public abstract class MovingState {
	
	protected final Key KEY_DOWN  = Key.S;
	protected final Key KEY_UP    = Key.W;
	protected final Key KEY_LEFT  = Key.A;
	protected final Key KEY_RIGHT = Key.D;
	protected final Key KEY_SHOT  = Key.SPACE;
	

    
    public void checkLeft(MovableComponent componente, DeltaState deltaState){
    	if(deltaState.isKeyPressed(KEY_LEFT)){
    		componente.setLeftEstado();
		}
    }
    
    public void checkRight(MovableComponent componente, DeltaState deltaState){
    	if(deltaState.isKeyPressed(KEY_RIGHT)){
    		componente.setRightEstado();
		}
    }

    
    public void checkTop(MovableComponent componente, DeltaState deltaState) {
    	if(deltaState.isKeyPressed(KEY_UP)){
    		componente.setTopEstado();
		}
    }
    
    public void checkBottom(MovableComponent componente, DeltaState deltaState) {
    	if(deltaState.isKeyPressed(KEY_DOWN)){
    		componente.setBottomEstado();
		}
    }


	public double getDesp(MovableComponent componente, DeltaState deltaState) {
		return componente.getSpeed()*deltaState.getDelta();
	}
	

	public double getDespDiagonal(MovableComponent componente,	DeltaState deltaState) {
		return componente.getSpeedDiagonal()*deltaState.getDelta();
	}
	

	public void confirmMovingState(MovableComponent movableComponent) {
		// Nothing here		
	}
}

