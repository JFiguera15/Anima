package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Personaje implements Serializable {
	public static final int NUMERO_RESISTENCIAS = 5;
	public static final int NUMERO_KI = 6;
	public static final int NUMERO_CARACTERISTICAS = 8;
	public static final int NUMERO_ARMADURAS = 2;

	private String nombre;
	private int nivel, xp, vida, cansancio, regeneracion, turno, 
	habilidad, xeon, act, proyeccionPsiquica, presencia, dinero, proyeccionMagica, nivelMagia, CVS, innatos;
	private ArrayList<Arma> armas;
	private Arma armaEquipada;
	private Armadura[] armaduras;
	private boolean mistico, psiquico, usuarioDeKi;
	private int[] puntosKi, acumulacionKi, kiAcumulado, caracteristicas, bonoCaracteristicas, resistencias;
	private ArrayList<String> ventajas, desventajas, posesiones;

	public Personaje(String nombre, int turno, int habilidad, ArrayList<Arma> armas) {
		this.nombre = nombre;
		this.turno = turno;
		this.habilidad = habilidad;
		this.armas = armas;
		this.vida = 0;
		this.mistico = false;
		this.psiquico = false;
		this.usuarioDeKi = false;
		this.presencia = 0;
		this.resistencias = new int[NUMERO_RESISTENCIAS];
		this.caracteristicas = new int[NUMERO_CARACTERISTICAS];
		this.bonoCaracteristicas = new int[NUMERO_CARACTERISTICAS];
		this.puntosKi = new int[NUMERO_KI];
		this.acumulacionKi = new int[NUMERO_KI];
		this.kiAcumulado = new int[NUMERO_KI];
		this.armaduras = new Armadura[NUMERO_ARMADURAS];
		this.nivel = 1;
		this.xp = 0;
		this.regeneracion = 0;
		this.cansancio = 0;
		this.xeon = 0;
		this.act = 0;
		this.proyeccionPsiquica = 0;
		this.CVS = 0;
		this.innatos = 0;
		this.proyeccionMagica = 0;
		this.nivelMagia = 0;
		this.dinero = 0;
		for (int i = 0; i < NUMERO_CARACTERISTICAS; i++) {
			caracteristicas[i] = 0;
			bonoCaracteristicas[i] = 0;
		}
		for (int i = 0; i < NUMERO_RESISTENCIAS; i++) {
			resistencias[i] = 0;
		}
		for (int i = 0; i < NUMERO_KI; i++) {
			puntosKi[i] = 0;
			acumulacionKi[i] = 0;
			kiAcumulado[i] = 0;
		}
		for (int i = 0; i < NUMERO_ARMADURAS; i++) {
			armaduras[i] = null;
		}
		this.ventajas = new ArrayList<String>();
		this.desventajas = new ArrayList<String>();
		this.posesiones = new ArrayList<String>();
		this.armaEquipada = armas.get(0);
	}

	public int[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(int[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public ArrayList<String> getVentajas() {
		return ventajas;
	}

	public void setVentajas(ArrayList<String> ventajas) {
		this.ventajas = ventajas;
	}

	public int[] getAcumulacionKi() {
		return acumulacionKi;
	}

	public int[] getKiAcumulado() {
		return kiAcumulado;
	}

	public void setKiAcumulado(int[] kiAcumulado) {
		this.kiAcumulado = kiAcumulado;
	}

	public void setAcumulacionKi(int[] acumulacionKi) {
		this.acumulacionKi = acumulacionKi;
	}

	public ArrayList<String> getDesventajas() {
		return desventajas;
	}

	public void setDesventajas(ArrayList<String> desventajas) {
		this.desventajas = desventajas;
	}

	public boolean isMistico() {
		return mistico;
	}

	public void setMistico(boolean mistico) {
		this.mistico = mistico;
	}

	public int getPresencia() {
		return presencia;
	}

	public int getNivelMagia() {
		return nivelMagia;
	}

	public void setNivelMagia(int nivelMagia) {
		this.nivelMagia = nivelMagia;
	}

	public void setPresencia(int presencia) {
		this.presencia = presencia;
	}

	public boolean isPsiquico() {
		return psiquico;
	}

	public void setPsiquico(boolean psiquico) {
		this.psiquico = psiquico;
	}
	
	public Arma getArmaEquipada() {
		return armaEquipada;
	}

	public void setArmaEquipada(Arma armaEquipada) {
		this.armaEquipada = armaEquipada;
	}

	public Armadura[] getArmaduras() {
		return armaduras;
	}

	public void setArmaduras(Armadura[] armaduras) {
		this.armaduras = armaduras;
	}

	public boolean isUsuarioDeKi() {
		return usuarioDeKi;
	}

	public void setUsuarioDeKi(boolean usuarioDeKi) {
		this.usuarioDeKi = usuarioDeKi;
	}

	public int getXeon() {
		return xeon;
	}

	public void setXeon(int xeon) {
		this.xeon = xeon;
	}

	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}

	public int getProyeccionPsiquica() {
		return proyeccionPsiquica;
	}

	public void setProyeccionPsiquica(int proyeccionPsiquica) {
		this.proyeccionPsiquica = proyeccionPsiquica;
	}

	public int[] getPuntosKi() {
		return puntosKi;
	}

	public int getCVS() {
		return CVS;
	}

	public void setCVS(int cVS) {
		CVS = cVS;
	}

	public int getInnatos() {
		return innatos;
	}

	public void setInnatos(int innatos) {
		this.innatos = innatos;
	}

	public void setPuntosKi(int[] puntosKi) {
		this.puntosKi = puntosKi;
	}



	public int getProyeccionMagica() {
		return proyeccionMagica;
	}

	public void setProyeccionMagica(int proyeccionMagica) {
		this.proyeccionMagica = proyeccionMagica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}

	public ArrayList<Arma> getArmas() {
		return armas;
	}

	public void setArmas(ArrayList<Arma> armas) {
		this.armas = armas;
	}

	public void agregarArma(String nombre, int dano, String tipoAtaque1, int habilidadAtaque, int bonoTurno) {
		this.armas.add(new Arma(nombre, dano, tipoAtaque1, habilidadAtaque, bonoTurno));
	}

	public Arma buscarArma(String nombre) {
		Arma respuesta = null;
		boolean encontrado = false;
		for (int i = 0; i < armas.size() && encontrado == false; i++) {
			if (armas.get(i).getNombre().equals(nombre)) {
				respuesta = armas.get(i);
			} 
		}
		return respuesta;
	}

	public int buscarNumeroArma(String nombre) {
		int respuesta = 0;
		boolean encontrado = false;
		for (int i = 0; i < armas.size() && encontrado == false; i++) {
			if (armas.get(i).getNombre().equals(nombre)) {
				respuesta = i;
				encontrado = true;
			} 
		}
		return respuesta;
	}

	public int buscarNumeroVentaja(String nombre) {
		int respuesta = 0;
		boolean encontrado = false;
		for (int i = 0; i < ventajas.size() && encontrado == false; i++) {
			if (ventajas.get(i).equals(nombre)) {
				respuesta = i;
				encontrado = true;
			} 
		}
		return respuesta;
	}

	public int buscarNumeroDesventaja(String nombre) {
		int respuesta = 0;
		boolean encontrado = false;
		for (int i = 0; i < desventajas.size() && encontrado == false; i++) {
			if (desventajas.get(i).equals(nombre)) {
				respuesta = i;
				encontrado = true;
			} 
		}
		return respuesta;
	}

	public int buscarNumeroPosesion(String nombre) {
		int respuesta = 0;
		boolean encontrado = false;
		for (int i = 0; i < posesiones.size() && encontrado == false; i++) {
			if (posesiones.get(i).equals(nombre)) {
				respuesta = i;
				encontrado = true;
			} 
		}
		return respuesta;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getCansancio() {
		return cansancio;
	}

	public void setCansancio(int cansancio) {
		this.cansancio = cansancio;
	}

	public int getRegeneracion() {
		return regeneracion;
	}

	public void setRegeneracion(int regeneracion) {
		this.regeneracion = regeneracion;
	}

	public int[] getBonoCaracteristicas() {
		return bonoCaracteristicas;
	}

	public void setBonoCaracteristicas(int[] bonoCaracteristicas) {
		this.bonoCaracteristicas = bonoCaracteristicas;
	}

	public int[] getResistencias() {
		return resistencias;
	}

	public void setResistencias(int[] resistencias) {
		this.resistencias = resistencias;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public ArrayList<String> getPosesiones() {
		return posesiones;
	}

	public void setPosesiones(ArrayList<String> posesiones) {
		this.posesiones = posesiones;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + "~ nivel=" + nivel + "~ xp=" + xp + "~ vida=" + vida + "~ cansancio="
				+ cansancio + "~ regeneracion=" + regeneracion + "~ turno=" + turno + "~ habilidad=" + habilidad
				+ "~ xeon=" + xeon + "~ act=" + act + "~ proyeccionPsiquica=" + proyeccionPsiquica + "~ presencia="
				+ presencia + "~ dinero=" + dinero + "~ proyeccionMagica=" + proyeccionMagica + "~ nivelMagia="
				+ nivelMagia + "~ CVS=" + CVS + "~ innatos=" + innatos + "~ armas=" + armas + "~ armaEquipada="
				+ armaEquipada + "~ armaduras=" + Arrays.toString(armaduras) + "~ mistico=" + mistico + "~ psiquico="
				+ psiquico + "~ usuarioDeKi=" + usuarioDeKi + "~ puntosKi=" + Arrays.toString(puntosKi)
				+ "~ acumulacionKi=" + Arrays.toString(acumulacionKi) + "~ kiAcumulado=" + Arrays.toString(kiAcumulado)
				+ "~ caracteristicas=" + Arrays.toString(caracteristicas) + "~ bonoCaracteristicas="
				+ Arrays.toString(bonoCaracteristicas) + "~ resistencias=" + Arrays.toString(resistencias)
				+ "~ ventajas=" + ventajas + "~ desventajas=" + desventajas + "~ posesiones=" + posesiones;
	}

	

}
