package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ThreadVoz;
import view.TelaColorida;

public class TelaColoridaController implements ActionListener /*extends alguma_abstrata*/{
	public TelaColorida tela;
	public JButton btnLigaVoz;
	public JPanel container;
	
	public TelaColoridaController(TelaColorida tela, JButton btnLigaVoz, JPanel container){
		this.tela = tela;
		this.btnLigaVoz = btnLigaVoz;
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		mudarCor();
	}
	
	public void mudarCor() {
		btnLigaVoz.setText("Carregando...");
		ThreadVoz threadVoz = new ThreadVoz(this, btnLigaVoz);
		threadVoz.execute();
	}
	
	public void executaComandoPorVoz(String oQueFoiFalado) {
		container.setBackground(new Color(50, 121, 255));
	}

}
