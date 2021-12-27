package ProyectoFinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AirWar extends JFrame{
	
	private static final int Ancho = 1400;
	private static final int Alto = 600;
	private Movimiento mov = new Movimiento();
	private ArrayList<JButton> btns = new ArrayList<JButton>();
	private GridBagLayout lay = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private int[] cont = new int[16];
    private JLabel mensaje1;
    private JLabel mensaje2;
	private JPanel p1;
	private JPanel jug1;
	private JPanel mapa;
	private JPanel zona;
	private JPanel jug2;
	private JComboBox op1;
	private JComboBox op2;
	private int comprob=0;
	private int numAvi;
	private int turno=0;
	private String nomAviAlia;
	private String nomAviEnemy;
	
	private int pC1x1=22;
	private int pC2x1=24;
	private int pC3x1=42;
	private int pB1x1=11;
	private int pR1x1=33;
	private int pC1x2=77;
	private int pC2x2=75;
	private int pC3x2=57;
	private int pB1x2=88;
	private int pR1x2=66;
	
	public AirWar() {
		setTitle("AirWar");
		setSize(Ancho,Alto);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		createContents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void createContents() {
		for(int i=0;i<16;i++)
			cont[i]=0;
		p1 = new JPanel(lay);
		gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
		op1 = new JComboBox();
		AñadirOpciones1(op1);
		op2 = new JComboBox();
		AñadirOpciones2(op2);
		jugador1();
		mapa();
		jugador2();
		op1.addActionListener(new Listener());
		op2.addActionListener(new Listener());
		add(p1);
		
	}
	public void jugador1() {
		jug1 = new JPanel();
		jug1.setBackground(Color.ORANGE);
		JLabel nom = new JLabel("Jugador 1");
		jug1.add(nom);
		jug1.add(op1);
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 2.0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(jug1, gbc);
	}
	public void jugador2() {
		jug2 = new JPanel();
		jug2.setBackground(Color.GRAY);
		JLabel nom = new JLabel("Jugador 2");
		jug2.add(nom);
		jug2.add(op2);
		gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 2.0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(jug2, gbc);
	}
	public void mapa() {
		mapa = new JPanel();
		mapa.setLayout(new GridLayout(10,10,1,1));
		for(int i=0;i<100;i++) {
			PonerImagenes(i);
		}
        for(int i=0;i<100;i++) {
			mapa.add(btns.get(i));
		}
        for(int i=0;i<100;i++) {
			btns.get(i).addActionListener(new Listener(i));
		}
		gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 500.0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        p1.add(mapa,gbc);
	}
	public void PonerImagenes(int n) {
			if(n==0){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseP1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==4){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseSe.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==40){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseSe.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==99){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseP2.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 100, 50);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(100,50,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==59){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseSe2.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==95){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("BaseSe2.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==22){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==24){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==42){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==77){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==75){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==57){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==11){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Bomb1.1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==88){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Bomb1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==33){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Recon1.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else if(n==66){
				try {
					ImageIcon img = new ImageIcon(this.getClass().getResource("Recon2.jpg"));
					JButton btn = new JButton();
					btn.setBounds(100, 100, 95, 60);
					btn.setIcon(new ImageIcon(img.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.add(btn);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else {
				ImageIcon imagen = new ImageIcon(this.getClass().getResource("Cielo.jpg"));
				JButton btn = new JButton();
				btn.setBounds(100, 100, 95, 60);
				btn.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				btns.add(btn);
			}
	}
	private void AñadirOpciones1(JComboBox x) {
		x.addItem("Caza1JUG1");
		x.addItem("Caza2JUG1");
		x.addItem("Caza3JUG1");
		x.addItem("ReconocimientoJUG1");
		x.addItem("BombarderoJUG1");
		x.addItem("Base PrincipalJUG1");
		x.addItem("Base Secundaria1JUG1");
		x.addItem("Base Secundaria2JUG1");
	}
	private void AñadirOpciones2(JComboBox x) {
		x.addItem("Caza1JUG2");
		x.addItem("Caza2JUG2");
		x.addItem("Caza3JUG2");
		x.addItem("ReconocimientoJUG2");
		x.addItem("BombarderoJUG2");
		x.addItem("Base PrincipalJUG2");
		x.addItem("Base Secundaria1JUG2");
		x.addItem("Base Secundaria2JUG2");
	}
    private class Listener implements ActionListener{
    	private int numero;
    	private int posIni;
    	public Listener() {
    		
    	}
    	public Listener(int n) {
    		numero = n;
    	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btns.get(numero) && comprob==0) {
				VerificarMapa(numero);
				comprob=0;
			}
			if(e.getSource()==op1 && comprob==0 && turno==0) {
				mov.Modificacion(""+op1.getSelectedItem());
				comprob=1;
			}
			if(e.getSource()==op2 && comprob==0 && turno==1) {
				mov.Modificacion(""+op2.getSelectedItem());
				comprob=4;
			}
			if(e.getSource()==btns.get(numero) && comprob==1) {
				numAvi = ComprobarPosicionXAvion(""+op1.getSelectedItem());
				if(Restricciones1(numero,numAvi)==1) {
					MoverHacia(numAvi);
					comprob=2;
				}
				else if(Restricciones1(numero,numAvi)==2){
					nomAviAlia = ComprobarAvionXPosicion(numAvi);
					nomAviEnemy = ComprobarAvionXPosicion(numero);
					comprob = BatallaAerea(nomAviAlia,nomAviEnemy);
					
				}
				else if(Restricciones1(numero,numAvi)==3){
					BatallaEstructuras();
				}
				else {
					JOptionPane.showMessageDialog(null, "Movimiento no valido seleccione otra casilla");
				}
			}
			if(e.getSource()==btns.get(numero) && comprob==2) {
				if(Restricciones1(numero,numAvi)==1) {
					AvionMovimiento1(numero,numAvi);
					comprob=0;
					turno=1;
					JOptionPane.showMessageDialog(null, "Turno del jugador 2");
				}
			}
			if(e.getSource()==btns.get(numero) && comprob==4) {
				numAvi = ComprobarPosicionXAvion(""+op2.getSelectedItem());
				if(Restricciones2(numero,numAvi)==1) {
					MoverHacia(numAvi);
					comprob=5;
				}
				else if(Restricciones2(numero,numAvi)==2){
					nomAviAlia = ComprobarAvionXPosicion(numAvi);
					nomAviEnemy = ComprobarAvionXPosicion(numero);
					comprob = BatallaAerea(nomAviAlia,nomAviEnemy);
					comprob = comprob+3;
				}
				else if(Restricciones2(numero,numAvi)==3){
					BatallaEstructuras();
				}
				else {
					JOptionPane.showMessageDialog(null, "Movimiento no valido seleccione otra casilla");
				}
			}
			if(e.getSource()==btns.get(numero) && comprob==5) {
				if(Restricciones2(numero,numAvi)==1) {
					AvionMovimiento2(numero,numAvi);
					comprob=0;
					turno=0;
					JOptionPane.showMessageDialog(null, "Turno del jugador 1");
				}
			}
		}
		public void VerificarMapa(int n) {
			if(n==0) {
				if(cont[0]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Base P");
					cont[0]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseP1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[0]--;
				}
			}
			else if(n==4) {
				if(cont[1]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("BaseS1");
					cont[1]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseSe.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[1]--;
				}
			}
			else if(n==40) {
				if(cont[2]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("BaseS2");
					cont[2]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseSe.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[2]--;
				}
			}
			else if(n==99) {
				if(cont[3]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Base P");
					cont[3]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseP2.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[3]--;
				}
			}
			else if(n==95) {
				if(cont[4]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("BaseS1");
					cont[4]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseSe2.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[4]--;
				}
			}
			else if(n==59) {
				if(cont[5]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("BaseS2");
					cont[5]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("BaseSe2.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[5]--;
				}
			}
			else if(n==pC1x1){
				if(cont[6]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 1");
					cont[6]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[6]--;
				}
			}
			else if(n==pC2x1){
				if(cont[7]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 2");
					cont[7]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[7]--;
				}
			}
			else if(n==pC3x1){
				if(cont[8]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 3");
					cont[8]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[8]--;
				}
			}
			else if(n==pC1x2){
				if(cont[9]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 1");
					cont[9]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[9]--;
				}
			}
			else if(n==pC2x2){
				if(cont[10]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 2");
					cont[10]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[10]--;
				}
			}
			else if(n==pC3x2){
				if(cont[11]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Caza 3");
					cont[11]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[11]--;
				}
			}
			else if(n==pB1x1){
				if(cont[12]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Bomb 1");
					cont[12]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Bomb1.1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[12]--;
				}
			}
			else if(n==pB1x2){
				if(cont[13]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Bomb 1");
					cont[13]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Bomb1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[13]--;
				}
			}
			else if(n==pR1x1){
				if(cont[14]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Recon 1");
					cont[14]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Recon1.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[14]--;
				}
			}
			else if(n==pR1x2){
				if(cont[15]%2==0) {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource(""));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					btns.get(numero).setText("Recon 1");
					cont[15]++;
				}
				else {
					ImageIcon imagen = new ImageIcon(this.getClass().getResource("Recon2.jpg"));
					btns.get(numero).setIcon(new ImageIcon(imagen.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
					cont[15]--;
				}
			}
		}
		public int ComprobarPosicionXAvion(String n) {
			int num=0;
			if(n.equals("Caza1JUG1")) {
				num = pC1x1;
			}
			if(n.equals("Caza2JUG1")) {
				num = pC2x1;
			}
			if(n.equals("Caza3JUG1")) {
				num = pC3x1;
			}
			if(n.equals("Caza1JUG2")) {
				num = pC1x2;
			}
			if(n.equals("Caza2JUG2")) {
				num = pC2x2;
			}
			if(n.equals("Caza3JUG2")) {
				num = pC3x2;
			}
			if(n.equals("ReconocimientoJUG1")) {
				num = pR1x1;
			}
			if(n.equals("ReconocimientoJUG2")) {
				num = pR1x2;
			}
			if(n.equals("BombarderoJUG1")) {
				num = pB1x1;
			}
			if(n.equals("BombarderoJUG2")) {
				num = pB1x2;
			}
			return num;
		}
		public String ComprobarAvionXPosicion(int n) {
			String avi="";
			if(n==pC1x1) {
				avi="Caza1JUG1";
			}
			if(n==pC2x1) {
				avi="Caza2JUG1";
			}
			if(n==pC3x1) {
				avi="Caza3JUG1";
			}
			if(n==pC1x2) {
				avi="Caza1JUG2";
			}
			if(n==pC2x2) {
				avi="Caza2JUG2";
			}
			if(n==pC3x2) {
				avi="Caza3JUG2";
			}
			if(n==pB1x1) {
				avi="BombarderoJUG1";
			}
			if(n==pB1x2) {
				avi="BombarderoJUG2";
			}
			if(n==pR1x1) {
				avi="ReconocimientoJUG1";
			}
			if(n==pR1x2) {
				avi="ReconocimientoJUG2";
			}
			return avi;
		}
		public void MoverHacia(int n) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource("Cielo.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
		}
		
		public int Restricciones1(int a,int b) {
			if(a==b-11||a==b-10||a==b-9||a==b-1||a==b+1||a==b+9||a==b+10||a==b+11) {
				if(a%10==0) {
					if(a==b-11||a==b-1||a==b+9)
						return 0;
					else 
						return 1;
				}
				else if(a%10==9) {
					if(a==b-9||a==b+1||a==b+11)
						return 0;
					else {
						return 1;
					}
				}
				else if(a==pC1x1||a==pC2x1||a==pC3x1||a==pB1x1||a==pR1x1||a==0||a==4||a==40)
					return 0;
				else if(a==pC1x2||a==pC2x2||a==pC3x2||a==pB1x2||a==pR1x2)
					return 2;
				else if(a==99||a==95||a==59)
					return 3;
				else
					return 1;
			}
			else
				return 0;
		}
		public void AvionMovimiento1(int n,int avion) {
			if(avion==pC1x1||avion==pC2x1||avion==pC3x1) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Caza1.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				if(avion==pC1x1)
					pC1x1 = n;
				if(avion==pC2x1)
					pC2x1 = n;
				if(avion==pC3x1)
					pC3x1 = n;
			}
			if(avion==pB1x1) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Bomb1.1.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				pB1x1 = n;
			}
			if(avion==pR1x1) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Recon1.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				pR1x1 = n;
			}
		}
		
		public int Restricciones2(int a,int b) {
			if(a==b-11||a==b-10||a==b-9||a==b-1||a==b+1||a==b+9||a==b+10||a==b+11) {
				if(a%10==0) {
					if(a==b-11||a==b-1||a==b+9)
						return 0;
					else
						return 1;
				}
				else if(a%10==9) {
					if(a==b-9||a==b+1||a==b+11)
						return 0;
					else
						return 1;
				}
				else if(a==pC1x2||a==pC2x2||a==pC3x2||a==pB1x2||a==pR1x2||a==99||a==95||a==59)
					return 0;
				else if(a==pC1x1||a==pC2x1||a==pC3x1||a==pB1x1||a==pR1x1)
					return 2;
				else if(a==0||a==4||a==40)
					return 3;
				else
					return 1;
			}
			else
				return 0;
		}
		public void AvionMovimiento2(int n,int avion) {
			if(avion==pC1x2||avion==pC2x2||avion==pC3x2) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Caza2.jpeg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				if(avion==pC1x2)
					pC1x2 = n;
				if(avion==pC2x2)
					pC2x2 = n;
				if(avion==pC3x2)
					pC3x2 = n;
			}
			if(avion==pB1x2) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Bomb1.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				pB1x2 = n;
			}
			if(avion==pR1x2) {
				ImageIcon imagen1 = new ImageIcon(this.getClass().getResource(""));
				btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("Recon2.jpg"));
				btns.get(n).setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
				pR1x2 = n;
			}
		}
    
		public int BatallaAerea(String a,String b) {
			mov.Batalla(a,b);
			if(mov.getGanador().equals(a)) {
				ColocarCielo(numero);
				BorrarAvion(b);
			}
			if(mov.getGanador().equals(b)) {
				ColocarCielo(numAvi);
				BorrarAvion(a);
			}
			return 1;
		}
		public void BatallaEstructuras() {
			
		}
		public void ColocarCielo(int n) {
			ImageIcon imagen1 = new ImageIcon(this.getClass().getResource("Cielo.jpg"));
			btns.get(n).setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(95,60,Image.SCALE_SMOOTH)));
			
		}
		public void BorrarAvion(String n) {
			if(n.equals("Caza1JUG1")) {
				op1.removeItemAt(0);
				jug1.add(op1);
				pC1x1 = 100;
			}
			if(n.equals("Caza2JUG1")) {
				op1.removeItemAt(1);
				jug1.add(op1);
				pC2x1 = 100;
			}
			if(n.equals("Caza3JUG1")) {
				op1.removeItemAt(2);
				jug1.add(op1);
				pC3x1 = 100;
			}
			if(n.equals("Caza1JUG2")) {
				op2.removeItemAt(0);
				jug2.add(op2);
				pC1x2 = 100;
			}
			if(n.equals("Caza2JUG2")) {
				op2.removeItemAt(1);
				jug2.add(op2);
				pC2x2 = 100;
			}
			if(n.equals("Caza3JUG2")) {
				op2.removeItemAt(2);
				jug2.add(op2);
				pC3x2 = 100;
			}
			if(n.equals("ReconocimientoJUG1")) {
				op1.removeItemAt(4);
				jug1.add(op1);
				pR1x1 = 100;
			}
			if(n.equals("ReconocimientoJUG2")) {
				op2.removeItemAt(4);
				jug2.add(op2);
				pR1x2 = 100;
			}
			if(n.equals("BombarderoJUG1")) {
				op1.removeItemAt(3);
				jug1.add(op1);
				pB1x1 = 100;
			}
			if(n.equals("BombarderoJUG2")) {
				op2.removeItemAt(3);
				jug2.add(op2);
				pB1x2 = 100;
			}
		}
    }
	public static void main(String[]args) {
		new AirWar().setVisible(true);;
	}
}
