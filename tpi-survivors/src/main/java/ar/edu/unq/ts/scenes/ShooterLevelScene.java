package ar.edu.unq.ts.scenes;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unq.tes.components.map.MapManager;
import ar.edu.unq.ts.camera.Camera;
import ar.edu.unq.ts.components.Mira;
import ar.edu.unq.ts.components.Shooter;
import ar.edu.unq.ts.components.Shot;
import ar.edu.unq.ts.extra.Prompt;

import com.uqbar.vainilla.GameScene;

public class ShooterLevelScene extends GameScene {
	
	private Camera camera;
	private Prompt prompt;
	private Shooter shooter;

	private List<Shot> shots;
	private MapManager mapManager;
	
	
	public ShooterLevelScene() {
		super();
		this.shots = new LinkedList<Shot>();
	}
	
	public void initialize() {
		this.camera = new Camera();
		this.shooter = new Shooter(300, 300);
		this.loadMapAndConfigureStage("level_1");
		this.addComponent(this.shooter);
		this.addComponent(new Mira(-100, -100));
		this.initializePrompt();
	}	
	
	private void loadMapAndConfigureStage(String mapPath) {
		this.mapManager = new MapManager();
		this.mapManager.load(mapPath, this);
		this.shooter.setX(mapManager.getXShooter());
		this.shooter.setY(mapManager.getYShooter());
	}

	//	private void initializeCreatures() {
	//		for (int i = 0; i < 800; i += 50) {
	//			for (int j = 0; j < 800; j += 50) {
	//				this.addComponent(new Creature(i, j));
	//			}
	//		}
	//	}

	private void initializePrompt() {
		double xPrompt = this.getGame().getDisplayHeight() - 50;
		this.prompt = new Prompt(50, xPrompt);
		this.addComponent(this.prompt);
	}

	public Camera getCamera() {
		return camera;
	}
	
	public void prompt(String texto){
		this.prompt.setText(texto);
	}
	
	public void addShot(Shot shot){
		this.shots.add(shot);
		this.addComponent(shot);
	}
	
	public void removeShot(Shot shot){
		this.shots.remove(shot);
		shot.setDestroyPending(true);
	}
	
	public void removeShots(List<Shot> removedShots){
		for (Shot shot : removedShots) {			
			this.removeShot(shot);
		}
	}
	
	public List<Shot> getShots() {
		return shots;
	}
	

	public MapManager getMapManager() {
		return mapManager;
	}
}
