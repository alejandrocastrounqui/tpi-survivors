package ar.edu.unq.ts.collidables;

import com.uqbar.vainilla.colissions.CollisionDetector;

public class CollidableCircle extends CollidableShape {

	public int ratio;
	
	public CollidableCircle(ICollidable owner, double desX, double desY, int ratio) {
		super(owner, desX, desY);
		this.ratio = ratio;
	}
	
	public boolean collidesWith(CollidableShape cs) {
		return cs.collidesWithCircle(this);
	}	
	
	public int getRatio() {
		return ratio;
	}

	@Override
	public boolean collidesWithCircle(CollidableCircle cs){
		return CollisionDetector.INSTANCE.collidesCircleAgainstCircle(getX(), getY(), getRatio(), cs.getX(), cs.getY(), cs.getRatio());
				
	}
	
	
}
