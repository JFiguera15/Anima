package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Personaje;

public class PanelPersonajePrincipal extends JPanel {

	private PanelPersonajeDatos panelPersonajeDatos;

	private PanelVentajas panelVentajas;

	private PanelCaracteristicas panelCaracteristicas;


	public PanelPersonajePrincipal(VentanaDatos ventanaDatos, Personaje personaje) {

		this.panelPersonajeDatos = new PanelPersonajeDatos(ventanaDatos,personaje);
		this.panelVentajas = new PanelVentajas(ventanaDatos,personaje);
		this.panelCaracteristicas = new PanelCaracteristicas(ventanaDatos,personaje);
		this.setBorder(new TitledBorder("Principal"));
		this.setLayout(new GridLayout(1, 3));
		this.add(panelPersonajeDatos);
		this.add(panelCaracteristicas);
		this.add(panelVentajas);
		this.setVisible(true);
	}
	
	public void modificarDatosPrincipales() {
		panelPersonajeDatos.modificarDatosPrincipales();
	}
	
	public void guardarDatosPrincipales(Personaje personaje) {
		panelPersonajeDatos.guardarDatosPrincipales(personaje);
	}
	
	public void modificarCaracteristicas() {
		panelCaracteristicas.modificarCaracteristicas();
	}
	
	public void guardarCaracteristicas(Personaje personaje) {
		panelCaracteristicas.guardarCaracteristicas(personaje);
	}
	
	public void agregarVentaja(Personaje personaje, String nombre) {
		panelVentajas.agregarVentaja(personaje, nombre);
	}
	
	public void eliminarVentaja(Personaje personaje, int posicion) {
		panelVentajas.eliminarVentaja(personaje, posicion);
	}
	
	public void agregarDesventaja(Personaje personaje, String nombre) {
		panelVentajas.agregarDesventaja(personaje, nombre);
	}
	
	public void eliminarDesventaja(Personaje personaje, int posicion) {
		panelVentajas.eliminarDesventaja(personaje, posicion);
	}
	
	public void agregarPosesion(Personaje personaje, String nombre) {
		panelVentajas.agregarPosesion(personaje, nombre);
	}
	
	public void eliminarPosesion(Personaje personaje, int posicion) {
		panelVentajas.eliminarPosesion(personaje, posicion);
	}
	
	public void abrirVentanaArmas() {
		
	}
	

}
