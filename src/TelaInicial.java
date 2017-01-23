import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.CMMException;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class TelaInicial extends JFrame implements MouseListener{

	JLabel lblIniciar;
	JLabel lblFundo;
	JLabel lblTitulo;
	
	JPanel pnPapelParede;
	
	JFrame tela;
	
	ControladorJogo cj;
	
	Boolean rep = true;
	
	public TelaInicial() {
			
		setSize(800, 600);
		setTitle("War Tank");
		setLayout(null);
		setLocationRelativeTo(null);
		
		URL url = this.getClass().getResource("images/tankAmigo.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(imagemTitulo);
		
		tela = this;
		
		pnPapelParede = new JPanel();
		pnPapelParede.setBounds(0,0,this.getWidth(),this.getHeight());
		pnPapelParede.setLayout(null);
		add(pnPapelParede);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/images/telaInicial2.jpg"));
		img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 100));
		lblFundo = new JLabel(img);
		lblFundo.setBounds(0, 0, tela.getWidth(), tela.getHeight());
		pnPapelParede.add(lblFundo);
		
		lblTitulo = new JLabel("[ War tank ]");
		lblTitulo.setFont(new Font("Top Secret", Font.BOLD, 40));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds((tela.getWidth()/2)-150, 0, 300, 100);
		pnPapelParede.add(lblTitulo);
		
		lblIniciar = new JLabel("Start", JLabel.CENTER);
		lblIniciar.setOpaque(true);
//		Border b = new
//		lblIniciar.setBorder(arg0);;
		lblIniciar.setBackground(Color.red);
		lblIniciar.setBounds((tela.getWidth()/2) -75, (tela.getHeight()/2)+100, 150, 40);
		lblIniciar.setBackground(new Color(74,84,66,200));
		lblIniciar.setForeground(Color.white);
		lblIniciar.setFont(new Font("Capture it", Font.BOLD, 30));
//		lblIniciar.setHorizontalTextPosition(SwingConstants.CENTER);
		pnPapelParede.add(lblIniciar);
				
		cj = ControladorJogo.getInstance();

		cj.cm.tiroTanque();
				
		pnPapelParede.setComponentZOrder(lblFundo, 1);
		pnPapelParede.setComponentZOrder(lblIniciar, 0);
		
		lblIniciar.addMouseListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {

//		cj.pararMusica();
		;
		cj.cm.parar();;
//		cj.cm.trilhaSonora();
		cj.iniciarJogo();
		this.dispose();
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("dsadsad");
//		cm.tiroTanque();
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
