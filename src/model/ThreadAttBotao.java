package model;

import javax.swing.JButton;
import javax.swing.SwingWorker;

public class ThreadAttBotao extends SwingWorker<Object, Object>{

	public JButton btn;
	
	public ThreadAttBotao(JButton btn) {
		this.btn = btn;
	}
	
	@Override
	protected Object doInBackground() throws Exception {
		btn.setText("Ouvindo...");
		System.out.println("Chegou aqui no swing");
		return null;
	}

}
