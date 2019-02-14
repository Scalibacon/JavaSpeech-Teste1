package model;

import java.io.IOException;

import javax.swing.JButton;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class ThreadVoz extends Thread{

	private LiveSpeechRecognizer reconhecedor;
	public static String resultadoDoReconhecedor;
	private boolean reconhecedorRodando = false;
	private JButton btnLigaVoz;
	
	public ThreadVoz(JButton btnLigaVoz) {
		this.btnLigaVoz = btnLigaVoz;
		Configuration configuracao = new Configuration();
		configuracao.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuracao.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuracao.setGrammarPath("resource:/grammars");
		configuracao.setGrammarName("grammar");
		configuracao.setUseGrammar(true);
		try {
			reconhecedor = new LiveSpeechRecognizer(configuracao);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciarReconhecedor() {
		if(reconhecedorRodando)
			System.out.println("Reconhecedor já foi iniciado");
		else {
			reconhecedorRodando = true;			
			reconhecedor.startRecognition(true);
			//btnLigaVoz.setText("Ouvindo...");
			ThreadAttBotao att = new ThreadAttBotao(btnLigaVoz);
			att.execute();
			System.out.println("Ouvindo...");
			
			try {
				while(reconhecedorRodando) {
					SpeechResult resultadoDaFala = reconhecedor.getResult();
					if (resultadoDaFala == null)
						System.out.println("Não consegui entender o que você falou :(");
					else {
						resultadoDoReconhecedor = resultadoDaFala.getHypothesis();
						System.out.println("Você disse '" + resultadoDoReconhecedor + "'");	
						reconhecedorRodando = false; //Depois verificar se irá sair antes da hora
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
				reconhecedorRodando = false;
			}
			System.out.println("Espero ter te ajudado :)");
		}
	}
	
	public void run() {
		iniciarReconhecedor();
	}	

}
