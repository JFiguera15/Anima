package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Personaje;

public class PanelVentajas extends JPanel {

	private ArrayList<JLabel> ventajas, desventajas, posesiones;
	private JLabel lblVentajas, lblDesventajas, lblPosesiones;
	private VentanaDatos ventanaDatos;
	private JButton btnAgregarVentajas, btnAgregarDesventajas, btnAgregarPosesion, btnEliminarVentajas, btnEliminarDesventajas, btnEliminarPosesion;

	public PanelVentajas(VentanaDatos ventanaDatos, Personaje personaje) {
		this.ventanaDatos = ventanaDatos;
		this.lblVentajas = new JLabel("Ventajas:");
		this.lblDesventajas = new JLabel("Desventajas:");
		this.lblPosesiones = new JLabel("Posesiones:");
		this.btnAgregarVentajas = new JButton("Agregar ventaja");
		this.btnAgregarVentajas.setActionCommand(VentanaDatos.MODIFICAR_VENTAJAS);
		this.btnAgregarVentajas.addActionListener(ventanaDatos);
		this.btnEliminarVentajas = new JButton("Eliminar ventaja");
		this.btnEliminarVentajas.setActionCommand(VentanaDatos.ELIMINAR_VENTAJA);
		this.btnEliminarVentajas.addActionListener(ventanaDatos);
		this.btnAgregarDesventajas = new JButton("Agregar desventaja");
		this.btnAgregarDesventajas.setActionCommand(VentanaDatos.AGREGAR_DESVENTAJA);
		this.btnAgregarDesventajas.addActionListener(ventanaDatos);
		this.btnEliminarDesventajas = new JButton("Eliminar desventaja");
		this.btnEliminarDesventajas.setActionCommand(VentanaDatos.ELIMINAR_DESVENTAJA);
		this.btnEliminarDesventajas.addActionListener(ventanaDatos);
		this.btnAgregarPosesion = new JButton("Agregar posesion");
		this.btnAgregarPosesion.setActionCommand(VentanaDatos.AGREGAR_POSESION);
		this.btnAgregarPosesion.addActionListener(ventanaDatos);
		this.btnEliminarPosesion = new JButton("Eliminar Posesion");
		this.btnEliminarPosesion.setActionCommand(VentanaDatos.ELIMINAR_POSESION);
		this.btnEliminarPosesion.addActionListener(ventanaDatos);
		this.posesiones = new ArrayList<JLabel>();
		this.ventajas = new ArrayList<JLabel>();
		this.desventajas = new ArrayList<JLabel>();
		this.dibujarPanel(personaje);
		this.setVisible(true);
	}
	
	public void agregarVentaja(Personaje personaje, String ventaja) {
		personaje.getVentajas().add(ventaja);
		ventajas.add(new JLabel(ventaja));
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void eliminarVentaja(Personaje personaje, int posicion) {
		personaje.getVentajas().remove(posicion);
		ventajas.remove(posicion);
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void agregarDesventaja(Personaje personaje, String desventaja) {
		personaje.getDesventajas().add(desventaja);
		desventajas.add(new JLabel(desventaja));
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void eliminarDesventaja(Personaje personaje, int posicion) {
		personaje.getDesventajas().remove(posicion);
		desventajas.remove(posicion);
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void agregarPosesion(Personaje personaje, String posesion) {
		personaje.getPosesiones().add(posesion);
		desventajas.add(new JLabel(posesion));
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void eliminarPosesion(Personaje personaje, int posicion) {
		personaje.getPosesiones().remove(posicion);
		posesiones.remove(posicion);
		this.dibujarPanel(personaje);
		revalidate();
		repaint();
	}
	
	public void dibujarPanel(Personaje personaje) {
		removeAll();
		this.setLayout(new GridLayout((posesiones.size() + ventajas.size() + desventajas.size() + 9), 1));
		this.add(lblVentajas);
		this.ventajas.clear();
		for (int i = 0; i < personaje.getVentajas().size(); i++) {
			this.ventajas.add(new JLabel(personaje.getVentajas().get(i)));
			this.add(ventajas.get(i));
		}
		this.add(btnAgregarVentajas);
		this.add(btnEliminarVentajas);
		this.add(lblDesventajas);
		this.desventajas.clear();
		for (int i = 0; i < personaje.getDesventajas().size(); i++) {
			this.desventajas.add(new JLabel(personaje.getDesventajas().get(i)));
			this.add(desventajas.get(i));
		}
		this.add(btnAgregarDesventajas);
		this.add(btnEliminarDesventajas);
		this.add(lblPosesiones);
		this.posesiones.clear();
		for (int i = 0; i < personaje.getPosesiones().size(); i++) {
			this.posesiones.add(new JLabel(personaje.getPosesiones().get(i)));
			this.add(posesiones.get(i));
		}
		this.add(btnAgregarPosesion);
		this.add(btnEliminarPosesion);
	}
}


