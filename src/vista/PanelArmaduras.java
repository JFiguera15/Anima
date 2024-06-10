package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Personaje;

public class PanelArmaduras extends JPanel {
	
	private JComboBox<String> armaduras;
	private JLabel lblPenalizador, lblRestriccion, lblPresencia, lblEntereza, lblPercepcion, lblNombre, lblLocalizacion;
	private JLabel lblPenalizador2, lblRestriccion2, lblPresencia2, lblEntereza2, lblPercepcion2, lblNombre2, lblLocalizacion2;
	private JLabel[] lblTA;
	private JButton btnEliminarArmadura, btnAgregarArmadura;
	
	public PanelArmaduras(VentanaArmas ventanaArmas, Personaje personaje) {
		String[] listaArmaduras = new String[personaje.getArmaduras().length];
		this.btnAgregarArmadura = new JButton("Agregar Armadura");
		this.btnAgregarArmadura.setActionCommand(VentanaArmas.AGREGAR_ARMADURA);
		this.btnAgregarArmadura.addActionListener(ventanaArmas);
		this.btnEliminarArmadura = new JButton("Eliminar Armadura");
		this.btnEliminarArmadura.setActionCommand(VentanaArmas.ELIMINAR_ARMADURA);
		this.btnEliminarArmadura.addActionListener(ventanaArmas);
		for (int i = 0; i < listaArmaduras.length; i++) {
			if (personaje.getArmaduras()[i] != null) {
				listaArmaduras[i] = personaje.getArmaduras()[i].getNombre();
			}
			
		}
		if(listaArmaduras[0] != null || listaArmaduras[1] != null) {
			this.armaduras = new JComboBox<String>(listaArmaduras);
			this.add(armaduras);
		} else {
			this.add(btnAgregarArmadura);
			this.add(btnEliminarArmadura);
		}
		if (personaje.getArmaduras()[0] != null) {
			this.inicializarArmadura1(personaje);
			this.AniadirArmadura1();
		}
		if (personaje.getArmaduras()[1] != null) {
			this.inicializarArmadura2(personaje);
			this.AniadirArmadura2();
		}
	
		
		
		
	}
	
	
	public void inicializarArmadura1(Personaje personaje) {
		this.lblNombre = new JLabel(personaje.getArmaduras()[0].getNombre());
		this.lblPenalizador = new JLabel("Penalizador de turno: " + personaje.getArmaduras()[0].getPenalizadorTurno());
		this.lblRestriccion = new JLabel("Restriccion de movimiento: " + personaje.getArmaduras()[0].getRestriccionMovimiento());
		this.lblPresencia = new JLabel("Presencia: " + personaje.getArmaduras()[0].getPresencia());
		this.lblEntereza = new JLabel("Entereza: " + personaje.getArmaduras()[0].getEntereza());
		this.lblPercepcion = new JLabel("Penalizador de percepcion: " + personaje.getArmaduras()[0].getPenalizadoPercepcion());
		this.lblLocalizacion = new JLabel("Localizacion: " + personaje.getArmaduras()[0].getLocalizacion());
	}
	
	public void inicializarArmadura2(Personaje personaje) {
		this.lblNombre2 = new JLabel(personaje.getArmaduras()[1].getNombre());
		this.lblPenalizador2 = new JLabel("Penalizador de turno: " + personaje.getArmaduras()[1].getPenalizadorTurno());
		this.lblRestriccion2 = new JLabel("Restriccion de movimiento: " + personaje.getArmaduras()[1].getRestriccionMovimiento());
		this.lblPresencia2 = new JLabel("Presencia: " + personaje.getArmaduras()[1].getPresencia());
		this.lblEntereza2 = new JLabel("Entereza: " + personaje.getArmaduras()[1].getEntereza());
		this.lblPercepcion2 = new JLabel("Penalizador de percepcion: " + personaje.getArmaduras()[1].getPenalizadoPercepcion());
		this.lblLocalizacion2 = new JLabel("Localizacion: " + personaje.getArmaduras()[1].getLocalizacion());
	}
	
	public void AniadirArmadura1() {
		this.add(lblNombre);
		this.add(lblPenalizador);
		this.add(lblPercepcion);
		this.add(lblRestriccion);
		this.add(lblPresencia);
		this.add(lblEntereza);
		this.add(lblLocalizacion);
	}
	
	public void AniadirArmadura2() {
		this.add(lblNombre2);
		this.add(lblPenalizador2);
		this.add(lblPercepcion2);
		this.add(lblRestriccion2);
		this.add(lblPresencia2);
		this.add(lblEntereza2);
		this.add(lblLocalizacion2);
	}

}
