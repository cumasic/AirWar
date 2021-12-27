package ProyectoFinal;

public class Aviones extends FuerzaAerea{
	private int puntos;
	private String estado="vivo";
	
	public Aviones() {
	}
	public Aviones(int a,int d,int v,int p) {
		super(a,d,v);
		puntos = p;
	}
	public void setPuntos(int p) {
		puntos = p;
	}
	public int getPuntos() {
		return puntos;
	}
	public String getEstado() {
		return estado;
	}
	public void morir() {
		estado="muerto";
	}
}