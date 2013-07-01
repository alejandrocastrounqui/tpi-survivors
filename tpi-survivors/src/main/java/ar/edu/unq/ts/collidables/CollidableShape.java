package ar.edu.unq.ts.collidables;

import java.util.List;


public abstract class CollidableShape {	
	

	public ICollidable owner;
	public double desX;
	public double desY;	
	
	public CollidableShape(ICollidable owner, double desX, double desY) {
		this.owner = owner;
		this.desX = desX;
		this.desY = desY;
	}

	public boolean collidesWith(List<CollidableShape> collidablesShapes) {
		for (CollidableShape collidableShape : collidablesShapes) {
			if(this.collidesWith(collidableShape)){
				return true;
			}
		}
		return false;
	}

	public abstract boolean collidesWith(CollidableShape cs);
	

	public double getX() {
		return desX + this.owner.getX();
	}
	
	public double getY() {
		return desY + this.owner.getY();
	}

	public abstract boolean collidesWithCircle(CollidableCircle collidableCircle);


}
