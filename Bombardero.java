package ProyectoFinal;

public class Bombardero extends Aviones{
	private String modo;
	
	public Bombardero() {
	}
	public Bombardero(int a,int d,int v,int p,String m) {
		super(a,d,v,p);
		modo = m;
	}
	public void setModo(String m) {
		modo = m;
	}
	public String getModo() {
		return modo;
	}
	public void CambioHabilidad() {
		if(modo.equals("Equilibrado")) {
			super.setAtaque(super.getPuntos()/2);
			super.setDefensa(super.getPuntos()/2);
		}
		else if(modo.equals("Metralleta")) {
			super.setAtaque(super.getPuntos()/4);
			super.setDefensa(3*super.getPuntos()/4);
		}
		else if(modo.equals("Bombas")) {
			super.setAtaque(3*super.getPuntos()/4);
			super.setDefensa(super.getPuntos()/4);
		}
	}
}
