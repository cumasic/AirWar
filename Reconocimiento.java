package ProyectoFinal;

public class Reconocimiento extends Aviones{
	private String modo;
	private int vision;
	
	public Reconocimiento() {
	}
	public Reconocimiento(int a,int d,int v,int p,String m) {
		super(a,d,v,p);
		modo = m;
	}
	public void setModo(String m) {
		modo = m;
	}
	public String getModo() {
		return modo;
	}
	public void setVision(int v) {
		vision = v;
	}
	public int getVision() {
		return vision;
	}
	public void CambioHabilidad() {
		if(modo.equals("Reduccion de vida")) {
			setVision(1);
		}
		else if(modo.equals("Reduccion de ataque")) {
			setVision(2);
		}
		else if(modo.equals("Reduccion de defensa")) {
			setVision(3);
		}
	}
}