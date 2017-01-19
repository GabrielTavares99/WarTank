import java.io.ObjectInputStream.GetField;


public class Principal {
	public static void main(String[] args) {
		
		ControladorJogo cj = ControladorJogo.getInstance();	
		
		cj.cm.telaInicial();
		cj.telaInicial();
				
	}
}
