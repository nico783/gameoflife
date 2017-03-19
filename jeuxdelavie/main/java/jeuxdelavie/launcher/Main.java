package jeuxdelavie.launcher;

import generics.controller.Controller;
import generics.model.Model;
import generics.view.View;
import jeuxdelavie.controller.GameOfLifeController;
import jeuxdelavie.model.GameOfLifeModel;

public class Main {

	public static void main(String[] args) {
		int largeur = 20;
		int hauteur = 20;

		// A adapter en foncion de l'automate voulu.
		Model model = new GameOfLifeModel(hauteur, largeur);
		Controller controller = new GameOfLifeController();
		
		// Generique, ne change pas.
		View vue = new View(model, controller);
		vue.affichage();
	}

}
