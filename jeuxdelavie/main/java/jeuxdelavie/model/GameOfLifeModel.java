package jeuxdelavie.model;

import generics.cellule.Cellule;
import generics.model.Model;
import jeuxdelavie.cellule.GameOfLifeCellule;

public class GameOfLifeModel implements Model {

	private GameOfLifeCellule[][] cellules;
	private int largeur;
	private int hauteur;

	public GameOfLifeModel(int hauteur, int largeur) {
		super();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.cellules = new GameOfLifeCellule[hauteur][largeur];

		// Création des cellules dans le tableau
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				Integer[] position = new Integer[2];
				position[0]=i;
				position[1]=j;
				cellules[i][j] = new GameOfLifeCellule(position);
			}
		}
	}

	@Override
	public GameOfLifeCellule getCellule(int i, int j) {
		return cellules[i][j];
	}

	@Override
	public int getNombreLignes() {
		return hauteur;
	}

	@Override
	public int getNombreColonnes() {
		return largeur;
	}

	@Override
	public GameOfLifeCellule[][] getCellules() {
		return cellules;
	}

}
