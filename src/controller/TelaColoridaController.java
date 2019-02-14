package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ThreadVoz;
import view.TelaColorida;

public class TelaColoridaController implements ActionListener{
	private TelaColorida tela;
	private JButton btnLigaVoz;
	private JPanel container;
	
	public TelaColoridaController(TelaColorida tela, JButton btnLigaVoz, JPanel container){
		this.tela = tela;
		this.btnLigaVoz = btnLigaVoz;
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		mudarCor();
	}
	
	public void mudarCor() {
		ThreadVoz threadVoz = new ThreadVoz(btnLigaVoz);
		threadVoz.start();
		try {
			threadVoz.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ThreadVoz.resultadoDoReconhecedor);
		System.out.println("**** CABOU ****");
	}

}
