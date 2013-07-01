package ar.edu.unq.ts.application;

import java.awt.Dimension;

import ar.edu.unq.ts.scenes.ShooterLevelScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

public class TSGame extends Game {
	
	public TSGame() {
		super();
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(800, 600);
	}

	@Override
	public String getTitle() {
		return "TPI Survivors";
	}

	@Override
	protected void initializeResources() {
	}

	@Override
	protected void setUpScenes() {
		ShooterLevelScene scene = new ShooterLevelScene();
		this.setCurrentScene(scene);
		scene.initialize();
	}

	public static void main(String[] args) {
		new DesktopGameLauncher(new TSGame()).launch();
	}
}