package ar.edu.unq.tes.components.animation;

import ar.edu.unq.ts.components.abstracts.SightObserver;

public class AnimStateGetter {

	
	public int SPRITEAMOUNT;
	

	private ShooterAnimationState[] animStates;
	
	public AnimStateGetter(SightObserver owner, String spritePath, int firstIndex, int imageAmount) {
		this.animStates = new ShooterAnimationState[8];
		for (int dirIndex = 0; dirIndex < animStates.length; dirIndex++) {
			animStates[dirIndex] = new ShooterAnimationState(owner, dirIndex, spritePath, firstIndex, imageAmount);
		}
	}

	

	public ShooterAnimationState getAnimState(int index) {
		return animStates[index];
	}
}
