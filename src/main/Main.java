package main;

import java.util.ArrayList;

import modelo.Combate;
import modelo.Personaje;
import vista.Ventana;
import vista.VentanaArmas;
import vista.VentanaDatos;
import vista.VentanaPersonajes;

public class Main {
	
	private Ventana ventana;
	private Combate combate;
	private VentanaPersonajes ventanaPersonajes;
	private VentanaDatos ventanaDatos;
	private VentanaArmas ventanaArmas;
	
	public Main() {
		ventana = new Ventana(this);
		combate = new Combate();
	}
	
	public void agregarPersonaje(Personaje personaje) {
		combate.agregarPersonaje(personaje);
	}
	
	public void eliminarPersonaje(String nombre) {
		combate.eliminarPersonaje(nombre);
	}
	
	public ArrayList<Personaje> getPersonajes() {
		return combate.personajes;
	}
	
	public void calcularIniciativa() {
		ventana.calularIniciativa(combate.calcularIniciativa());
	}
	
	public String combatir(Personaje atacante, Personaje defensor, int dado1, int dado2, int arma) {
		return combate.pelea(atacante, defensor, dado1, dado2, arma);
	}
	
	public Personaje buscarPersonaje(String nombre) {
		return combate.buscarPersonaje(nombre);
	}
	
	public void cargarKi(Personaje personaje) {
		combate.cargarKi(personaje);
	}
	
	public void reiniciarKi(Personaje personaje) {
		combate.reiniciarKi(personaje);
	}
	
	public void entrarAVentanaPersonajes() {
		ventanaPersonajes = new VentanaPersonajes(this);
	}
	
	public void entrarVentanaPersonajeEspecifico(Personaje personaje) {
		ventanaDatos = new VentanaDatos(this, personaje);
	}
	
	public void entrarVentanaArmas(Personaje personaje) {
		ventanaArmas = new VentanaArmas(this, personaje);
	}
	
	public void guardar() throws Exception{
		combate.escribir();
	}
	
	public void leer() throws Exception {
		combate.leer();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}

}
