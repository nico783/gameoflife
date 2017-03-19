package generics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import generics.controller.Controller;
import generics.model.Model;

public class GoActionListener implements ActionListener {

	/**
	 * Durée en milliseconde entre chaque pas d'évolution.
	 */
	protected static final long TIME_BETWEEN_STEP = 500;

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
		vue.setContinuer(true);
		SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {

				while (vue.isContinuer()) {

					controller.faireEvoluer(model);

					vue.update();
					Thread.sleep(TIME_BETWEEN_STEP);

					// vue.setContinuer(false);
					// vue.activerGo();

				}

				return null;
			}
		};
		sw.execute();
		vue.desactiverGo();
	}

}
