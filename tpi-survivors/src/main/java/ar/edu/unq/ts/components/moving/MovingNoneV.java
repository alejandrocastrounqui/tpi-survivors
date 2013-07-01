package ar.edu.unq.ts.components.moving;

import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;

public class MovingNoneV extends MovingVertical {

    public static MovingVertical instancia;
	
	public static MovingVertical getInstance(){
		if(instancia == null){
			instancia = new MovingNoneV();
		}
		return instancia;
	}
	
	@Override
	public void updateV(MovableComponent componente, DeltaState deltaState) {
		super.checkTop(componente, deltaState);
		super.checkBottom(componente, deltaState);
		componente.hMovingState.updateH(componente, deltaState);
	}
	
	@Override
	public void confirmMovingState(MovableComponent movableComponent) {
		movableComponent.setStoping();
	}


}
