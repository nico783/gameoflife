package generics.controller;

import generics.cellule.Cellule;
import generics.model.Model;
import generics.view.View;

public interface Controller {

	void change(Cellule cellule);

	void faireEvoluer(Model model, View vue) throws InterruptedException;

	void stop();

	String getDescription();

	String getTitre();

}