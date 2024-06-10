package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Personaje;

public class PanelPersonajeDatos extends JPanel{

	private JLabel nombre, vida, nivel, xp, cansancio, turno, presencia, dinero;
	private JTextField txtNombre, txtVida, txtNivel, txtXp, txtCansancio, txtTurno, txtPresencia, txtDinero;
	private JButton btnModificarPrincipal, btnCombate;
	private VentanaDatos ventanaDatos;

	public PanelPersonajeDatos(VentanaDatos ventanaDatos, Personaje personaje) {
		this.ventanaDatos = ventanaDatos;
		this.nombre = new JLabel(personaje.getNombre());
		this.vida = new JLabel("Puntos de vida: " + personaje.getVida());
		this.nivel = new JLabel("Nivel: " + personaje.getNivel());
		this.xp = new JLabel("Puntos de experiencia: " + personaje.getXp());
		this.cansancio = new JLabel("Puntos de cansancio: " + personaje.getCansancio());
		this.turno = new JLabel("Turno natural: " + personaje.getTurno());
		this.presencia = new JLabel("Presencia: " + personaje.getPresencia());
		this.txtNombre = new JTextField("Nombre");
		this.txtVida = new JTextField("Puntos de vida");
		this.txtNivel = new JTextField("Nivel");
		this.txtXp = new JTextField("Puntos de experiencia");
		this.txtCansancio = new JTextField("Puntos de cansancio");
		this.txtTurno = new JTextField("Turno natural");
		this.txtPresencia = new JTextField("Presencia");
		this.btnModificarPrincipal = new JButton("Modificar datos");
		this.btnModificarPrincipal.setActionCommand(VentanaDatos.MODIFICAR_PRINCIPAL);
		this.btnModificarPrincipal.addActionListener(ventanaDatos);
		this.btnCombate = new JButton("Datos de combate");
		this.btnCombate.setActionCommand(VentanaDatos.VER_COMBATE);
		this.btnCombate.addActionListener(ventanaDatos);
		this.setLayout(new GridLayout(9, 1));
		this.add(nombre);
		this.add(vida);
		this.add(nivel);
		this.add(xp);
		this.add(cansancio);
		this.add(turno);
		this.add(presencia);
		this.add(btnModificarPrincipal);
		this.add(btnCombate);
		this.setVisible(true);
	}

	public void modificarDatosPrincipales() {
		this.removeAll();
		this.add(txtNombre);
		this.add(txtVida);
		this.add(txtNivel);
		this.add(txtXp);
		this.add(txtCansancio);
		this.add(txtTurno);
		this.add(txtPresencia);
		this.btnModificarPrincipal.setActionCommand(VentanaDatos.GUARDAR_PRINCIPAL);
		this.btnModificarPrincipal.setText("Guardar datos");
		this.add(btnModificarPrincipal);
		this.add(new JLabel(""));
		revalidate();
		repaint();
	}

	public void guardarDatosPrincipales(Personaje personaje) {
		this.removeAll();
		if (txtNombre.getText().equals("Nombre") == false) {
			personaje.setNombre(txtNombre.getText());
		} 
		if (txtVida.getText().equals("Puntos de vida") == false) {
			personaje.setVida(Integer.parseInt(txtVida.getText()));
		} 
		if (txtNivel.getText().equals("Nivel") == false) {
			personaje.setNivel(Integer.parseInt(txtNivel.getText()));
		}
		if (txtXp.getText().equals("Puntos de experiencia") == false) {
			personaje.setXp(Integer.parseInt(txtXp.getText()));
		}
		if (txtCansancio.getText().equals("Puntos de cansancio") == false) {
			personaje.setCansancio(Integer.parseInt(txtCansancio.getText()));
		}
		if (txtTurno.getText().equals("Turno natural") == false) {
			personaje.setTurno(Integer.parseInt(txtTurno.getText()));
		}
		if (txtPresencia.getText().equals("Presencia") == false) {
			personaje.setPresencia(Integer.parseInt(txtPresencia.getText()));
		}
		this.nombre.setText(personaje.getNombre());
		this.vida.setText("Puntos de vida: " + personaje.getVida());
		this.nivel.setText("Nivel: " + personaje.getNivel());
		this.xp.setText("Puntos de experiencia: " + personaje.getXp());
		this.cansancio.setText("Puntos de cansancio: " + personaje.getCansancio());
		this.turno.setText("Turno natural: " + personaje.getTurno());
		this.presencia.setText("Presencia: " + personaje.getPresencia());
		this.btnModificarPrincipal.setText("Modificar datos");
		this.btnModificarPrincipal.setActionCommand(VentanaDatos.GUARDAR_PRINCIPAL);
		this.add(nombre);
		this.add(vida);
		this.add(nivel);
		this.add(xp);
		this.add(cansancio);
		this.add(turno);
		this.add(presencia);
		this.add(btnModificarPrincipal);
		this.add(btnCombate);
		revalidate();
		repaint();

	}

}
