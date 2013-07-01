package ar.edu.unq.ts.components;

import java.awt.Color;
import java.awt.geom.Point2D.Double;

import ar.edu.unq.ts.application.TSGameComponent;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;

public class Mira extends TSGameComponent{

	public Mira(double x, double y) {
		super(x, y);
		this.setAppearance(new Rectangle(Color.BLACK, 5, 5));
		this.setAppearance(Sprite.fromImage("/images/mira.png"));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
	    this.setPosition(deltaState.getCurrentMousePosition());
	}

	private void setPosition(Double currentMousePosition) {
		//se resta 24 para centrar la imagen de la mira
		this.setX(currentMousePosition.getX() + this.getScene().getCamera().getX() -24);
		this.setY(currentMousePosition.getY() + this.getScene().getCamera().getY() -24);
	}

}
