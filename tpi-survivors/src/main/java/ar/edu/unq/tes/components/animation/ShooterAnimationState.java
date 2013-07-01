package ar.edu.unq.tes.components.animation;

import ar.edu.unq.ts.components.abstracts.SightObserver;

import com.uqbar.vainilla.appearances.Sprite;

public class ShooterAnimationState {

	private SightObserver owner;
	
	private Sprite[] sprites;
	
	private int spriteAmount;
	
	private int currentSprite;

	public ShooterAnimationState(SightObserver owner2, int dirIndex, String spritePath, int firstIndex, int imageAmount) {
		super();
		this.owner = owner2;
		this.initialize(dirIndex, spritePath, firstIndex, imageAmount);
	}

	private void initialize(int directionIndex, String spritePath, int firstIndex, int imageAmount) {
		this.spriteAmount = imageAmount;
		this.sprites = new Sprite[imageAmount];
		for (int i = 0; i < imageAmount; i++) {			
			String path = spritePath + "DIR-" + directionIndex + "/"+ (i+firstIndex) +".png";
			sprites[i] = Sprite.fromImage(path).scale(2.0);
		}
		currentSprite = 0;
	}
	

	public void step() {
		currentSprite ++;
		if(currentSprite >= spriteAmount){
			currentSprite = 0;
		}
		setOwnerSprite();
	}


	private void setOwnerSprite() {
		this.owner.setAppearance(this.sprites[currentSprite]);
	}
	
	
}
