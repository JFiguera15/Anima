package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Main;
import modelo.Personaje;

public class VentanaArmas extends JFrame implements ActionListener{

	public static final String ARMA_EQUIPADA = "arma equipada";
	public static final String AGREGAR_ARMADURA = "AGREGAR ARMADURA";
	public static final String ELIMINAR_ARMADURA = "ELIMINAR ARMADURA";
	
	private Personaje personaje;
	private Main principal;
	private PanelArmas panelArmas;
	private PanelArmaduras panelArmaduras;
	
	public VentanaArmas(Main principal, Personaje personaje) {
		this.principal = principal;
		this.personaje = personaje;
		this.setTitle("Armas y armaduras");
		this.panelArmas = new PanelArmas(this, personaje);
		this.add(panelArmas);
		this.panelArmaduras = new PanelArmaduras(this, personaje);
		this.add(panelArmaduras);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 3));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(AGREGAR_ARMADURA)) {
			String nombre = JOptionPane.showInputDialog(this, "Escriba el nombre de la armadura");
			
		}
		
	}

}
