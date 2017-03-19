package generics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import generics.controller.Controller;
import generics.model.Model;
import jeuxdelavie.model.GameOfLifeModel;

public class GoActionListener implements ActionListener {

	Controller controller;
	Model model;
	View vue;

	public GoActionListener(Controller controller, Model model, View vue) {
		super();
		this.controller = controller;
		this.model = model;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				controller.faireEvoluer(model, vue);
				return null;
			}
		};
		sw.execute();
		vue.desactiverGo();
	}

}
