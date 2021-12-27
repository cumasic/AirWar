package ProyectoFinal;

public class FuerzaAerea{
	private int nivelAtaque;
	private int nivelDefensa;
	private int nivelVida;
	
	public FuerzaAerea() {
	}
	public FuerzaAerea(int a,int d,int v) {
		nivelAtaque = a;
		nivelDefensa = d;
		nivelVida = v;
	}
	public void setAtaque(int a) {
		nivelAtaque = a;
	}
	public int getAtaque() {
		return nivelAtaque;
	}
	public void setDefensa(int d) {
		nivelDefensa = d;
	}
	public int getDefensa() {
		return nivelDefensa;
	}
	public void setNivelVida(int vid) {
		nivelVida = vid;
	}
	public int getNivelVida() {
		return nivelVida;
	}
	
}
