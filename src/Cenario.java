import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.sound.sampled.*;

import javafx.*;
//import javafx.scene.media.MediaPlayer;

public class Cenario extends JFrame {
	
	public JPanel panoDeFundo;
	
	JLabel fundo;
	
	Cenario tela;
	
	ImageIcon img;	
	
	static Cenario cenario;
	
	int i= 0;
	
	public Cenario(){
		
		tela = this;
		setTitle("Tela Jogo");
		setSize(800, 600);
		setPreferredSize(new Dimension(800,600));
		setLayout(null);
		setLocationRelativeTo(null);
//		setResizable(false);
		
		URL url = this.getClass().getResource("images/tankAmigo.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(imagemTitulo);
		
		panoDeFundo = new JPanel();
		
		tela = this;
		
		panoDeFundo.setLayout(null);		
		panoDeFundo.setBounds(0,0,tela.getWidth(),tela.getHeight());

		img = new ImageIcon(getClass().getResource("images/batllefiled1.jpg"));
		img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 100));
		
		JLabel in = new JLabel( img);
		in.setBounds(0,0,this.getWidth(),this.getHeight());		
		panoDeFundo.add(in);
		
//		setUndecorated(true);
		
		Pontuacao pontuacao = new Pontuacao(this);
			
		Vida vida = new Vida(this);
		Carro carro = new Carro(this,pontuacao,vida);
		
//		if (i == 0) {
//			GerarInimigos gr = GerarInimigos.getInstance(tela, carro, vida);
//		}else {
			GerarInimigos gr = new GerarInimigos(tela, carro, vida);;
//		}

		
		i++;
		
		
		
		panoDeFundo.setComponentZOrder(in, 3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panoDeFundo);
		setVisible(true);
	}

	
	public static Cenario getInstance(){
		if (cenario == null) {
			cenario = new Cenario();
		}
		return cenario;
	}
	
}
