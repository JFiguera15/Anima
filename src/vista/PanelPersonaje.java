package vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelPersonaje extends JPanel{
	protected JLabel[] caracteristicas;
	protected JButton btnVerDatosDetallados;
	
	 public PanelPersonaje(Personaje personaje) {
		caracteristicas = new JLabel[PanelDatosPersonaje.INFO_PERSONAJES];
		this.setLayout(new GridLayout(1, PanelDatosPersonaje.INFO_PERSONAJES));
		btnVerDatosDetallados = new JButton("Ver datos detallados.");
		this.btnVerDatosDetallados.setActionCommand(personaje.getNombre());
		this.setBorder(new TitledBorder(personaje.getNombre()));
		caracteristicas[0] = new JLabel("PV: " + personaje.getVida());
		caracteristicas[1] = new JLabel("Turno: " + personaje.getTurno());
		caracteristicas[2] = new JLabel("Presencia: " + personaje.getPresencia());
		caracteristicas[3] = new JLabel("RF: " + personaje.getResistencias()[0]);
		caracteristicas[4] = new JLabel("RE: " + personaje.getResistencias()[1]);
		caracteristicas[5] = new JLabel("RV: " + personaje.getResistencias()[2]);
		caracteristicas[6] = new JLabel("RM: " + personaje.getResistencias()[3]);
		caracteristicas[7] = new JLabel("RP: " + personaje.getResistencias()[4]);
		for (int i = 0; i < caracteristicas.length; i++) {
			this.add(caracteristicas[i]);
		}
		this.add(btnVerDatosDetallados);
		this.setVisible(true);
	}

	public JButton getBtnVerDatosDetallados() {
		return btnVerDatosDetallados;
	}
	  
}
