package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelIniciativas extends JPanel { 
	private Ventana ventana;
	protected ArrayList<JLabel> personajes;
	protected ArrayList<JLabel> iniciativas;
	public static int NUMERO_PERSONAJES;

	public PanelIniciativas(Ventana Ventana) {
		this.ventana = ventana;
		NUMERO_PERSONAJES = 0;
		personajes = new ArrayList<JLabel>();
		iniciativas = new ArrayList<JLabel>();
		setBorder(new TitledBorder("Iniciativas"));
		setLayout(new GridLayout(NUMERO_PERSONAJES, 1));
		setVisible(true);
	}

	public void agregrarPersonaje(Personaje personaje) {
		personajes.add(new JLabel(personaje.getNombre()));
		iniciativas.add(new JLabel("Iniciativa: 0"));
		NUMERO_PERSONAJES++;
		this.setLayout(new GridLayout(NUMERO_PERSONAJES, 1));
		add(personajes.get(NUMERO_PERSONAJES - 1));
		add(iniciativas.get(NUMERO_PERSONAJES - 1));
		repaint();
		validate();
	}
	
	public void leerPersonajes (ArrayList<Personaje> personajes) {
		for (int i = 0; i < personajes.size(); i++) {
			this.agregrarPersonaje(personajes.get(i));
		}
	}
	

	public void calcularIniciativas(ArrayList<Integer> iniciativas) {
		for (int i = 0; i < iniciativas.size(); i++) {
			if(iniciativas.get(i) >= 3) {
				this.iniciativas.get(i).setText("Iniciativa: " + iniciativas.get(i));
			} else {
				this.iniciativas.get(i).setText("Iniciativa: " + iniciativas.get(i) + " pierde turno.");
			}
		}
		this.repaint();
		this.revalidate();
	}
	
	public void eliminarPersonaje(String nombre) {
		for (int i = 0; i < NUMERO_PERSONAJES; i++) {
			if (personajes.get(i).getText().equals(nombre)) {
				this.remove(personajes.get(i));
				this.remove(iniciativas.get(i));
				personajes.remove(i);
				iniciativas.remove(i);
				NUMERO_PERSONAJES--;
				this.setLayout(new GridLayout(NUMERO_PERSONAJES, 1));
				this.repaint();
				this.validate();
			}
		}
	
	}
}
