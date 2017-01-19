import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carro extends JLabel implements  KeyListener {
	Cenario tela;
	Carro carro;
	Alvo alvo;
	int tecla = 38;
	int X=0,Y=0;
	Pontuacao pontuacao;
	Vida vida;
	ControladorMusica cm;
	public Carro(Cenario c, Pontuacao p, Vida life) {
		
		cm = new ControladorMusica();
		
		tela = c;
		
		X = (tela.getWidth()/2) - 32;
		Y = tela.getHeight()-100;
//		setOpaque(true);
//		setBackground(Color.PINK);
		pontuacao = p;
		vida = life;
		setBounds(X,Y,60,40);		
//		setBackground(Color.red);
		ImageIcon logo = new ImageIcon(getClass().getResource("/images/tankAmigo.png"));
//		logo.setImage(logo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 100));
		setIcon(logo);

		c.addKeyListener(this);
		tela.panoDeFundo.add(this);
		carro = this;
	}
	
	public void dano(Vida vida,int a){
		cm.explodir();
		vida.setSize(vida.getWidth()-20,vida.getHeight());	
//		this.setLocation(X, Y);
//		pontuacao.perder();
	}
	
	
	public void dano(Vida vida){
		cm.explodir();
		vida.setSize(vida.getWidth()-20,vida.getHeight());	
		this.setLocation(X, Y);
//		pontuacao.perder();
	}
	
	public void mudarImagem(int sentido){
		ImageIcon logo;
		switch (sentido) {
		
		case 38:
			logo = new ImageIcon(getClass().getResource("/images/tankAmigo.png"));
			setIcon(logo);
			tecla = 38;
			break;
		
		case 37:
			logo = new ImageIcon(getClass().getResource("/images/tankAmigoEsquerda.png"));
			setIcon(logo);
			tecla = 37;
			break;
			
		case 39:
			logo = new ImageIcon(getClass().getResource("/images/tankAmigoDireita.png"));
			setIcon(logo);
			tecla = 39;
			break;
		case 40:
			logo = new ImageIcon(getClass().getResource("/images/tankAmigoBaixo.png"));
			setIcon(logo);
			tecla = 40;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 39) {
			if ((this.getX()-40)+10 > tela.getWidth()) {
				
			}else{
//				System.out.println(this.getX()+10);
				setLocation(this.getX()+10, this.getY());	
				mudarImagem(arg0.getKeyCode());
			}
			
		}else if (arg0.getKeyCode() == 37) {
			if (this.getX()-10 < 0) {
				
			}else{
				setLocation(this.getX()-10, this.getY());	
				mudarImagem(arg0.getKeyCode());
			}
			
		}else if(arg0.getKeyCode() == 38){
				if ((this.getY()-10) < 0) {
					
				}else{
					setLocation(this.getX(), this.getY()-10);
					mudarImagem(arg0.getKeyCode());
				}
		}else if(arg0.getKeyCode() == 40){
			if ((this.getHeight() + 10) > tela.getHeight() ) {
				
			}else{
				setLocation(this.getX(), this.getY()+10);
				mudarImagem(arg0.getKeyCode());
			}
		}else if(arg0.getKeyCode() == 32){
			
			Tiro tiro = new Tiro(carro, tela,pontuacao,tecla,vida);
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
