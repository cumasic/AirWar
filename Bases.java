package ProyectoFinal;

public class Bases extends FuerzaAerea{
	private String estado="En pie";
	
	public Bases() {
	}
	public Bases(int a,int d,int v) {
		super(a,d,v);
	}
	public String getEstado() {
		return estado;
	}
	public void derrumbar() {
		estado="Derrumbado";
	}
}
