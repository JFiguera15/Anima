package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelMistico extends JPanel {

	private JLabel lblXeon, lblAct, lblProyeccionMagica, lblNivelMagia;
	private VentanaDatos ventanaDatos;
	private JButton btnModificarMistico;
	private JTextField txtXeon, txtAct, txtProyeccionMagica, txtNivelMagia;
	
	public PanelMistico(VentanaDatos ventanaDatos, Personaje personaje) {
		this.ventanaDatos = ventanaDatos;
		this.btnModificarMistico = new JButton("Modificar datos");
		this.btnModificarMistico.setActionCommand(VentanaDatos.MODIFICAR_MISTICO);
		this.btnModificarMistico.addActionListener(ventanaDatos);
		this.txtXeon = new JTextField("Xeon");
		this.txtAct = new JTextField("ACT");
		this.txtProyeccionMagica = new JTextField("Proyeccion magica");
		this.txtNivelMagia = new JTextField("Nivel de magia");
		this.lblXeon = new JLabel("Xeon:" + personaje.getXeon());
		this.lblAct = new JLabel("ACT: " + personaje.getAct());
		this.lblProyeccionMagica = new JLabel("Proyeccion Magica: " + personaje.getProyeccionMagica());
		this.lblNivelMagia = new JLabel("Nivel de magia: " + personaje.getNivelMagia());
		this.setLayout(new GridLayout(5,1));
		this.setBorder(new TitledBorder("Mistico"));
		this.add(lblXeon);
		this.add(lblAct);
		this.add(lblProyeccionMagica);
		this.add(lblNivelMagia);
		this.add(btnModificarMistico);
	}
	
	public void lblATxtField() {
		this.removeAll();
		this.btnModificarMistico.setText("Guardar datos");
		this.btnModificarMistico.setActionCommand(VentanaDatos.GUARDAR_MISTICO);
		this.add(txtXeon);
		this.add(txtAct);
		this.add(txtProyeccionMagica);
		this.add(txtNivelMagia);
		this.add(btnModificarMistico);
		revalidate();
		repaint();
	}
	
	public void txtFieldALbl(Personaje personaje) {
		this.removeAll();
		if (txtXeon.getText().equals("Xeon") == false) {
			personaje.setXeon(Integer.parseInt(txtXeon.getText()));
		}
		if (txtAct.getText().equals("ACT") == false) {
			personaje.setAct(Integer.parseInt(txtAct.getText()));
		}
		
		if (txtProyeccionMagica.getText().equals("Proyeccion magica") == false) {
			personaje.setProyeccionMagica(Integer.parseInt(txtProyeccionMagica.getText()));
		}
		
		if (txtNivelMagia.getText().equals("Nivel de magia") == false) {
			personaje.setNivelMagia(Integer.parseInt(txtNivelMagia.getText()));
		}
		
		this.lblXeon.setText("Xeon: " + personaje.getXeon());
		this.lblAct.setText("ACT: " + personaje.getAct());
		this.lblProyeccionMagica.setText("Proyeccion magica: " + personaje.getProyeccionMagica());
		this.lblNivelMagia.setText("Nivel de magia: " + personaje.getNivelMagia());
		this.btnModificarMistico.setActionCommand(VentanaDatos.GUARDAR_MISTICO);
		this.btnModificarMistico.setText("Modificar datos");
		this.add(lblXeon);
		this.add(lblAct);
		this.add(lblProyeccionMagica);
		this.add(lblNivelMagia);
		this.add(btnModificarMistico);
		revalidate();
		repaint();
		
	}
}
