package ar.edu.unq.ts.application;

import ar.edu.unq.ts.scenes.ShooterLevelScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class TSGameComponent extends GameComponent<ShooterLevelScene> {

	public TSGameComponent(double x, double y) {
		super(x,y);
	}
	
	public TSGameComponent(Sprite sprite,  double x, double y) {
		super(x,y);
		this.setAppearance(sprite);
	}

	@Override
	public double getX() {
		return super.getX() - this.getScene().getCamera().getX();
	}

	@Override
	public double getY() {
		return super.getY() - this.getScene().getCamera().getY();
	}
	
	public double getRealX(){
		return super.getX();
	}
	
	public double getRealY(){
		return super.getY();
	}
	
	
}
