package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelPsiquico extends JPanel {

	private JLabel lblProyeccionPsiquica, lblInnatos, lblCVS;
	private JTextField txtProyeccionPsiquica, txtInnatos, txtCVS;
	private JButton btnModificar;
	private VentanaDatos ventanaDatos;
	
	public PanelPsiquico(VentanaDatos ventanaDatos, Personaje personaje) {
		this.lblProyeccionPsiquica = new JLabel("Potencial Psiquico: " + personaje.getProyeccionPsiquica());
		this.lblCVS = new JLabel("CV Libres: " + personaje.getCVS());
		this.lblInnatos = new JLabel("Innatos: " + personaje.getInnatos());
		this.txtProyeccionPsiquica = new JTextField("Proyeccion Psiquica");
		this.txtCVS = new JTextField("CV libres");
		this.txtInnatos = new JTextField("Innatos");
		this.btnModificar = new JButton("Modificar datos");
		this.btnModificar.setActionCommand(VentanaDatos.MODIFICAR_PSIQUICO);
		this.btnModificar.addActionListener(ventanaDatos);
		this.setLayout(new GridLayout(4,1));
		this.add(lblProyeccionPsiquica);
		this.add(lblCVS);
		this.add(lblInnatos);
		this.add(btnModificar);
		this.setBorder(new TitledBorder("Psiquico"));
		this.setVisible(true);
	}
	
	public void labelATextField() {
		this.remove(lblProyeccionPsiquica);
		this.remove(lblCVS);
		this.remove(lblInnatos);
		this.btnModificar.setText("Guardar datos");
		this.btnModificar.setActionCommand(VentanaDatos.GUARDAR_PSIQUICO);
		this.remove(btnModificar);
		this.add(txtProyeccionPsiquica);
		this.add(txtCVS);
		this.add(txtInnatos);
		this.add(btnModificar);
		revalidate();
		repaint();
	}
	
	public void textFieldALabel(Personaje personaje) {
		if(txtProyeccionPsiquica.getText().equals("Proyeccion Psiquica") == false) {
			personaje.setProyeccionPsiquica(Integer.parseInt(txtProyeccionPsiquica.getText()));
		}
		if(txtCVS.getText().equals("CV libres") == false) {
			personaje.setCVS(Integer.parseInt(txtCVS.getText()));
		}
		if(txtInnatos.getText().equals("Innatos") == false) {
			personaje.setInnatos(Integer.parseInt(txtInnatos.getText()));
		}
		this.lblProyeccionPsiquica = new JLabel("Potencial Psiquico: " + personaje.getProyeccionPsiquica());
		this.lblCVS = new JLabel("CV Libres: " + personaje.getCVS());
		this.lblInnatos = new JLabel("Innatos: " + personaje.getInnatos());
		this.remove(txtProyeccionPsiquica);
		this.remove(txtCVS);
		this.remove(txtInnatos);
		this.btnModificar.setActionCommand(VentanaDatos.MODIFICAR_PSIQUICO);
		this.btnModificar.setText("Modificar datos");
		this.remove(btnModificar);
		this.add(lblProyeccionPsiquica);
		this.add(lblCVS);
		this.add(lblInnatos);
		this.add(btnModificar);
		revalidate();
		repaint();
	}
}
