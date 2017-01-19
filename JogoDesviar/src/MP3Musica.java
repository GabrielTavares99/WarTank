
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class MP3Musica extends Thread {
	 
	// OBJETO PARA O ARQUIVO MP3 A SER TOCADO
	private File mp3;

	// OBJETO PLAYER DA BIBLIOTECA JLAYER QUE TOCA O ARQUIVO MP3
	private Player player;

	/**
	 * CONSTRUTOR RECEBE O OBJETO FILE REFERECIANDO O ARQUIVO MP3 A SER
	 * TOCADO E ATRIBUI AO ATRIBUTO DA CLASS
	 *
	 * @param mp3
	 */
	Boolean repeticao;
	Thread t;
	public void tocar(File mp3, Boolean r) {
		this.mp3 = mp3;
		repeticao = r;
//		t = new Thread(this);
	}

	/**
	 * ===============================================================
	 * ======================================METODO RUN QUE TOCA O MP3
	 * ===============================================================
	 */
	public void run() {
		do{
		
		try {
			FileInputStream fis = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(fis);

			this.player = new Player(bis);
//			System.out.println("Tocando Musica!");

			this.player.play();
//			System.out.println("Terminado Musica!");

		} catch (Exception e) {
//			System.out.println("Problema ao tocar Musica " + mp3);
			e.printStackTrace();
		}
	}while(repeticao);
		
//		this.stop();
	}
}

