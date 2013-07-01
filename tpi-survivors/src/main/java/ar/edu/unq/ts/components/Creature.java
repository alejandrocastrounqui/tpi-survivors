package ar.edu.unq.ts.components;

import java.awt.Color;

import ar.edu.unq.ts.application.TSGameComponent;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;

public class Creature extends TSGameComponent {
	public static final int DEFAULT_SIZE = 20;
	private Color color = Color.GREEN;

	public Creature(double x, double y) {
		super(x, y);
		this.setAppearance(new Rectangle(this.color, 30, 30));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
	}
}