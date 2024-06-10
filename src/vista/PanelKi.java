package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelKi extends JPanel {

	private JLabel lblKi, lblKiAcumlado, lblAcumulacionki;
	private JLabel[] puntosKi, kiAcumulado, acumulacionKi;
	private JTextField[] txtPuntosKi, txtAcumulacion;
	private JButton btnModificarKi, btnCargarKi, btnReiniciarKi;
	private VentanaDatos ventanaDatos;

	public PanelKi(VentanaDatos ventanaDatos, Personaje personaje) {
		this.ventanaDatos = ventanaDatos;
		this.puntosKi = new JLabel[Personaje.NUMERO_KI];
		this.kiAcumulado = new JLabel[Personaje.NUMERO_KI];
		this.acumulacionKi = new JLabel[Personaje.NUMERO_KI];
		this.txtAcumulacion = new JTextField[Personaje.NUMERO_KI];
		this.txtPuntosKi = new JTextField[Personaje.NUMERO_KI];
		this.lblKi = new JLabel("Puntos de Ki");
		this.lblAcumulacionki = new JLabel("Acumulacion de Ki:");
		this.lblKiAcumlado = new JLabel("Ki acumulado");
		this.btnModificarKi = new JButton("Modificar datos");
		this.btnCargarKi = new JButton("Cargar ki");
		this.btnReiniciarKi = new JButton("Reiniciar ki cargado");
		this.btnModificarKi.setActionCommand(VentanaDatos.MODIFICAR_KI);
		this.btnModificarKi.addActionListener(ventanaDatos);
		this.btnCargarKi.setActionCommand(VentanaDatos.CARGAR_KI);
		this.btnCargarKi.addActionListener(ventanaDatos);
		this.btnReiniciarKi.setActionCommand(VentanaDatos.REINICIAR_KI);
		this.btnReiniciarKi.addActionListener(ventanaDatos);
		this.setLayout(new GridLayout(3, Personaje.NUMERO_KI + 2));
		this.txtPuntosKi[0] = new JTextField("FUE");
		this.txtPuntosKi[1] = new JTextField("DES");
		this.txtPuntosKi[2] = new JTextField("AGI");
		this.txtPuntosKi[3] = new JTextField("CON");
		this.txtPuntosKi[4] = new JTextField("POD");
		this.txtPuntosKi[5] = new JTextField("VOL");
		this.txtAcumulacion[0] = new JTextField("FUE");
		this.txtAcumulacion[1] = new JTextField("DES");
		this.txtAcumulacion[2] = new JTextField("AGI");
		this.txtAcumulacion[3] = new JTextField("CON");
		this.txtAcumulacion[4] = new JTextField("POD");
		this.txtAcumulacion[5] = new JTextField("VOL");
		this.puntosKi[0] = new JLabel("FUE: " + personaje.getPuntosKi()[0]);
		this.puntosKi[1] = new JLabel("DES: " + personaje.getPuntosKi()[1]);
		this.puntosKi[2] = new JLabel("AGI: " + personaje.getPuntosKi()[2]);
		this.puntosKi[3] = new JLabel("CON: " + personaje.getPuntosKi()[3]);
		this.puntosKi[4] = new JLabel("POD: " + personaje.getPuntosKi()[4]);
		this.puntosKi[5] = new JLabel("VOL: " + personaje.getPuntosKi()[5]);
		this.acumulacionKi[0] = new JLabel("FUE: " + personaje.getAcumulacionKi()[0]);
		this.acumulacionKi[1] = new JLabel("DES: " + personaje.getAcumulacionKi()[1]);
		this.acumulacionKi[2] = new JLabel("AGI: " + personaje.getAcumulacionKi()[2]);
		this.acumulacionKi[3] = new JLabel("CON: " + personaje.getAcumulacionKi()[3]);
		this.acumulacionKi[4] = new JLabel("POD: " + personaje.getAcumulacionKi()[4]);
		this.acumulacionKi[5] = new JLabel("VOL: " + personaje.getAcumulacionKi()[5]);
		this.kiAcumulado[0] = new JLabel("FUE: " + personaje.getKiAcumulado()[0]);
		this.kiAcumulado[1] = new JLabel("DES: " + personaje.getKiAcumulado()[1]);
		this.kiAcumulado[2] = new JLabel("AGI: " + personaje.getKiAcumulado()[2]);
		this.kiAcumulado[3] = new JLabel("CON: " + personaje.getKiAcumulado()[3]);
		this.kiAcumulado[4] = new JLabel("POD: " + personaje.getKiAcumulado()[4]);
		this.kiAcumulado[5] = new JLabel("VOL: " + personaje.getKiAcumulado()[5]);
		this.add(lblKi);
		for (int i = 0; i < puntosKi.length; i++) {
			this.add(puntosKi[i]);	
		}
		this.add(btnModificarKi);
		this.add(lblAcumulacionki);
		for (int i = 0; i < acumulacionKi.length; i++) {
			this.add(acumulacionKi[i]);
		}
		this.add(btnCargarKi);
		this.add(lblKiAcumlado);
		for (int i = 0; i < kiAcumulado.length; i++) {
			this.add(kiAcumulado[i]);	
		}
		this.add(btnReiniciarKi);
		this.setBorder(new TitledBorder("Ki"));
		this.setVisible(true);
	}

	public void modificarKi() {
		this.removeAll();
		this.btnModificarKi.setText("Guardar datos");
		this.btnModificarKi.setActionCommand(VentanaDatos.GUARDAR_KI);
		this.add(lblKi);
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			this.add(txtPuntosKi[i]);
		}
		this.add(btnModificarKi);
		this.add(lblAcumulacionki);
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			this.add(txtAcumulacion[i]);
		}
		this.add(new JLabel(""));
		this.add(lblKiAcumlado);
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			this.add(kiAcumulado[i]);
		}
		this.add(new JLabel(""));
		revalidate();
		repaint();
	}

	public void guardarKi(Personaje personaje) {
		this.removeAll();
		this.btnModificarKi.setText("Modificar datos");
		this.btnModificarKi.setActionCommand(VentanaDatos.MODIFICAR_KI);
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			if(txtPuntosKi[i].getText().equals("FUE") == false && txtPuntosKi[i].getText().equals("DES") == false
					&& txtPuntosKi[i].getText().equals("AGI") == false && txtPuntosKi[i].getText().equals("CON") == false
					&& txtPuntosKi[i].getText().equals("POD") == false && txtPuntosKi[i].getText().equals("VOL") == false) {
				personaje.getPuntosKi()[i] = Integer.parseInt(txtPuntosKi[i].getText());
			}
		}
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			if(txtAcumulacion[i].getText().equals("FUE") == false && txtAcumulacion[i].getText().equals("DES") == false
					&& txtAcumulacion[i].getText().equals("AGI") == false && txtAcumulacion[i].getText().equals("CON") == false
					&& txtAcumulacion[i].getText().equals("POD") == false && txtAcumulacion[i].getText().equals("VOL") == false) {
				personaje.getAcumulacionKi()[i] = Integer.parseInt(txtAcumulacion[i].getText());
			}
		}
		this.puntosKi[0] = new JLabel("FUE: " + personaje.getPuntosKi()[0]);
		this.puntosKi[1] = new JLabel("DES: " + personaje.getPuntosKi()[1]);
		this.puntosKi[2] = new JLabel("AGI: " + personaje.getPuntosKi()[2]);
		this.puntosKi[3] = new JLabel("CON: " + personaje.getPuntosKi()[3]);
		this.puntosKi[4] = new JLabel("POD: " + personaje.getPuntosKi()[4]);
		this.puntosKi[5] = new JLabel("VOL: " + personaje.getPuntosKi()[5]);
		this.acumulacionKi[0] = new JLabel("FUE: " + personaje.getAcumulacionKi()[0]);
		this.acumulacionKi[1] = new JLabel("DES: " + personaje.getAcumulacionKi()[1]);
		this.acumulacionKi[2] = new JLabel("AGI: " + personaje.getAcumulacionKi()[2]);
		this.acumulacionKi[3] = new JLabel("CON: " + personaje.getAcumulacionKi()[3]);
		this.acumulacionKi[4] = new JLabel("POD: " + personaje.getAcumulacionKi()[4]);
		this.acumulacionKi[5] = new JLabel("VOL: " + personaje.getAcumulacionKi()[5]);
		this.add(lblKi);
		for (int i = 0; i < puntosKi.length; i++) {
			this.add(puntosKi[i]);	
		}
		this.add(btnModificarKi);
		this.add(lblAcumulacionki);
		for (int i = 0; i < acumulacionKi.length; i++) {
			this.add(acumulacionKi[i]);
		}
		this.add(btnCargarKi);
		this.add(lblKiAcumlado);
		for (int i = 0; i < kiAcumulado.length; i++) {
			this.add(kiAcumulado[i]);	
		}
		this.add(btnReiniciarKi);
		revalidate();
		repaint();
	}
	public void cambiarKiAcumulado(Personaje personaje) {
		this.kiAcumulado[0].setText("FUE: " + personaje.getKiAcumulado()[0]);
		this.kiAcumulado[1].setText("DES: " + personaje.getKiAcumulado()[1]);
		this.kiAcumulado[2].setText("AGI: " + personaje.getKiAcumulado()[2]);
		this.kiAcumulado[3].setText("CON: " + personaje.getKiAcumulado()[3]);
		this.kiAcumulado[4].setText("POD: " + personaje.getKiAcumulado()[4]);
		this.kiAcumulado[5].setText("VOL: " + personaje.getKiAcumulado()[5]);
	}
}