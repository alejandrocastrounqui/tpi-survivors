package ar.edu.unq.ts.components.moving;


import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;

public class MovingNoneH extends MovingHorizontal {

	public static MovingHorizontal instancia;
	
	public static MovingHorizontal getInstance(){
		if(instancia == null){
			instancia = new MovingNoneH();
		}
		return instancia;
	}
	
	@Override
	public void updateH(MovableComponent componente, DeltaState deltaState) {
		super.checkRight(componente, deltaState);
		super.checkLeft(componente, deltaState);
	}

	@Override
	public void updateToTop(MovableComponent componente, DeltaState deltaState) {
		componente.move(0, -super.getDesp(componente, deltaState));
		updateH(componente, deltaState);		
	}
	
	@Override
	public void updateToBottom(MovableComponent componente, DeltaState deltaState) {
		componente.move(0, super.getDesp(componente, deltaState));
		updateH(componente, deltaState);		
	}
	

	@Override
	public void confirmMovingState(MovableComponent movableComponent) {
		movableComponent.setStoping();
	}

}
