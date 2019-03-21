package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ControladaPorVoz;
import model.ThreadVoz;
import view.TelaColorida;

public class TelaColoridaController implements ActionListener, ControladaPorVoz{
	public TelaColorida tela;
	public JButton btnLigaVoz;
	public JPanel container;
	
	public TelaColoridaController(TelaColorida tela, JButton btnLigaVoz, JPanel container){
		this.tela = tela;
		this.btnLigaVoz = btnLigaVoz;
		this.container = container;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mudarCor();
	}
	
	public void mudarCor() {
		btnLigaVoz.setText("Carregando...");
		ThreadVoz threadVoz = new ThreadVoz(this, btnLigaVoz);
		threadVoz.execute();
	}
	
	@Override
	public void executaComandoPorVoz(String oQueFoiFalado) {
		if(oQueFoiFalado.equals("change color to blue"))
			container.setBackground(new Color(0, 0, 255));
		else
		if(oQueFoiFalado.equals("change color to red"))
			container.setBackground(new Color(255, 0, 0));
		else
		if(oQueFoiFalado.equals("change color to green"))
			container.setBackground(new Color(0, 255, 0));
	}

}
