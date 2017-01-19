import java.awt.Color;

import javax.swing.JLabel;


public class FundoComplementar extends JLabel implements Runnable{
	Cenario tela;
	Thread t;
	public FundoComplementar(Cenario c){
		setSize(800,600);
		tela = c;
		t = new Thread(this);
		setOpaque(true);
		setBackground(Color.pink);
		setBounds(600, -600, 800, 600);
		t.start();
		tela.add(this);
		
	}

	@Override
	public void run() {
//		try {
//			while (false) {
//				
//				t.sleep(1000);
//				setLocation(getX(), getY()+10);
//				
//				
//			}
////			freepic
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		
	}
}
