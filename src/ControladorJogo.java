import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ControladorJogo {
	Cenario tela;
	ControladorMusica cm  = ControladorMusica.getInstance();
	static ControladorJogo controladorJogo;
		
	public void pararMusica(){
		cm.parar();
	}
	
	public void telaInicial(){
		cm.telaInicial();
		TelaInicial tl = new TelaInicial();
	}
	
	public void iniciarJogo(){
		cm.parar();	
		cm.trilhaSonora();
			
//		cm.trilhaSonora();
		Cenario c = new Cenario();		
	}
	
	
	public static ControladorJogo getInstance(){
		if (controladorJogo == null) {
			controladorJogo = new ControladorJogo();
		}
		return controladorJogo;
	}	
	
	public void perder(Cenario tela, Carro carro){
		
	}
	
}

