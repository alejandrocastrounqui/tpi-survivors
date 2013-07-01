package ar.edu.unq.ts.components;

import java.awt.Color;

import com.uqbar.vainilla.appearances.Circle;

import ar.edu.unq.ts.application.TSGameComponent;

public class TestPoint extends TSGameComponent {

	public TestPoint(double x, double y) {
		super(x, y);
        this.setAppearance(new Circle(Color.BLACK, 10));
	}

}
