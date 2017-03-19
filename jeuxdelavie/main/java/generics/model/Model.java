package generics.model;

import generics.cellule.Cellule;

public interface Model {

	int getNombreLignes();

	int getNombreColonnes();

	Cellule getCellule(int i, int j);

	Cellule[][] getCellules();

}