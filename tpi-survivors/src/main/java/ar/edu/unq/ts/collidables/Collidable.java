package ar.edu.unq.ts.collidables;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unq.ts.components.abstracts.PlaceableComponent;

public abstract class Collidable extends PlaceableComponent implements ICollidable{
	
	private List<CollidableShape> collidables;	
	
	public Collidable(double x, double y) {
		super(x, y);
		collidables = new LinkedList<CollidableShape>();
		this.initCollidableBehavior();
	}

	public void addColidableShape(CollidableShape shape) {
		this.collidables.add(shape);		
	}

	public List<CollidableShape> getCollidablesShapes() {
		return this.collidables;
	}

	public boolean collidesWith(ICollidable collidable) {
		for (CollidableShape collidableShape : getCollidablesShapes()) {
			if(collidableShape.collidesWith(collidable.getCollidablesShapes())){
				return true;
			}
		}		
		return false;
	}

	public abstract void initCollidableBehavior();

}
