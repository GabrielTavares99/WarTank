import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Fundo extends JLabel{
	Cenario tela;
	Thread t;
	JLabel fc;
	
	public Fundo(Cenario c){
		ImageIcon logo = new ImageIcon(getClass().getResource("/images/cenario.jpg"));
		setSize(800,600);
		tela = c;
//		t = new Thread(this);
//		setOpaque(true);
//		setIcon(logo);
		setBounds(0, 0, 800, 600);
		tela.add(this);
	}
//freepic		
		
	public void parar(){
		t.stop();
	}
	
}
