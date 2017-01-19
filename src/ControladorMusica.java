
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.swing.ImageIcon;

import javazoom.jl.player.Player;

public class ControladorMusica {


	File mp3File = null;
	MP3Musica musica = null;
	String path = "";
	Thread t;
	static ControladorMusica controladorMusica;

	public ControladorMusica() {
		
		
		// STRING COM O CAMINHO DO ARQUIVO MP3 A SER TOCADO

//				String path = "/fundo.mp3";
//				path = "C:/JogoDesviar/jogo.mp3";
		
				// INSTANCIAÇÃO DO OBJETO FILE COM O ARQUIVO MP3
//				mp3File = new File(path);
		 
				// INSTANCIAÇÃO DO OBJETO MP3MUSICA DA CLASS INTERNA
//				MP3Musica musica = new MP3Musica();
//				musica.tocar(mp3File);
		 
				// CHAMA O METODO QUE TOCA A MUSICA
//				musica.start();
		t = new Thread(musica);
		
	}

	public void tiroTanque(){
		path = "C:/JogoDesviar/tiroTanque.mp3";
		mp3File = new File(path);
		musica = new MP3Musica();
		musica.tocar(mp3File,false);
		musica.start();
	}
	
	public void explodir(){
		path = "C:/JogoDesviar/explosaoTanque.mp3";
		mp3File = new File(path);
		musica = new MP3Musica();
		musica.tocar(mp3File,false);
		musica.start();
	}
	
	public void telaInicial(){
		path = "C:/JogoDesviar/telaInicial.mp3";
		mp3File = new File(path);
		musica = new MP3Musica();
		musica.tocar(mp3File,true);
		musica.start();
	}
	
	public void trilhaSonora(){
		
		path = "C:/JogoDesviar/jogo.mp3";
		mp3File = new File(path);
		musica = new MP3Musica();
		musica.tocar(mp3File,true);
		musica.start();
	}
	
	public void parar(){
		t.stop();
	}
	
	public static ControladorMusica getInstance(){
		if (controladorMusica == null) {
			controladorMusica = new ControladorMusica();
		}
		return controladorMusica;
	}
	

}
