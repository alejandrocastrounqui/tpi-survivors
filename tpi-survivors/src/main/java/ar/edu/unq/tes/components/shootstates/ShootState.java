package ar.edu.unq.tes.components.shootstates;

import ar.edu.unq.ts.components.Shooter;

import com.uqbar.vainilla.DeltaState;

public abstract class ShootState {	

	public abstract void update(DeltaState deltaState, Shooter shooter);
	
}
