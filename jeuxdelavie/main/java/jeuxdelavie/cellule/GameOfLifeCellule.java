package jeuxdelavie.cellule;

import java.awt.Color;
import java.util.Arrays;

import generics.cellule.Cellule;

public class GameOfLifeCellule implements Cellule {

	private Etat etat;

	private Integer[] position;

	public GameOfLifeCellule(Integer[] position) {
		super();
		this.etat = Etat.VIVANT;
		this.position = position;
	}

	@Override
	public void change() {
		if (Etat.VIVANT.equals(this.etat)) {
			this.etat = Etat.MORT;
		} else if (Etat.MORT.equals(this.etat)) {
			this.etat = Etat.VIVANT;
		}
	}

	@Override
	public boolean isVivante() {
		return Etat.VIVANT.equals(this.etat);
	}

	@Override
	public boolean isMorte() {
		return Etat.MORT.equals(this.etat);
	}

	@Override
	public Integer[] getPosition() {
		return position;
	}

	@Override
	public Color getColor() {
		if (this.isMorte()) {
			return Color.WHITE;
		} else if (this.isVivante()) {
			return Color.GREEN;
		} else {
			throw new RuntimeException("Les cellules sont soit mortes soit vivantes !");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + Arrays.hashCode(position);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameOfLifeCellule other = (GameOfLifeCellule) obj;
		if (etat != other.etat)
			return false;
		if (!Arrays.equals(position, other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cellule [etat=" + etat + "]";
	}

}
