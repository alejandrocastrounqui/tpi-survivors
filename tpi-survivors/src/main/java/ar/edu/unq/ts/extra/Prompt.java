package ar.edu.unq.ts.extra;

import java.awt.Color;
import java.awt.Font;

import ar.edu.unq.ts.scenes.ShooterLevelScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

public class Prompt extends GameComponent<ShooterLevelScene> {
	
	private Label texto;

	public Prompt(double x, double y) {
		super(x, y);
		Font fuente = new Font(Font.SERIF, Font.BOLD, 20);
		this.texto = new Label(fuente, Color.BLUE, "");
		this.setAppearance(texto);
	}

	public void setText(String texto){
		this.texto.setText(texto);
	}
}
