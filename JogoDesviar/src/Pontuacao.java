import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class Pontuacao extends JLabel{
	
//int pontuacao = 0;
Cenario cenario;
	int pontuacao  = 0;

	public Pontuacao(Cenario frame){
		cenario = frame;
		
//		setOpaque(true);
		setBounds(10, 10, 150, 30);
		setText("Score: "+Integer.toString(pontuacao));
		
		setFont(new Font("Capture it", Font.BOLD, 20));
		setForeground(Color.white);
		
		
		cenario.panoDeFundo.add(this);
		
	}
	
	public void pontu(){
		pontuacao += 10;
		this.setText("Score: "+Integer.toString(pontuacao));
		this.repaint();
	}
	
	public void perder(Pontuacao pont){
		pont.pontuacao -= 10;
		pont.setText("Score: "+Integer.toString(pont.pontuacao));
		pont.repaint();
	}
	
}
