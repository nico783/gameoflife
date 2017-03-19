package generics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generics.controller.Controller;

public class StopActionListener implements ActionListener {
	
	Controller controller;
	
	View vue;

	public StopActionListener(Controller controller, View vue) {
		super();
		this.controller = controller;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.stop();
		vue.activerGo();
	}

}
