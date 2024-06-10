package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.Main;

public class VentanaPersonajes extends JFrame implements ActionListener{

	private Main principal;
	private PanelDatosPersonaje panelDatosPersonaje;
	
	 public VentanaPersonajes(Main principal) {
		this.principal = principal;
		this.panelDatosPersonaje = new PanelDatosPersonaje(this, principal.getPersonajes());
		this.setTitle("Datos de personajes.");
		this.setSize(900, 200);
		this.setLayout(new GridLayout(1, 2));
		this.add(panelDatosPersonaje);
		this.setVisible(true);
		
	}
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < principal.getPersonajes().size(); i++) {
			if (e.getActionCommand().equals(principal.getPersonajes().get(i).getNombre())) {
				principal.entrarVentanaPersonajeEspecifico(principal.getPersonajes().get(i));
			}
		}
		
	}
}


