package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelDatosPersonaje extends JPanel{
	public static final int INFO_PERSONAJES = 8;
	protected ArrayList<JButton> botones;
	protected ArrayList<PanelPersonaje> listaPersonajes;
	private VentanaPersonajes ventana;
	
	
	public PanelDatosPersonaje(VentanaPersonajes ventana, ArrayList<Personaje> personajes) {
		this.ventana = ventana;
		botones = new ArrayList<JButton>();
		listaPersonajes = new ArrayList<PanelPersonaje>();
		this.setLayout(new GridLayout(PanelIniciativas.NUMERO_PERSONAJES, 1));
		this.setBorder(new TitledBorder("Lista Personajes"));
		this.setVisible(true);
		agregarPersonajes(personajes);
		for (int i = 0; i < listaPersonajes.size(); i++) {
			listaPersonajes.get(i).getBtnVerDatosDetallados().addActionListener(ventana);
			TitledBorder tb = (TitledBorder) listaPersonajes.get(i).getBorder();
			String nombre = tb.getTitle();
			listaPersonajes.get(i).getBtnVerDatosDetallados().setActionCommand(nombre);
		}
	}
	
	public void agregarPersonajes(ArrayList<Personaje> personajes) {
		for (int i = 0; i < personajes.size(); i++) {
			listaPersonajes.add(new PanelPersonaje(personajes.get(i)));
			this.add(listaPersonajes.get(i));
		}
	}
	
	public int conseguirPosicionPersonaje() {
		int respuesta = 0;
		
		return respuesta;
	}
	
	
	
	
}
