package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaColoridaController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class TelaColorida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container;
	private JButton btnLigaVoz;	

	public static void main(String[] args) {
		TelaColorida frame = new TelaColorida();
		frame.setVisible(true);
	}

	public TelaColorida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		container = new JPanel();
		container.setBackground(new Color(144, 238, 144));
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setLayout(null);
		setContentPane(container);		
		
		btnLigaVoz = new JButton("START");
		btnLigaVoz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLigaVoz.setBounds(160, 120, 115, 30);
		TelaColoridaController telaCtrl = new TelaColoridaController(this, btnLigaVoz, container);
		btnLigaVoz.addActionListener(telaCtrl);
		
		container.add(btnLigaVoz);
	}
}
