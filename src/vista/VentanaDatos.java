package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Main;
import modelo.Personaje;

public class VentanaDatos extends JFrame implements ActionListener {

	public static final String MODIFICAR_PRINCIPAL = "modificar principal";
	public static final String MODIFICAR_CARACTERISTICAS = "modificar CARACTERISTICAS";
	public static final String MODIFICAR_VENTAJAS = "modificar VENTAJAS";
	public static final String AGREGAR_DESVENTAJAS = "modificar DESVENTAJAS";
	public static final String MODIFICAR_PSIQUICO = "modificar PSIQUICO";
	public static final String MODIFICAR_MISTICO = "modificar MISTICO";
	public static final String MODIFICAR_KI = "modificar KI";
	public static final String GUARDAR_PRINCIPAL = "GUARDAR principal";
	public static final String GUARDAR_CARACTERISTICAS = "GUARDAR CARACTERISTICAS";
	public static final String ELIMINAR_VENTAJA = "GUARDAR VENTAJAS";
	public static final String GUARDAR_DESVENTAJAS = "GUARDAR DESVENTAJAS";
	public static final String GUARDAR_PSIQUICO = "GUARDAR PSIQUICO";
	public static final String GUARDAR_MISTICO = "GUARDAR MISTICO";
	public static final String GUARDAR_KI = "GUARDAR KI";
	public static final String CARGAR_KI = "CARGAR KI";
	public static final String REINICIAR_KI = "REINICIAR KI";
	public static final String ELIMINAR_DESVENTAJA = "ELIMINAR DESVENTAJA";
	public static final String AGREGAR_DESVENTAJA = "AGREGAR DESVENTAJA";
	public static final String ELIMINAR_POSESION = "ELIMINAR POSESION";
	public static final String AGREGAR_POSESION = "AGREGAR POSESION";
	public static final String VER_COMBATE = "ver combate";



	private PanelPersonajePrincipal panelPersonajePrincipal;

	private PanelMistico panelMistico;

	private PanelPsiquico panelPsiquico;

	private PanelKi panelKi;

	private Personaje personaje;

	private Main principal;


	public VentanaDatos(Main principal, Personaje personaje) {
		this.principal = principal;
		this.personaje = personaje;
		this.panelPersonajePrincipal = new PanelPersonajePrincipal(this, personaje);
		this.panelMistico = new PanelMistico(this, personaje);
		this.panelPsiquico = new PanelPsiquico(this, personaje);
		this.panelKi = new PanelKi(this, personaje);
		this.setLayout(new GridLayout(2, 2));
		add(panelPersonajePrincipal);
		add(panelMistico);
		add(panelPsiquico);
		add(panelKi);
		this.setTitle("Datos de personaje");
		this.setSize(700, 700);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(MODIFICAR_PSIQUICO)) {
			panelPsiquico.labelATextField();
		} else if (e.getActionCommand().equals(GUARDAR_PSIQUICO)) {
			try {
				panelPsiquico.textFieldALabel(personaje);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Escriba un dato valido o deje el texto por default en el campo de texto.");
			}
		} else if (e.getActionCommand().equals(MODIFICAR_MISTICO)) {
			panelMistico.lblATxtField();
		} else if (e.getActionCommand().equals(GUARDAR_MISTICO)) {
			try {
				panelMistico.txtFieldALbl(personaje);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Escriba un dato valido o deje el texto por default en el campo de texto.");
			}
		} else if (e.getActionCommand().equals(MODIFICAR_KI)) {
			panelKi.modificarKi();
		} else if (e.getActionCommand().equals(GUARDAR_KI)) {
			try {
				panelKi.guardarKi(personaje);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Escriba un dato valido o deje el texto por default en el campo de texto.");
			}
		} else if (e.getActionCommand().equals(CARGAR_KI)) {
			principal.cargarKi(personaje);
			panelKi.cambiarKiAcumulado(personaje);
		} else if (e.getActionCommand().equals(REINICIAR_KI)) {
			principal.reiniciarKi(personaje);
			panelKi.cambiarKiAcumulado(personaje);
		} else if (e.getActionCommand().equals(MODIFICAR_PRINCIPAL)) {
			panelPersonajePrincipal.modificarDatosPrincipales();
		} else if (e.getActionCommand().equals(GUARDAR_PRINCIPAL)) {
			panelPersonajePrincipal.guardarDatosPrincipales(personaje);
		} else if (e.getActionCommand().equals(MODIFICAR_CARACTERISTICAS)) {
			panelPersonajePrincipal.modificarCaracteristicas();
		} else if (e.getActionCommand().equals(GUARDAR_CARACTERISTICAS)) {
			panelPersonajePrincipal.guardarCaracteristicas(personaje);
		} else if (e.getActionCommand().equals(MODIFICAR_VENTAJAS)) {
			String nombre = JOptionPane.showInputDialog(this, "Escriba la ventaja que quiere añadir");
			panelPersonajePrincipal.agregarVentaja(personaje, nombre);
		} else if (e.getActionCommand().equals(AGREGAR_DESVENTAJA)) {
			String nombre = JOptionPane.showInputDialog(this, "Escriba la desventaja que quiere añadir");
			panelPersonajePrincipal.agregarDesventaja(personaje, nombre);
		} else if (e.getActionCommand().equals(AGREGAR_POSESION)) {
			String nombre = JOptionPane.showInputDialog(this, "Escriba el objeto que quiere añadir");
			panelPersonajePrincipal.agregarPosesion(personaje, nombre);
		} else if (e.getActionCommand().equals(ELIMINAR_VENTAJA)) {
			String[] ventajas = new String[personaje.getVentajas().size()];
			for (int i = 0; i < ventajas.length; i++) {
				ventajas[i] = personaje.getVentajas().get(i);
			}
			String posicionStr = (String) JOptionPane.showInputDialog(this, "Elija la ventaja a eliminar", "Eliminar ventaja", JOptionPane.QUESTION_MESSAGE, null, ventajas, ventajas[0]);
			int posicion = personaje.buscarNumeroVentaja(posicionStr);
			panelPersonajePrincipal.eliminarVentaja(personaje, posicion);
		} else if (e.getActionCommand().equals(ELIMINAR_DESVENTAJA)) {
			String[] desventajas = new String[personaje.getDesventajas().size()];
			for (int i = 0; i < desventajas.length; i++) {
				desventajas[i] = personaje.getDesventajas().get(i);
			}
			String posicionStr = (String) JOptionPane.showInputDialog(this, "Elija la desventaja a eliminar", "Eliminar desventaja", JOptionPane.QUESTION_MESSAGE, null, desventajas, desventajas[0]);
			int posicion = personaje.buscarNumeroDesventaja(posicionStr);
			panelPersonajePrincipal.eliminarDesventaja(personaje, posicion);
		} else if (e.getActionCommand().equals(ELIMINAR_POSESION)) {
			String[] posesiones = new String[personaje.getPosesiones().size()];
			for (int i = 0; i < posesiones.length; i++) {
				posesiones[i] = personaje.getPosesiones().get(i);
			}
			String posicionStr = (String) JOptionPane.showInputDialog(this, "Elija el objeto a eliminar", "Eliminar posesion", JOptionPane.QUESTION_MESSAGE, null, posesiones, posesiones[0]);
			int posicion = personaje.buscarNumeroPosesion(posicionStr);
			panelPersonajePrincipal.eliminarPosesion(personaje, posicion);
		} else if (e.getActionCommand().equals(VER_COMBATE)) {
			principal.entrarVentanaArmas(personaje);
		}
	}

}

