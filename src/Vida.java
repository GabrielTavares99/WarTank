import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Vida extends JLabel{
	public Vida(Cenario tela){
		
		setBounds(10, 40, 100, 30);
//		setOpaque(true);
		
		ImageIcon logo;
		logo = (new ImageIcon(getClass().getResource("/images/barraVida.png")));
		logo.setImage(logo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 100));
				
		this.setIcon(logo);
		
		tela.panoDeFundo.add(this);
		
	}
}
