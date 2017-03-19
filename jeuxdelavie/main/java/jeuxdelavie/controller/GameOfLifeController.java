package jeuxdelavie.controller;

import java.util.ArrayList;
import java.util.List;

import com.rits.cloning.Cloner;

import generics.cellule.Cellule;
import generics.controller.Controller;
import generics.model.Model;
import generics.view.View;
import jeuxdelavie.cellule.GameOfLifeCellule;

public class GameOfLifeController implements Controller {

	/**
	 * Durée en milliseconde entre chaque pas d'évolution.
	 */
	protected static final long TIME_BETWEEN_STEP = 500;

	private boolean continuer;

	private Cloner cloner = new Cloner();

	@Override
	public void change(Cellule cellule) {
		cellule.change();
	}

	@Override
	public void faireEvoluer(Model model, View vue) throws InterruptedException {

		continuer = true;
		while (continuer) {

			Model modelInitial = cloner.deepClone(model);

			for (int i = 0; i < modelInitial.getNombreLignes(); i++) {
				for (int j = 0; j < modelInitial.getNombreColonnes(); j++) {
					faireEvoluer(model.getCellule(i, j), modelInitial);
					System.out.println("Traitement de la cellule (" + i + ", " + j + ")");
				}
			}
			vue.update();
			Thread.sleep(TIME_BETWEEN_STEP);
			// continuer = false;
			// vue.activerGo();
		}
	}

	void faireEvoluer(Cellule cellule, Model model) {

		if (getNombreCellulesVoisinesVivantes(cellule, model) == 3 && cellule.isMorte()) {
			cellule.change();
		} else if ((getNombreCellulesVoisinesVivantes(cellule, model) < 2
				|| getNombreCellulesVoisinesVivantes(cellule, model) > 3) && cellule.isVivante()) {
			cellule.change();
		}

	}

	int getNombreCellulesVoisinesVivantes(Cellule cellule, Model model) {
		int nombreCellulesVoisinesVivantes = 0;
		for (Cellule c : getCellulesVoisines(cellule, model)) {
			if (c.isVivante()) {
				nombreCellulesVoisinesVivantes++;
			}
		}
		return nombreCellulesVoisinesVivantes;
	}

	List<Cellule> getCellulesVoisines(Cellule cellule, Model model) {

		Cellule[][] cellulesInitiales = model.getCellules();

		int nombreLignes = model.getNombreLignes();
		int nombreColonnes = model.getNombreColonnes();

		List<Cellule> voisines = new ArrayList<>();
		int i = cellule.getPosition()[0];
		int j = cellule.getPosition()[1];

		if (i > 0 && j > 0)
			voisines.add(cellulesInitiales[i - 1][j - 1]);

		if (j > 0) {
			voisines.add(cellulesInitiales[i][j - 1]);
			if (i < nombreLignes - 1)
				voisines.add(cellulesInitiales[i + 1][j - 1]);
		}

		if (i < nombreLignes - 1) {
			voisines.add(cellulesInitiales[i + 1][j]);

			if (j < nombreColonnes - 1 && i < nombreLignes - 1) {
				voisines.add(cellulesInitiales[i + 1][j + 1]);
			}
		}

		if (j < nombreColonnes - 1) {
			voisines.add(cellulesInitiales[i][j + 1]);
		}

		if (i > 0) {
			if (j < nombreColonnes - 1) {
				voisines.add(cellulesInitiales[i - 1][j + 1]);
			}
			voisines.add(cellulesInitiales[i - 1][j]);
		}

		return voisines;
	}

	@Override
	public void stop() {
		continuer = false;
	}

	@Override
	public String getDescription() {
		return "Jeux de la vie de Conway";
	}

	@Override
	public String getTitre() {
		return "Jeux de la vie";
	}

}
