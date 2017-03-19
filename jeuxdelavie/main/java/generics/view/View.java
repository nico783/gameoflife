package generics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import generics.controller.Controller;
import generics.model.Model;

public class View {

	private Model model;
	private Controller controller;

	private CelluleView[][] damier;

	private JButton buttonGo;
	private JButton buttonStop;
	private Boolean continuer;

	public View(Model model, Controller controller) {
		super();
		this.controller = controller;
		this.model = model;
	}

	public void affichage() {

		/*
		 * Damier
		 */
		Border blackline = BorderFactory.createLineBorder(Color.black, 1);
		int nombreLignes = model.getNombreLignes();
		int nombreColonnes = model.getNombreColonnes();
		JPanel pan = new JPanel(new GridLayout(nombreLignes, nombreColonnes));
		damier = new CelluleView[nombreLignes][nombreColonnes];
		for (int j = 0; j < nombreColonnes; j++) {
			for (int i = 0; i < nombreLignes; i++) {
				CelluleView cell = new CelluleView(i, j);
				damier[i][j] = cell;
				cell.setBorder(blackline);
				cell.addMouseListener(cell);
				pan.add(cell);
			}
		}

		/*
		 * Boutons
		 */
		buttonGo = new JButton("GO");
		buttonGo.addActionListener(new GoActionListener(controller, model, this));

		buttonStop = new JButton("STOP");
		buttonStop.addActionListener(new StopActionListener(this));

		JPanel panneauButton = new JPanel();
		panneauButton.add(buttonGo);
		panneauButton.add(buttonStop);

		/*
		 * Description
		 */
		JPanel panneauDescription = new JPanel();
		panneauDescription.add(getDescription());

		/*
		 * Frame
		 */
		JFrame cadre = new JFrame();
		cadre.setTitle(controller.getTitre());
		cadre.setSize(800, 600);
		cadre.setLocationRelativeTo(null);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cadre.getContentPane().setLayout(new BorderLayout());
		cadre.getContentPane().add(BorderLayout.SOUTH, panneauButton);
		cadre.getContentPane().add(BorderLayout.NORTH, panneauDescription);
		cadre.getContentPane().add(BorderLayout.CENTER, pan);
		cadre.setVisible(true);

	}

	public void update() {
		for (int i = 0; i < model.getNombreLignes(); i++) {
			for (int j = 0; j < model.getNombreColonnes(); j++) {
				damier[i][j].setBackground(model.getCellule(i, j).getColor());
			}
		}
	}

	private JTextArea getDescription() {
		StringBuilder sb = new StringBuilder(controller.getDescription());
		JTextArea description = new JTextArea(sb.toString());
		description.setEditable(false);
		description.setEnabled(false);
		return description;
	}

	/**
	 * Méthode permettant de désactiver le bouton GO
	 */
	public void desactiverGo() {
		buttonGo.setEnabled(false);
	}

	/**
	 * Méthode permettant d'activer le bouton GO
	 */
	public void activerGo() {
		buttonGo.setEnabled(true);
	}

	/**
	 * 
	 * @author nicolasbenizri
	 *
	 */
	private class CelluleView extends JPanel implements MouseListener {

		private static final long serialVersionUID = 3495721580719357232L;
		private int abscisse;
		private int ordonnee;

		public CelluleView(int abscisse, int ordonnee) {
			super();
			this.abscisse = abscisse;
			this.ordonnee = ordonnee;
			this.setBackground(model.getCellule(abscisse, ordonnee).getColor());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			controller.change(model.getCellule(abscisse, ordonnee));
			this.setBackground(model.getCellule(abscisse, ordonnee).getColor());
			this.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Pas d'implementation
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// Pas d'implementation
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Pas d'implementation
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Pas d'implementation
		}

	}

	public void setContinuer(boolean continuer) {
		this.continuer = continuer;
	}

	public boolean isContinuer() {
		return continuer;
	}

}
