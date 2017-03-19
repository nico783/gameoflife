package generics.controller;

import generics.cellule.Cellule;
import generics.model.Model;
import generics.view.View;

public interface Controller {

	void change(Cellule cellule);

	void faireEvoluer(Model model);

	String getDescription();

	String getTitre();

}