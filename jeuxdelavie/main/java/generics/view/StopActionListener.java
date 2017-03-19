package generics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import generics.controller.Controller;

public class StopActionListener implements ActionListener {
	
	private View vue;

	public StopActionListener(View vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vue.setContinuer(false);
		vue.activerGo();
	}
	
}
