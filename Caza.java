package ProyectoFinal;

public class Caza extends Aviones{
	private String modo;
	
	public Caza() {
	}
	public Caza(int a,int d,int v,int p,String m) {
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
		else if(modo.equals("Misiles")) {
			super.setAtaque(3*super.getPuntos()/4);
			super.setDefensa(super.getPuntos()/4);
		}
	}
}
