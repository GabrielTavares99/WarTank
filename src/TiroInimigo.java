import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TiroInimigo extends JLabel implements Runnable{
	
	Cenario tela;
	Thread t;
	Pontuacao pontuacao;
	int direcao;
	Alvo alvo;
	Vida vida;
	ControladorJogo cj;
//	GerarInimigos gi;
	
	public TiroInimigo(Alvo a,Cenario c, Pontuacao p, int d, Vida life){
	vida = life;
	tela = c;
	pontuacao = p;
	direcao = d;
	alvo = a;

	setBounds(alvo.getX()+7, alvo.getY(),15, 20);
	tela.panoDeFundo.add(this);
	atirar(d);
	
	t = new Thread(this);
	t.start();
	
	tela.panoDeFundo.setComponentZOrder(this, 3);
		
}

	public void atirar(int direcao){
		switch (direcao) {
		case 1:
			this.setLocation(this.getX(), this.getY()-1);
			setIcon(new ImageIcon(getClass().getResource("/images/missil.png")));
			break;
		case 3:
			this.setLocation(this.getX()-1, this.getY());
			setIcon(new ImageIcon(getClass().getResource("/images/missilEsquerda.png")));
			break;
		case 33:
			this.setLocation(this.getX()+1, this.getY());
			setIcon(new ImageIcon(getClass().getResource("/images/missilDireita.png")));
			break;
		case 0:
			this.setLocation(this.getX(), this.getY()+1);
			setIcon(new ImageIcon(getClass().getResource("/images/missilBaixo.png")));
			break;

		default:
			break;
		}
	}
	
	public boolean acertar(){
		
		Component[] c = tela.panoDeFundo.getComponents();
		
		for (int i = 0; i < c.length; i++) {
			Rectangle r2 = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

			Rectangle r1 = new Rectangle(c[i].getX(), c[i].getY(), c[i].getWidth(), c[i].getHeight());

			if (vida.getWidth()<=0) {
				
				tela.panoDeFundo.remove(this);
				this.t.stop();
				break;
			}else if ((c[i] instanceof Carro) && (r1.intersects(r2))) {
				tela.panoDeFundo.remove(this);
				Carro  carro = (Carro) c[i];
				carro.dano(vida);
//				this.alvo.t.stop();
				
				this.t.stop();
				GerarInimigos g4 = GerarInimigos.getInstance(tela, carro, vida);
				g4.t.stop();
				
				if (vida.getWidth() <= 0) {
//					ControladorJogo cj = new ControladorJogo();
//					cj.Perder(tela);
//					JOptionPane.showConfirmDialog(null, "Perdeu");
					return true;
				}
				this.t.stop();		
				
			}
			
		}
		
		return false;
	}
	
	
	
	@Override
	public void run() {
		
		for (int i = 0 ; i < 10000 ; i++) {
			//System.out.println("oi");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				if (this.getY() > 0 || this.getY() < tela.getWidth()) {

					if (acertar()) {
//						tela.dispose();
						System.out.println("tiro inimigo xxxxxxxxx");
//						TelaInicial tl = new TelaInicial();
						break;
					}
					
					atirar(direcao);
					
				}else{
					t.stop();
					tela.panoDeFundo.remove(this);	
				}
				
			} catch (Exception e) {
			}
			
		}
		
	}
}
