package ProyectoFinal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Movimiento extends JFrame{
	private static final int Ancho = 200;
	private static final int Alto = 400;
	private JPanel apli = new JPanel();   
	private JPanel skill;
	private JPanel bata = new JPanel();   
	private JPanel batalla;
	private JScrollPane barra = new JScrollPane();
	private JScrollPane barra2 = new JScrollPane();
	private ButtonGroup opci = new ButtonGroup();
	private JRadioButton norm;
	private JRadioButton high;
	private JRadioButton low;
	private JButton btn1;
	private JButton btn2;
	private JLabel vida;
	private JLabel ataque;
	private JLabel defensa;
	private String nombre,opci1,opci2,opci3;
	private String aliado,enemigo,Ganador;
	
	
	private Caza Caza1JUG1 = new Caza(20,20,50,40,"Equilibrado");
	private Caza Caza2JUG1 = new Caza(20,20,50,40,"Equilibrado");
	private Caza Caza3JUG1 = new Caza(20,20,50,40,"Equilibrado");
	private Caza Caza1JUG2 = new Caza(20,20,50,40,"Equilibrado");
	private Caza Caza2JUG2 = new Caza(20,20,50,40,"Equilibrado");
	private Caza Caza3JUG2 = new Caza(20,20,50,40,"Equilibrado");
	private Bombardero BombarderoJUG1 = new Bombardero(30,30,70,60,"Equilibrado");
	private Bombardero BombarderoJUG2 = new Bombardero(30,30,70,60,"Equilibrado");
	private Reconocimiento ReconocimientoJUG1 = new Reconocimiento(10,10,30,20,"Reduccion de vida");
	private Reconocimiento ReconocimientoJUG2 = new Reconocimiento(10,10,30,20,"Reduccion de vida");
	
	private Bases basePx1 = new Bases(40,40,120);
	private Bases basePx2 = new Bases(40,40,120);
	private Bases baseS1x1 = new Bases(20,20,70);
	private Bases baseS2x1 = new Bases(20,20,70);
	private Bases baseS1x2 = new Bases(20,20,70);
	private Bases baseS2x2 = new Bases(20,20,70);
	
	public Movimiento() {
	}
	public void Modificacion(String n) {
		nombre = n;
		setTitle("Panel de modificaciones a Aviones");
		setSize(Ancho,Alto);
		setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		skill = new JPanel(new FlowLayout(FlowLayout.LEFT));
		skill.setLayout(new BorderLayout());
		skill.setLayout(new GridLayout(11,1));
		createContents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void Batalla(String a,String e) {
		aliado = a;
		enemigo = e;
		setTitle("Resumen de las Batallas");
		setSize(300,400);
		batalla = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		batalla.setLayout(new BorderLayout());
		batalla.setLayout(new GridLayout(20,1));
		createContentsBatalla(); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void setNombre(String n) {
		nombre = n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setAliado(String a) {
		aliado = a;
	}
	public String getAliado() {
		return aliado;
	}
	public void setEnemigo(String e) {
		enemigo = e;
	}
	public String getEnemigo() {
		return enemigo;
	}
	public void setGanador(String n) {
		Ganador = n;
	}
	public String getGanador() {
		return Ganador;
	}
	private void createContents() {
		tiposAviones();
		JLabel xlabel = new JLabel(nombre);
		skill.add(xlabel);
		JLabel xlabel1 = new JLabel("Estado del avión:");
		skill.add(xlabel1);
		EstadoAviones(nombre);
		skill.add(vida);
		skill.add(ataque);
		skill.add(defensa);
		JLabel xlabel2 = new JLabel("Opciones de modificaciones");
		btn1 = new JButton("Modificar");
		btn2 = new JButton("Enviar");
		norm = new JRadioButton(opci1,false);
		high = new JRadioButton(opci2,false);
		low = new JRadioButton(opci3,false);
		opci.add(norm);
		opci.add(high);
		opci.add(low);
		skill.add(xlabel2);
		skill.add(norm);
		skill.add(high);
		skill.add(low);
		skill.add(btn1);
		skill.add(btn2);
		apli.add(skill);
		barra.setViewportView(apli);
		add(barra,BorderLayout.CENTER);
		btn1.addActionListener(new Listener());
		btn2.addActionListener(new Listener());
	}
	public void EstadoAviones(String n) {
		if(n.equals("Caza1JUG1")) {
			vida = new JLabel("Nivel de Vida: "+Caza1JUG1.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza1JUG1.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza1JUG1.getDefensa());
		}
		else if(n.equals("Caza2JUG1")) {
			vida = new JLabel("Nivel de Vida: "+Caza2JUG1.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza2JUG1.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza2JUG1.getDefensa());
		}
		else if(n.equals("Caza3JUG1")) {
			vida = new JLabel("Nivel de Vida: "+Caza3JUG1.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza3JUG1.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza3JUG1.getDefensa());
		}
		else if(n.equals("Caza1JUG2")) {
			vida = new JLabel("Nivel de Vida: "+Caza1JUG2.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza1JUG2.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza1JUG2.getDefensa());
		}
		else if(n.equals("Caza2JUG2")) {
			vida = new JLabel("Nivel de Vida: "+Caza2JUG2.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza2JUG2.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza2JUG2.getDefensa());
		}
		else if(n.equals("Caza3JUG2")) {
			vida = new JLabel("Nivel de Vida: "+Caza3JUG2.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+Caza3JUG2.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+Caza3JUG2.getDefensa());
		}
		else if(n.equals("BombarderoJUG1")) {
			vida = new JLabel("Nivel de Vida: "+BombarderoJUG1.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+BombarderoJUG1.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+BombarderoJUG1.getDefensa());
		}
		else if(n.equals("BombarderoJUG2")) {
			vida = new JLabel("Nivel de Vida: "+BombarderoJUG2.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: "+BombarderoJUG2.getAtaque());
			defensa = new JLabel("Nivel de Defensa: "+BombarderoJUG2.getDefensa());
		}
		else if(n.equals("ReconocimientoJUG1")) {
			vida = new JLabel("Nivel de Vida: "+ReconocimientoJUG1.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: 10 Nivel de Defensa: 10");
			defensa = new JLabel("Tipo de vision: "+ReconocimientoJUG1.getVision());
		}
		else if(n.equals("ReconocimientoJUG2")) {
			vida = new JLabel("Nivel de Vida: "+ReconocimientoJUG2.getNivelVida());
			ataque = new JLabel("Nivel de Ataque: 10 Nivel de Defensa: 10");
			defensa = new JLabel("Tipo de vision: "+ReconocimientoJUG2.getVision());
		}
	}
	public void tiposAviones() {
		if(nombre.equals("Caza1JUG1") || nombre.equals("Caza2JUG1") || nombre.equals("Caza3JUG1")) {
			opci1 = "Equilibrado";
			opci2 = "Metralleta";
			opci3 = "Misiles";
		}
		else if(nombre.equals("BombarderoJUG1")) {
			opci1 = "Equilibrado";
			opci2 = "Metralleta";
			opci3 = "Bombas";
		}
		else if(nombre.equals("ReconocimientoJUG1")) {
			opci1 = "Reduccion de vida";
			opci2 = "Reduccion de ataque";
			opci3 = "Reduccion de defensa";
		}
		else if(nombre.equals("Caza1JUG2") || nombre.equals("Caza2JUG2") || nombre.equals("Caza3JUG2")) {
			opci1 = "Equilibrado";
			opci2 = "Metralleta";
			opci3 = "Misiles";
		}
		else if(nombre.equals("BombarderoJUG2")) {
			opci1 = "Equilibrado";
			opci2 = "Metralleta";
			opci3 = "Bombas";
		}
		else if(nombre.equals("ReconocimientoJUG2")) {
			opci1 = "Reduccion de vida";
			opci2 = "Reduccion de ataque";
			opci3 = "Reduccion de defensa";
		}
	}
	
	
	private void createContentsBatalla() {
		JLabel xlabel = new JLabel("Batalla entre:");
		JLabel xlabel1 = new JLabel(aliado);
		JLabel xlabel2 = new JLabel(enemigo);
		JLabel titulo = new JLabel("Las batallas se definen por:");
		JLabel ataq = new JLabel("el ataque: Quita la vida al oponente");
		JLabel def = new JLabel("la defensa: Reduce en porcentaje el ataque");
		JLabel vid = new JLabel("la vida: Si llega a 0 el avion muere");
		batalla.add(xlabel);
		batalla.add(xlabel1);
		batalla.add(xlabel2);
		batalla.add(titulo);
		batalla.add(ataq);
		batalla.add(def);
		batalla.add(vid);
		JLabel xlabel3 = new JLabel("Estado de: "+aliado);
		batalla.add(xlabel3);
		EstadoAviones(aliado);
		batalla.add(vida);
		batalla.add(ataque);
		batalla.add(defensa);
		JLabel xlabel4 = new JLabel("Estado de: "+enemigo);
		batalla.add(xlabel4);
		EstadoAviones(enemigo);
		batalla.add(vida);
		batalla.add(ataque);
		batalla.add(defensa);
		VerificarAviones(aliado,enemigo);
		bata.add(batalla);
		barra.setViewportView(bata);
		add(barra,BorderLayout.CENTER);
	}
	public void VerificarAviones(String a,String b) {
		if((a.equals("Caza1JUG1")||a.equals("Caza2JUG1")||a.equals("Caza3JUG1")||a.equals("Caza1JUG2")||a.equals("Caza2JUG2")||a.equals("Caza3JUG2"))&&
			(b.equals("Caza1JUG1")||b.equals("Caza2JUG1")||b.equals("Caza3JUG1")||b.equals("Caza1JUG2")||b.equals("Caza2JUG2")||b.equals("Caza3JUG2"))) {
			ResultadoB1(VerificarCaza(a),VerificarCaza(b));
		}
		else if((a.equals("Caza1JUG1")||a.equals("Caza2JUG1")||a.equals("Caza3JUG1")||a.equals("Caza1JUG2")||a.equals("Caza2JUG2")||a.equals("Caza3JUG2"))&&
			(b.equals("BombarderoJUG1")||b.equals("BombarderoJUG2"))) {
			ResultadoB2(VerificarCaza(a),VerificarBomb(b));
		}
		else if((a.equals("Caza1JUG1")||a.equals("Caza2JUG1")||a.equals("Caza3JUG1")||a.equals("Caza1JUG2")||a.equals("Caza2JUG2")||a.equals("Caza3JUG2"))&&
			(b.equals("ReconocimientoJUG1")||b.equals("ReconocimientoJUG2"))) {
			ResultadoB5(VerificarCaza(a),VerificarRecon(b));
		}
		else if((b.equals("Caza1JUG1")||b.equals("Caza2JUG1")||b.equals("Caza3JUG1")||b.equals("Caza1JUG2")||b.equals("Caza2JUG2")||b.equals("Caza3JUG2"))&&
				(a.equals("BombarderoJUG1")||a.equals("BombarderoJUG2"))) {
			ResultadoB3(VerificarBomb(a),VerificarCaza(b));
		}
		else if((a.equals("BombarderoJUG1")||a.equals("BombarderoJUG2"))&&
				(b.equals("BombarderoJUG1")||b.equals("BombarderoJUG2"))) {
			ResultadoB4(VerificarBomb(a),VerificarBomb(b));
		}
		else if((a.equals("BombarderoJUG1")||a.equals("BombarderoJUG2"))&&
				(b.equals("ReconocimientoJUG1")||b.equals("ReconocimientoJUG2"))) {
			ResultadoB6(VerificarBomb(a),VerificarRecon(b));
		}
		else if((b.equals("Caza1JUG1")||b.equals("Caza2JUG1")||b.equals("Caza3JUG1")||b.equals("Caza1JUG2")||b.equals("Caza2JUG2")||b.equals("Caza3JUG2"))&&
				(a.equals("ReconocimientoJUG1")||a.equals("ReconocimientoJUG2"))) {
			ResultadoB8(VerificarRecon(a),VerificarCaza(b));
		}
		else if((a.equals("ReconocimientoJUG1")||a.equals("ReconocimientoJUG2"))&&
				(b.equals("BombarderoJUG1")||b.equals("BombarderoJUG2"))) {
			ResultadoB9(VerificarRecon(a),VerificarBomb(b));
		}
		else if((a.equals("ReconocimientoJUG1")||a.equals("ReconocimientoJUG2"))&&
				(b.equals("ReconocimientoJUG1")||b.equals("ReconocimientoJUG2"))) {
			ResultadoB7(VerificarRecon(a),VerificarRecon(b));
		}
	}
	public Caza VerificarCaza(String n) {
		if(n.equals("Caza1JUG1")) {
			return Caza1JUG1;
		}
		else if(n.equals("Caza2JUG1")) {
			return Caza2JUG1;
		}
		else if(n.equals("Caza3JUG1")) {
			return Caza3JUG1;
		}
		else if(n.equals("Caza1JUG2")) {
			return Caza1JUG2;
		}
		else if(n.equals("Caza2JUG2")) {
			return Caza2JUG2;
		}
		else if(n.equals("Caza3JUG2")) {
			return Caza3JUG2;
		}
		else
			return Caza1JUG1;
	}
	public Bombardero VerificarBomb(String n) {
		if(n.equals("BombarderoJUG1")) {
			return BombarderoJUG1;
		}
		else if(n.equals("BombarderoJUG2")) {
			return BombarderoJUG2;
		}
		else
			return BombarderoJUG1;
	}
	public Reconocimiento VerificarRecon(String n) {
		if(n.equals("ReconocimientoJUG1")) {
			return ReconocimientoJUG1;
		}
		else if(n.equals("ReconocimientoJUG2")) {
			return ReconocimientoJUG2;
		}
		else {
			return ReconocimientoJUG1;
		}
	}
	public void ResultadoB1(Caza a,Caza b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	
	public void ResultadoB2(Caza a,Bombardero b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB3(Bombardero a,Caza b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB4(Bombardero a,Bombardero b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB5(Caza a,Reconocimiento b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		if(b.getVision()==1) {
			a.setNivelVida(a.getNivelVida()-20);
		}
		if(b.getVision()==2) {
			a.setAtaque(a.getAtaque()/2);
			a.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(b.getVision()==3) {
			a.setDefensa(a.getDefensa()/2);
			a.setDefensa(a.getPuntos()-a.getDefensa());
		}
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		JLabel result2 = new JLabel("Reconocimiento bajo estadisticas");
		batalla.add(result2);
		JLabel result3 = new JLabel("Revisa tus tropas para ver cambios");
		batalla.add(result3);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB6(Bombardero a,Reconocimiento b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		if(b.getVision()==1) {
			a.setNivelVida(a.getNivelVida()-20);
		}
		if(b.getVision()==2) {
			a.setAtaque(a.getAtaque()/2);
			a.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(b.getVision()==3) {
			a.setDefensa(a.getDefensa()/2);
			a.setDefensa(a.getPuntos()-a.getDefensa());
		}
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		JLabel result2 = new JLabel("Reconocimiento bajo estadisticas");
		batalla.add(result2);
		JLabel result3 = new JLabel("Revisa tus tropas para ver cambios");
		batalla.add(result3);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB7(Reconocimiento a,Reconocimiento b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		if(a.getVision()==1) {
			b.setNivelVida(a.getNivelVida()-20);
		}
		if(a.getVision()==2) {
			b.setAtaque(a.getAtaque()/2);
			b.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(a.getVision()==3) {
			b.setDefensa(a.getDefensa()/2);
			b.setDefensa(a.getPuntos()-a.getDefensa());
		}
		if(b.getVision()==1) {
			a.setNivelVida(a.getNivelVida()-20);
		}
		if(b.getVision()==2) {
			a.setAtaque(a.getAtaque()/2);
			a.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(b.getVision()==3) {
			a.setDefensa(a.getDefensa()/2);
			a.setDefensa(a.getPuntos()-a.getDefensa());
		}
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		JLabel result2 = new JLabel("Reconocimiento bajo estadisticas");
		batalla.add(result2);
		JLabel result3 = new JLabel("Revisa tus tropas para ver cambios");
		batalla.add(result3);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB8(Reconocimiento a,Caza b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		if(a.getVision()==1) {
			b.setNivelVida(a.getNivelVida()-20);
		}
		if(a.getVision()==2) {
			b.setAtaque(a.getAtaque()/2);
			b.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(a.getVision()==3) {
			b.setDefensa(a.getDefensa()/2);
			b.setDefensa(a.getPuntos()-a.getDefensa());
		}
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		JLabel result2 = new JLabel("Reconocimiento bajo estadisticas");
		batalla.add(result2);
		JLabel result3 = new JLabel("Revisa tus tropas para ver cambios");
		batalla.add(result3);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	public void ResultadoB9(Reconocimiento a,Bombardero b) {
		int ataq;
		int def;
		int vid1=1;
		int vid2=1;
		if(a.getVision()==1) {
			b.setNivelVida(a.getNivelVida()-20);
		}
		if(a.getVision()==2) {
			b.setAtaque(a.getAtaque()/2);
			b.setPuntos(a.getPuntos()-a.getAtaque());
		}
		if(a.getVision()==3) {
			b.setDefensa(a.getDefensa()/2);
			b.setDefensa(a.getPuntos()-a.getDefensa());
		}
		for(int i=0;i<5;i++) {
			ataq = a.getAtaque();
			def = ataq*b.getDefensa()/100;
			ataq = ataq-def;
			b.setNivelVida(b.getNivelVida()-ataq);
			vid1 = b.getNivelVida();
			if(vid1<=0) {
				break;
			}
			ataq = b.getAtaque();
			def = ataq*a.getDefensa()/100;
			ataq = ataq-def;
			a.setNivelVida(a.getNivelVida()-ataq);
			vid2 = a.getNivelVida();
			if(vid2<=0) {
				break;
			}
		}
		JLabel result = new JLabel("Resultado de la batalla");
		batalla.add(result);
		JLabel result2 = new JLabel("Reconocimiento bajo estadisticas");
		batalla.add(result2);
		JLabel result3 = new JLabel("Revisa tus tropas para ver cambios");
		batalla.add(result3);
		if(a.getNivelVida()>0) {
			setGanador(aliado);
			JLabel xlabel5 = new JLabel("Ganó: "+aliado);
			batalla.add(xlabel5);
			JLabel xlabel6 = new JLabel("Vida restante: "+vid2);
			batalla.add(xlabel6);
		}
		else if(b.getNivelVida()>0) {
			setGanador(enemigo);
			JLabel xlabel7 = new JLabel("Ganó: "+enemigo);
			batalla.add(xlabel7);
			JLabel xlabel8 = new JLabel("Vida restante: "+vid1);
			batalla.add(xlabel8);
		}
	}
	private class Listener implements ActionListener{
		public Listener() {
			
		}
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==btn1) {
    			ModificarAvion();
    		}
    		else if(e.getSource()==btn2) {
    			setVisible(false);
    		}
    	}
    	public void ModificarAvion() {
    		String mod="";
    		if(norm.isSelected()) {
    			if(nombre.equals("ReconocimientoJUG1")||nombre.equals("ReconocimientoJUG2")) {
    				mod = "Reduccion de vida";
    			}
    			else 
    				mod = "Equilibrado";
    		}
    		else if(high.isSelected()) {
    			if(nombre.equals("ReconocimientoJUG1")||nombre.equals("ReconocimientoJUG2")) {
    				mod = "Reduccion de ataque";
    			}
    			else 
    				mod = "Metralleta";
    		}
    		else if(low.isSelected()) {
    			if(nombre.equals("BombarderoJUG1")||nombre.equals("BombarderoJUG2")) {
    				mod = "Bombas";
    			}
    			else if(nombre.equals("ReconocimientoJUG1")||nombre.equals("ReconocimientoJUG2")) {
    				mod = "Reduccion de defensa";
    			}
    			else 
    				mod = "Misiles";
    		}
    		if(nombre.equals("Caza1JUG1"))
    			CambioAtributos1(Caza1JUG1,mod);
    		else if(nombre.equals("Caza2JUG1"))
    			CambioAtributos1(Caza2JUG1,mod);
    		else if(nombre.equals("Caza3JUG1"))
    			CambioAtributos1(Caza3JUG1,mod);
    		else if(nombre.equals("Caza1JUG2"))
    			CambioAtributos1(Caza1JUG2,mod);
    		else if(nombre.equals("Caza2JUG2"))
				CambioAtributos1(Caza2JUG2,mod);
    		else if(nombre.equals("Caza3JUG2"))
				CambioAtributos1(Caza3JUG2,mod);
    		else if(nombre.equals("BombarderoJUG1"))
				CambioAtributos2(BombarderoJUG1,mod);
    		else if(nombre.equals("BombarderoJUG2"))
				CambioAtributos2(BombarderoJUG2,mod);
    		else if(nombre.equals("ReconocimientoJUG1"))
				CambioAtributos3(ReconocimientoJUG1,mod);
    		else if(nombre.equals("ReconocimientoJUG2"))
				CambioAtributos3(ReconocimientoJUG2,mod);
    	}
    	public void CambioAtributos1(Caza a,String b) {
    		a.setModo(b);
			a.CambioHabilidad();
			vida.setText("Nivel de Vida: "+a.getNivelVida());
			ataque.setText("Nivel de Ataque: "+a.getAtaque());
			defensa.setText("Nivel de Defensa: "+a.getDefensa());
    	}
    	public void CambioAtributos2(Bombardero a,String b) {
    		a.setModo(b);
			a.CambioHabilidad();
			vida.setText("Nivel de Vida: "+a.getNivelVida());
			ataque.setText("Nivel de Ataque: "+a.getAtaque());
			defensa.setText("Nivel de Defensa: "+a.getDefensa());
    	}
    	public void CambioAtributos3(Reconocimiento a,String b) {
    		a.setModo(b);
			a.CambioHabilidad();
			vida.setText("Nivel de Vida: "+a.getNivelVida());
			ataque.setText("Nivel de Ataque: 0 Nivel de Defensa: 0");
			defensa.setText("Tipo de vision: "+a.getVision());
    	}
	}
}
