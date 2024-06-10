package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Personaje;

public class PanelArmas extends JPanel{

	private JLabel lblTurno, lbltipoDanio, lblNombre, lblHabilidad, lblDanio;
	private JComboBox<String> armas;
	private JButton btnArmaEquipada;
	
	public PanelArmas(VentanaArmas ventanaArmas,Personaje personaje) {
		String[] listaArmas = new String[personaje.getArmas().size()];
		for (int i = 0; i < listaArmas.length; i++) {
			listaArmas[i] = personaje.getArmas().get(i).getNombre();
		}
		this.armas = new JComboBox<String>(listaArmas);
		this.lblNombre = new JLabel(personaje.getArmaEquipada().getNombre());
		this.lblTurno = new JLabel("Bono turno: " + personaje.getArmaEquipada().getBonoTurno());
		this.lbltipoDanio = new JLabel("Tipo de daño: " + personaje.getArmaEquipada().gettipoAtaque1());
		this.lblHabilidad = new JLabel("Habilidad de ataque: " + personaje.getArmaEquipada().getHabilidadAtaque());
		this.lblDanio = new JLabel("Daño de arma: " + personaje.getArmaEquipada().getDano());
		this.btnArmaEquipada = new JButton("Cambiar arma");
		this.btnArmaEquipada.setActionCommand(VentanaArmas.ARMA_EQUIPADA);
		this.btnArmaEquipada.addActionListener(ventanaArmas);
		this.setLayout(new GridLayout(7, 1));
		this.add(armas);
		this.add(btnArmaEquipada);
		this.add(lblNombre);
		this.add(lblTurno);
		this.add(lblHabilidad);
		this.add(lblDanio);
		this.add(lbltipoDanio);
		this.setVisible(true);
	}
}
