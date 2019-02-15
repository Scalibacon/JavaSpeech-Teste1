package model;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class ThreadVoz extends SwingWorker<Object, Object>{

	private LiveSpeechRecognizer reconhecedor;
	public static String resultadoDoReconhecedor;
	private boolean reconhecedorRodando = false;
	private ControladaPorVoz tela;
	private JButton btnLigaVoz;
	Configuration configuracao;
	
	public ThreadVoz(ControladaPorVoz tela, JButton btnLigaVoz) {
		this.btnLigaVoz = btnLigaVoz;
		this.tela = tela;
		
		configuracao = new Configuration();
		configuracao.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuracao.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuracao.setGrammarPath("resource:/grammars");
		configuracao.setGrammarName("grammar");
		configuracao.setUseGrammar(true);
	}
	
	public void iniciarReconhecedor() {
		try {
			reconhecedor = new LiveSpeechRecognizer(configuracao);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		if(reconhecedorRodando)
			System.out.println("Reconhecedor já foi iniciado");
		else {
			reconhecedorRodando = true;				
			reconhecedor.startRecognition(true);
			System.out.println("aqui");;
			btnLigaVoz.setText("Ouvindo...");
			System.out.println("Ouvindo...");			
			try {
//				while(reconhecedorRodando) {
//					SpeechResult resultadoDaFala = reconhecedor.getResult();
//					if (resultadoDaFala == null)
//						System.out.println("Não consegui entender o que você falou :(");
//					else {
//						resultadoDoReconhecedor = resultadoDaFala.getHypothesis();
//						System.out.println("Você disse '" + resultadoDoReconhecedor + "'");	
//						reconhecedorRodando = false; //Depois verificar se irá sair antes da hora
//						tela.executaComandoPorVoz(resultadoDoReconhecedor);
//					}
				
			tela.executaComandoPorVoz("change color to red");
			System.out.println("foi");
			} catch(Exception e) {
				e.printStackTrace();
				reconhecedorRodando = false;
			}
			System.out.println("Espero ter te ajudado :)");
			reconhecedor.stopRecognition();
		}
		btnLigaVoz.setText("START");
	}
	
	public Object doInBackground() throws Exception {
		iniciarReconhecedor();		
		return null;
	}	

}
