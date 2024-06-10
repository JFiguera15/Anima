package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Personaje;

public class PanelCaracteristicas extends JPanel {

	private JLabel[] caracteristicas, bonoCaracteristicas, resistencia;
	private JTextField[] txtCaracteristicas, txtBono, txtResistencias;
	private JButton btnModificarCaracteristicas;
	private VentanaDatos ventanaDatos;


	public PanelCaracteristicas(VentanaDatos ventanaDatos, Personaje personaje) {
		this.ventanaDatos = ventanaDatos;
		this.caracteristicas = new JLabel[Personaje.NUMERO_CARACTERISTICAS];
		this.bonoCaracteristicas = new JLabel[Personaje.NUMERO_CARACTERISTICAS];
		this.resistencia = new JLabel[Personaje.NUMERO_RESISTENCIAS];
		this.txtCaracteristicas = new JTextField[Personaje.NUMERO_CARACTERISTICAS];
		this.txtBono = new JTextField[Personaje.NUMERO_CARACTERISTICAS];
		this.txtResistencias = new JTextField[Personaje.NUMERO_RESISTENCIAS];
		this.btnModificarCaracteristicas =  new JButton("Modificar datos.");
		this.btnModificarCaracteristicas.setActionCommand(VentanaDatos.MODIFICAR_CARACTERISTICAS);
		this.btnModificarCaracteristicas.addActionListener(ventanaDatos);
		this.caracteristicas[0] = new JLabel("AGI: " + personaje.getCaracteristicas()[0]);
		this.caracteristicas[1] = new JLabel("CON: " + personaje.getCaracteristicas()[1]);
		this.caracteristicas[2] = new JLabel("DES: " + personaje.getCaracteristicas()[2]);
		this.caracteristicas[3] = new JLabel("FUE: " + personaje.getCaracteristicas()[3]);
		this.caracteristicas[4] = new JLabel("INT: " + personaje.getCaracteristicas()[4]);
		this.caracteristicas[5] = new JLabel("PER: " + personaje.getCaracteristicas()[5]);
		this.caracteristicas[6] = new JLabel("POD: " + personaje.getCaracteristicas()[6]);
		this.caracteristicas[7] = new JLabel("VOL: " + personaje.getCaracteristicas()[7]);
		this.bonoCaracteristicas[0] = new JLabel(" Bono AGI: " + personaje.getBonoCaracteristicas()[0]);
		this.bonoCaracteristicas[1] = new JLabel(" Bono CON: " + personaje.getBonoCaracteristicas()[1]);
		this.bonoCaracteristicas[2] = new JLabel(" Bono DES: " + personaje.getBonoCaracteristicas()[2]);
		this.bonoCaracteristicas[3] = new JLabel(" Bono FUE: " + personaje.getBonoCaracteristicas()[3]);
		this.bonoCaracteristicas[4] = new JLabel(" Bono INT: " + personaje.getBonoCaracteristicas()[4]);
		this.bonoCaracteristicas[5] = new JLabel(" Bono PER: " + personaje.getBonoCaracteristicas()[5]);
		this.bonoCaracteristicas[6] = new JLabel(" Bono POD: " + personaje.getBonoCaracteristicas()[6]);
		this.bonoCaracteristicas[7] = new JLabel(" Bono VOL: " + personaje.getBonoCaracteristicas()[7]);
		this.resistencia[0] = new JLabel(" RF: " + personaje.getResistencias()[0]);
		this.resistencia[1] = new JLabel(" RE: " + personaje.getResistencias()[1]);
		this.resistencia[2] = new JLabel(" RV: " + personaje.getResistencias()[2]);
		this.resistencia[3] = new JLabel(" RM: " + personaje.getResistencias()[3]);
		this.resistencia[4] = new JLabel(" RP: " + personaje.getResistencias()[4]);
		this.txtCaracteristicas[0] = new JTextField("AGI");
		this.txtCaracteristicas[1] = new JTextField("CON");
		this.txtCaracteristicas[2] = new JTextField("DES");
		this.txtCaracteristicas[3] = new JTextField("FUE");
		this.txtCaracteristicas[4] = new JTextField("INT");
		this.txtCaracteristicas[5] = new JTextField("PER");
		this.txtCaracteristicas[6] = new JTextField("POD");
		this.txtCaracteristicas[7] = new JTextField("VOL");
		this.txtBono[0] = new JTextField("AGI");
		this.txtBono[1] = new JTextField("CON");
		this.txtBono[2] = new JTextField("DES");
		this.txtBono[3] = new JTextField("FUE");
		this.txtBono[4] = new JTextField("INT");
		this.txtBono[5] = new JTextField("PER");
		this.txtBono[6] = new JTextField("POD");
		this.txtBono[7] = new JTextField("VOL");
		this.txtResistencias[0] = new JTextField("RF");
		this.txtResistencias[1] = new JTextField("RE");
		this.txtResistencias[2] = new JTextField("RV");
		this.txtResistencias[3] = new JTextField("RM");
		this.txtResistencias[4] = new JTextField("RP");
		this.setLayout(new GridLayout(Personaje.NUMERO_CARACTERISTICAS, 3));
		for (int i = 0; i < Personaje.NUMERO_CARACTERISTICAS; i++) {
			this.add(caracteristicas[i]);
			this.add(bonoCaracteristicas[i]);
			if (i < Personaje.NUMERO_RESISTENCIAS) {
				this.add(resistencia[i]);
			} else if (i == 5){
				this.add(btnModificarCaracteristicas);
			} else {
				this.add(new JLabel(""));
			}
		}
		this.setVisible(true);
	}
	
	public void modificarCaracteristicas() {
		this.removeAll();
		this.btnModificarCaracteristicas.setText("Guardar datos");
		this.btnModificarCaracteristicas.setActionCommand(VentanaDatos.GUARDAR_CARACTERISTICAS);
		for (int i = 0; i < Personaje.NUMERO_CARACTERISTICAS; i++) {
			this.add(txtCaracteristicas[i]);
			this.add(txtBono[i]);
			if (i < Personaje.NUMERO_RESISTENCIAS) {
				this.add(txtResistencias[i]);
			} else if (i == 5){
				this.add(btnModificarCaracteristicas);
			} else {
				this.add(new JLabel(""));
			}
		}
		this.revalidate();
		this.repaint();
	}
	
	public void guardarCaracteristicas(Personaje personaje) {
		this.removeAll();
		this.btnModificarCaracteristicas.setText("Modificar datos");
		this.btnModificarCaracteristicas.setActionCommand(VentanaDatos.MODIFICAR_CARACTERISTICAS);
		for (int i = 0; i < Personaje.NUMERO_CARACTERISTICAS; i++) {
			if(txtCaracteristicas[i].getText().equals("AGI") == false && txtCaracteristicas[i].getText().equals("CON") == false
					&& txtCaracteristicas[i].getText().equals("DES") == false && txtCaracteristicas[i].getText().equals("FUE") == false
					&& txtCaracteristicas[i].getText().equals("INT") == false && txtCaracteristicas[i].getText().equals("PER") == false
					&& txtCaracteristicas[i].getText().equals("POD") == false && txtCaracteristicas[i].getText().equals("VOL") == false) {
				personaje.getCaracteristicas()[i] = Integer.parseInt(txtCaracteristicas[i].getText());
			}
			
			if(txtBono[i].getText().equals("AGI") == false && txtBono[i].getText().equals("CON") == false
					&& txtBono[i].getText().equals("DES") == false && txtBono[i].getText().equals("FUE") == false
					&& txtBono[i].getText().equals("INT") == false && txtBono[i].getText().equals("PER") == false
					&& txtBono[i].getText().equals("POD") == false && txtBono[i].getText().equals("VOL") == false) {
				personaje.getBonoCaracteristicas()[i] = Integer.parseInt(txtBono[i].getText());
			}
		}
		
		for (int i = 0; i < Personaje.NUMERO_RESISTENCIAS; i++) {
			if (txtResistencias[i].getText().equals("RF") == false && txtResistencias[i].getText().equals("RE") == false 
				&& txtResistencias[i].getText().equals("RV") == false && txtResistencias[i].getText().equals("RM") == false
						&& txtResistencias[i].getText().equals("RP") == false) {
				personaje.getResistencias()[i] = Integer.parseInt(txtResistencias[i].getText());
			}
		}
		
		this.caracteristicas[0] = new JLabel("AGI: " + personaje.getCaracteristicas()[0]);
		this.caracteristicas[1] = new JLabel("CON: " + personaje.getCaracteristicas()[1]);
		this.caracteristicas[2] = new JLabel("DES: " + personaje.getCaracteristicas()[2]);
		this.caracteristicas[3] = new JLabel("FUE: " + personaje.getCaracteristicas()[3]);
		this.caracteristicas[4] = new JLabel("INT: " + personaje.getCaracteristicas()[4]);
		this.caracteristicas[5] = new JLabel("PER: " + personaje.getCaracteristicas()[5]);
		this.caracteristicas[6] = new JLabel("POD: " + personaje.getCaracteristicas()[6]);
		this.caracteristicas[7] = new JLabel("VOL: " + personaje.getCaracteristicas()[7]);
		this.bonoCaracteristicas[0] = new JLabel(" Bono AGI: " + personaje.getBonoCaracteristicas()[0]);
		this.bonoCaracteristicas[1] = new JLabel(" Bono CON: " + personaje.getBonoCaracteristicas()[1]);
		this.bonoCaracteristicas[2] = new JLabel(" Bono DES: " + personaje.getBonoCaracteristicas()[2]);
		this.bonoCaracteristicas[3] = new JLabel(" Bono FUE: " + personaje.getBonoCaracteristicas()[3]);
		this.bonoCaracteristicas[4] = new JLabel(" Bono INT: " + personaje.getBonoCaracteristicas()[4]);
		this.bonoCaracteristicas[5] = new JLabel(" Bono PER: " + personaje.getBonoCaracteristicas()[5]);
		this.bonoCaracteristicas[6] = new JLabel(" Bono POD: " + personaje.getBonoCaracteristicas()[6]);
		this.bonoCaracteristicas[7] = new JLabel(" Bono VOL: " + personaje.getBonoCaracteristicas()[7]);
		this.resistencia[0] = new JLabel(" RF: " + personaje.getResistencias()[0]);
		this.resistencia[1] = new JLabel(" RE: " + personaje.getResistencias()[1]);
		this.resistencia[2] = new JLabel(" RV: " + personaje.getResistencias()[2]);
		this.resistencia[3] = new JLabel(" RM: " + personaje.getResistencias()[3]);
		this.resistencia[4] = new JLabel(" RP: " + personaje.getResistencias()[4]);
		for (int i = 0; i < Personaje.NUMERO_CARACTERISTICAS; i++) {
			this.add(caracteristicas[i]);
			this.add(bonoCaracteristicas[i]);
			if (i < Personaje.NUMERO_RESISTENCIAS) {
				this.add(resistencia[i]);
			} else if (i == 5){
				this.add(btnModificarCaracteristicas);
			} else {
				this.add(new JLabel(""));
			}
		}
		this.revalidate();
		this.repaint();
	}
}
