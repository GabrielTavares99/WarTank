import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Alvo extends JLabel implements Runnable{
	Cenario tela;
	int x,y;
	Thread t ;
	Carro car;
	Vida life;
	List<Tiro> tiros ;
	int cod = 0;
	int i = 0; 
	
	GerarTiros g;
	GerarInimigos tb;
	ControladorJogo cj ;
	Pontuacao pontuacao;
	
	public Alvo(Cenario c,Carro carro,Vida vida, GerarInimigos ggg,Pontuacao p){
		tela = c;
		life = vida;
//		setOpaque(true);
		car = carro;
		tb = ggg;
		x = new Random().nextInt(tela.getWidth()-30);		
		y = new Random().nextInt(tela.getHeight()-30);
		pontuacao = p;
		
		setSize(50, 40);
		
		
		i = direcao();
		
		setBackground(Color.black);
		
		tela.panoDeFundo.add(this);
	
		g = new GerarTiros(this, tela, null, this.i,life);
		
		
		t = new Thread(this);
		t.start();
//
//		
		tela.panoDeFundo.setComponentZOrder(this, 3);
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
//		Thread t2 = new Thread(run2());
//		t2.start();
		
		for (int i = 0; i < 10000; i++) {	
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				
			}
			
			if (cod == 0) {
				setLocation(x, this.getY()+1);
			}else if (cod == 1) {
				setLocation(x, this.getY()-1);
			}
			
			GerarInimigos g4 = GerarInimigos.getInstance(tela, car, life);

			if (life.getWidth() <= 0) {
				
//				tela.panoDeFundo.remove(this);
				
				g4.t.stop();
				this.g.t.stop();
				this.t.stop();
				
				
				this.tela.dispose();
				
				Component[] c = tela.panoDeFundo.getComponents();
				
				if ((c[i] instanceof Tiro) ){
					try {
						Tiro tirooo = (Tiro) c[i];
						tirooo.t.stop();
						
						tela.panoDeFundo.remove(tirooo);
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				
				break;
			}else{
				
			
			
//			Verificando se o objeto está fora da tela
			if (this.getY()-30 > tela.getHeight()-30 || this.getY() < 0) {				
				car.dano(life,1);
				pontuacao.perder(this.pontuacao);
				tela.panoDeFundo.remove(this);
				
				if (life.getWidth() <= 0) {		
					JOptionPane.showMessageDialog(null, "Game Over");
					
					g4.t.stop();
					
					cj = ControladorJogo.getInstance();
					cj.cm.musica.stop();
					cj.cm.t.stop();

					TelaInicial telaInicial = new TelaInicial();
					tela.dispose();
					
					this.t.stop();
					this.tela.dispose();
					break;
				}
				t.stop();
				this.g.t.stop();
				this.t.stop();
				
			}	
			
			
			}
		}
	}
	
	Random r = new Random();
	
	public int direcao(){
		
	 int condicao = r.nextInt(2);
	 
//	 System.out.println(condicao);
		if (condicao == 0) {
			y = 0;
			x = r.nextInt(tela.getWidth()-50);
			setIcon(new ImageIcon(getClass().getResource("/images/tankInimigoBaixo.png")));
			cod = 0;						
		}else if(condicao == 1){
			x = r.nextInt(tela.getWidth()-50);
			y = tela.getHeight()-50;
			cod = 1;
			setIcon(new ImageIcon(getClass().getResource("/images/tankInimigo.png")));
		}
		
//		System.out.println(this.getX());
		setBounds(x, y, 50, 40);
		
		return cod;
	}
	
	public void parar(){
		tela.panoDeFundo.remove(this);
		t.stop();
	}
	
//	Colisao colisao = new Colisao();

	public void tirarAlvo(Alvo alvo,Cenario cenario, GerarTiros gerarTiros, Carro carro, Vida vida){
		carro.dano(vida,1);
		alvo.g.t.stop();
		alvo.t.stop();
		tela.panoDeFundo.remove(alvo);
	}
	
}	
