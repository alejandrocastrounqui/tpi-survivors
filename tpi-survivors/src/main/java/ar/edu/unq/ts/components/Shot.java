package ar.edu.unq.ts.components;

import java.awt.Color;

import ar.edu.unq.ts.collidables.Collidable;
import ar.edu.unq.ts.collidables.CollidableCircle;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Circle;

public class Shot extends Collidable{
	private static final double SPEED = 400;
	private static final int RADIO = 5;
	public double xMove;
	public double yMove;
	
	public Shot(double x, double y, double xMoveShip, double yMoveShip) {
		super(x, y);
		this.initialize(xMoveShip, yMoveShip);
	}
	
	private void initialize(double xMoveShip, double yMoveShip) {
		this.setAppearance(new Circle(Color.BLACK, RADIO));
		this.xMove = xMoveShip ;
		this.yMove = yMoveShip ;
		double hipotenuse = Math.sqrt(xMove * xMove + yMove * yMove);
		xMove = xMove / hipotenuse * SPEED;
		yMove = yMove / hipotenuse * SPEED;
	}

	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		move(xMove * deltaState.getDelta(), yMove * deltaState.getDelta() );
	}

	@Override
	public void initCollidableBehavior() {
		this.addColidableShape(new CollidableCircle(this, 1, 1, RADIO));		
	}

	@Override
	public double getHeight() {
		return RADIO * 2;
	}

	@Override
	public double getWidth() {
		return RADIO * 2;
	}
	
}
