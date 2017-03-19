package generics.cellule;

import java.awt.Color;

public interface Cellule {

	Color getColor();

	void change();

	Integer[] getPosition();

	boolean isVivante();

	boolean isMorte();

}