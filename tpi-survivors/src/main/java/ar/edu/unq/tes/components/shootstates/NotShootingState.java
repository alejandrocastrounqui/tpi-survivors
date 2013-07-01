package ar.edu.unq.tes.components.shootstates;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.MouseButton;

import ar.edu.unq.ts.components.Shooter;

public class NotShootingState extends ShootState {



	@Override
	public void update(DeltaState deltaState, Shooter shooter) {
		if(deltaState.isMouseButtonPressed(MouseButton.LEFT)){
			shooter.setShootingState();
	    	shooter.shootOctoDiagonal();
		}
	}

}
