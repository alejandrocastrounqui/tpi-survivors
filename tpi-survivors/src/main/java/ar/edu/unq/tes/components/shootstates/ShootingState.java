package ar.edu.unq.tes.components.shootstates;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.MouseButton;

import ar.edu.unq.ts.components.Shooter;

public class ShootingState extends ShootState {

	private double deltaAnimation = 0.1;
	private double countDeltaAnimation = 0.0;

	@Override
	public void update(DeltaState deltaState, Shooter shooter) {
		if(deltaState.isMouseButtonReleased(MouseButton.LEFT)){
			shooter.setNotShootingState();
		}
		else{
			countDeltaAnimation += deltaState.getDelta();
		    if(countDeltaAnimation > deltaAnimation){
		    	countDeltaAnimation -= deltaAnimation;
		    	shooter.shootOctoDiagonal();
		    }
		}
	}

}
