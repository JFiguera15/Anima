package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel{
	protected JButton agregarPersonaje, calcularIniciativa, combatir, btnEliminar, btnVerPersonajes, btnGuardar, btnCargar;
	private Ventana ventana;

	public PanelBotones(Ventana ventana) {
		this.ventana = ventana;
		setBorder(new TitledBorder("Acciones"));
		setLayout(new GridLayout(7, 1));
		agregarPersonaje = new JButton("Agregar Personaje");
		agregarPersonaje.setActionCommand(Ventana.AGREGAR);
		agregarPersonaje.addActionListener(ventana);
		calcularIniciativa = new JButton("Calcular Iniciativa");
		calcularIniciativa.addActionListener(ventana);
		calcularIniciativa.setActionCommand(Ventana.INICIATIVA);
		combatir = new JButton("Combatir");
		combatir.addActionListener(ventana);
		combatir.setActionCommand(Ventana.COMBATIR);
		btnEliminar = new JButton("Eliminar Personaje");
		btnEliminar.addActionListener(ventana);
		btnVerPersonajes = new JButton("Ver personajes");
		btnVerPersonajes.addActionListener(ventana);
		btnGuardar = new JButton("Guardar Personajes");
		btnGuardar.addActionListener(ventana);
		btnGuardar.setActionCommand(Ventana.GUARDAR);
		btnCargar = new JButton("Leer Personajes");
		btnCargar.addActionListener(ventana);
		add(agregarPersonaje);
		add(btnEliminar);
		add(calcularIniciativa);
		add(combatir);
		add(btnVerPersonajes);
		add(btnGuardar);
		add(btnCargar);
		setVisible(true);
	}
}
