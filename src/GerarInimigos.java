import java.util.ArrayList;
import java.util.Random;


public class GerarInimigos implements Runnable{
	
	Cenario tela; 
	ArrayList <Alvo> alvos = new ArrayList<Alvo>();
	
	Carro car;
	Vida life;
	
	
	Thread t;
	Pontuacao pontuacao;
	static GerarInimigos gerarInimigos;
	
	public GerarInimigos(Cenario c,Carro carro, Vida vida){
		tela = c;
		car = carro;
		life = vida;
		pontuacao = new Pontuacao(tela);
		t = new Thread (this);
		t.start();
		
	}
	Alvo alv;
	
	Random r = new Random();
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Alvo alvo = new Alvo(tela,car,life,this, pontuacao);
			
			alvos.add(alvo);
			
		}
		// TODO Auto-generated method stub
			
	}
	public void parar(){
	
		t.stop();
		System.out.println("parou");
	}
	
	public static GerarInimigos getInstance(Cenario tela,Carro c,Vida v){
		if (gerarInimigos == null) {
			gerarInimigos = new GerarInimigos(tela,c,v);
		}
		return gerarInimigos;
	}
	
}
