import java.util.ArrayList;
import java.util.List;


public class Colisao {
	
	private List<Integer> x = new ArrayList<Integer>();
	private List<Integer> y = new ArrayList<Integer>();
	private int x1,y1;
	
	public Colisao(){
		
	}


	public List<Integer> getX() {
		return x;
	}


	public void setX(List<Integer> x) {
		this.x = x;
	}


	public List<Integer> getY() {
		return y;
	}


	public void setY(List<Integer> y) {
		this.y = y;
	}


	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}
}
