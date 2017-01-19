
public class GerarTiros implements Runnable{


	Pontuacao pontuacao;
	int direcao;
	Cenario tela;
	Alvo alvo;
	Vida vida;
	Thread t;
	
	public GerarTiros(Alvo a,Cenario c, Pontuacao p, int d, Vida life ) {
		// TODO Auto-generated constructor stub
		vida = life;
		tela = c;
		pontuacao = p;
		direcao = d;
		alvo = a;
		
		
			t = new Thread(this);
			t.start();
		
		
		
	}
	

	@SuppressWarnings("deprecation")
	public void parar(){
		t.stop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			TiroInimigo ti = new TiroInimigo(alvo, tela, null, alvo.i, vida);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
}
