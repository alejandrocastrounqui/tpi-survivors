package ar.edu.unq.ts.components.moving;


import ar.edu.unq.ts.components.abstracts.MovableComponent;

import com.uqbar.vainilla.DeltaState;

public class MovingToLeft extends MovingHorizontal {
	
	public static MovingHorizontal instancia;
	
	public static MovingHorizontal getInstance(){
		if(instancia == null){
			instancia = new MovingToLeft();
		}
		return instancia;
	}

	@Override
	public void updateH(MovableComponent componente, DeltaState deltaState) {
		update(componente, deltaState, -super.getDesp(componente, deltaState), 0);		
	}

	private void update(MovableComponent componente, DeltaState deltaState, double xx, double yy) {
		if(!releaseHAt(KEY_LEFT, deltaState, componente)){
			componente.move(xx, yy);		
			super.checkRight(componente, deltaState);
		}
		else{
			if(deltaState.isKeyBeingHold(KEY_RIGHT)){
				componente.setRightEstado();
			}
		}
	}

	@Override
	public void updateToTop(MovableComponent componente, DeltaState deltaState) {
		update(componente, deltaState, -super.getDespDiagonal(componente, deltaState), -super.getDespDiagonal(componente, deltaState));	
	}
	
	@Override
	public void updateToBottom(MovableComponent componente, DeltaState deltaState) {
		update(componente, deltaState, -super.getDespDiagonal(componente, deltaState), super.getDespDiagonal(componente, deltaState));	
	}
	



}
