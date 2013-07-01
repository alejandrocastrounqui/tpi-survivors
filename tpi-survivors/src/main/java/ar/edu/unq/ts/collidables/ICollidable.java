package ar.edu.unq.ts.collidables;

import java.util.List;


public interface ICollidable {
	
	public boolean collidesWith(ICollidable collidable);	
	public double getX();
	public double getY();	
	public void addColidableShape(CollidableShape shape);	
	public List<CollidableShape> getCollidablesShapes();
	public void initCollidableBehavior();

}
