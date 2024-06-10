package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Combate {

	public ArrayList<Personaje> personajes;

	public Combate() {
		personajes = new ArrayList<Personaje>();
	}

	public void agregarPersonaje(Personaje personaje) {
		personajes.add(personaje);
	}

	public void eliminarPersonaje(String nombre) {
		personajes.remove(buscarPersonaje(nombre));
	}
	
	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje buscarPersonaje(String nombre) {
		Personaje respuesta = null;
		boolean encontrado = false;
		for (int i = 0; i < personajes.size() && encontrado == false; i++) {
			if (personajes.get(i).getNombre().equals(nombre)) {
				respuesta = personajes.get(i);
			} 
		}
		return respuesta;
	}

	public ArrayList<Integer> calcularIniciativa(){
		ArrayList<Integer> iniciativas = new ArrayList<Integer>();
		for (int i = 0; i < personajes.size(); i++) {
			int dado = (int) (Math.random() * 100) + 1 ;
			int iniciativa = 0;
			switch (dado) {
			case 1:
				iniciativa = personajes.get(i).getTurno() - 125;
				iniciativas.add(iniciativa);
				break;

			case 2:
				iniciativa = personajes.get(i).getTurno() - 100;
				iniciativas.add(iniciativa);
				break;

			case 3:
				iniciativa = personajes.get(i).getTurno() - 75;
				iniciativas.add(iniciativa);
				break;
			default:
				iniciativa = personajes.get(i).getTurno() + dado;
				iniciativas.add(iniciativa);
				break;
			}

		}
		return iniciativas;
	}

	public String pelea(Personaje atacante, Personaje defensor, int dado1, int dado2, int arma) {
		int respuesta =  (atacante.getArmas().get(arma).getHabilidadAtaque() + dado1) - (defensor.getHabilidad() + dado2);		
		if(respuesta < 10 && respuesta >= 0) {
			return "No hay daño";
		} else if (respuesta < 0) {
			int contraataque = (int) Math.abs(respuesta) / 2;
			return "Ataque fallido, contraataque con +" + contraataque;
		} else {
			Integer respuestaCompleja = respuesta;
			char[] digitos = respuestaCompleja.toString().toCharArray();
			if ((int) digitos[digitos.length - 1] != 0) {
				respuesta = respuesta - (int) digitos[digitos.length - 1];
			}
			return "Ataque con " + respuesta + "% de daño";
		}
	}
	
	public void cargarKi(Personaje personaje) {
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			personaje.getKiAcumulado()[i] += personaje.getAcumulacionKi()[i];
		}
	}
	
	public void reiniciarKi(Personaje personaje) {
		for (int i = 0; i < Personaje.NUMERO_KI; i++) {
			personaje.getKiAcumulado()[i] = 0;
		}
	}
	
	public void escribir() throws Exception {
		String path = System.getProperty("user.home") + "\\Desktop\\personajes.txt";
		File file = new File(path);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(personajes);
		oos.close();
		fos.close();
	}
	
	public void leer() throws Exception {
		String path = System.getProperty("user.home") + "\\Desktop\\\\personajes.txt";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Personaje> cargados = (ArrayList<Personaje>) ois.readObject();
		this.setPersonajes(cargados);
		fis.close();
		ois.close();
	}
	
	

}