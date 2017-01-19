import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.SliderUI;


public class Tiro extends JLabel implements Runnable{
	Cenario tela;
	Thread t;
	List<Tiro> listaTiro;
	Pontuacao pontuacao;
	int direcao;
	Vida vida;
	public Tiro(Carro carro,Cenario cenario, Pontuacao p, int d, Vida life){
		tela = cenario;
		pontuacao = p;
		direcao = d;
		
		setBounds(carro.getX()+10, carro.getY(),15, 20);
		vida = life;
//		setIcon(new ImageIcon(getClass().getResource("/images/missil.png")));
		
		tela.panoDeFundo.add(this);
//		setOpaque(true);
//		setBackground(Color.BLUE);
		Alvo alvo = null;
		listaTiro = new ArrayList<Tiro>();
		
		t = new Thread(this);
		t.start();
		tela.panoDeFundo.setComponentZOrder(this, 3);

//		try {
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
	public void acertar(){
		Component[] c = tela.panoDeFundo.getComponents();
		Rectangle r2 = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

		for (int i = 0; i < c.length; i++) {
			Rectangle r1 = new Rectangle(c[i].getX(), c[i].getY(), c[i].getWidth(), c[i].getHeight());

			if (vida.getWidth()<=0) {
				tela.panoDeFundo.remove(this);
				this.t.stop();
				break;
			}else if ((c[i] instanceof Alvo) && (r1.intersects(r2))) {
				Alvo  alvo = (Alvo) c[i];
				tela.panoDeFundo.remove(this);
				alvo.parar();
				pontuacao.pontu();
				alvo.g.parar();
				break;
			}
			
		}
		
		
	}
	
	public void atirar(int direcao){
		switch (direcao) {
		case 38:
			this.setLocation(getX(), getY()-1);
			setIcon(new ImageIcon(getClass().getResource("/images/missil.png")));
			break;
		case 37:
			this.setLocation(getX()-1, getY());
			setIcon(new ImageIcon(getClass().getResource("/images/missilEsquerda.png")));
			break;
		case 39:
			this.setLocation(getX()+1, getY());
			setIcon(new ImageIcon(getClass().getResource("/images/missilDireita.png")));
			break;
		case 40:
			this.setLocation(getX(), getY()+1);
			setIcon(new ImageIcon(getClass().getResource("/images/missilBaixo.png")));
			break;

		default:
			break;
		}
	}
	
	ControladorMusica cm = new ControladorMusica();
	
	@Override
	public void run() {
		cm.tiroTanque();
		for (int i = 0 ; i < 10000 ; i++) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (this.getY() > 0 || this.getY() < tela.getWidth()) {
					acertar();	
					atirar(direcao);
				}else{
					tela.panoDeFundo.remove(this);
					t.stop();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			
			

		}
		
	}
	public void parar() {
		// TODO Auto-generated method stub
		tela.remove(this);
		t.stop();
		
	}
}
