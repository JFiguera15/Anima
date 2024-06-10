package modelo;

import java.io.Serializable;

public class Arma implements Serializable{
	public final static String CON = "CON";
	public final static String FIL = "FIL";
	public final static String PEN = "PEN";
	public final static String CAL = "CAL";
	public final static String FRI = "FRI";
	public final static String ENE = "ENE";
	public final static String ELE = "ELE";
	
	public final static String[] TIPOS_DE_DANIO = { FIL , CON, PEN, CAL, FRI, ENE, ELE };
	
	private String nombre;
	private int dano, HabilidadAtaque, bonoTurno;
	private String tipoAtaque1;
	private String tipoAtaque2;
	
	public Arma(String nombre, int dano, String tipoAtaque1, int habilidadAtaque, int bonoTurno) {
		super();
		this.nombre = nombre;
		this.dano = dano;
		this.tipoAtaque1 = tipoAtaque1;
		HabilidadAtaque = habilidadAtaque;
		this.bonoTurno = bonoTurno;
	}
	
	public Arma(String nombre, int dano, String tipoAtaque1, String tipoAtaque2, int habilidadAtaque) {
		super();
		this.nombre = nombre;
		this.dano = dano;
		this.tipoAtaque1 = tipoAtaque1;
		this.tipoAtaque2 = tipoAtaque2;
		HabilidadAtaque = habilidadAtaque;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public String gettipoAtaque1() {
		return tipoAtaque1;
	}
	public void settipoAtaque1(String tipoAtaque1) {
		this.tipoAtaque1 = tipoAtaque1;
	}
	public String gettipoAtaque2() {
		return tipoAtaque2;
	}
	public void settipoAtaque2(String tipoAtaque2) {
		this.tipoAtaque2 = tipoAtaque2;
	}
	public int getHabilidadAtaque() {
		return HabilidadAtaque;
	}
	public void setHabilidadAtaque(int habilidadAtaque) {
		HabilidadAtaque = habilidadAtaque;
	}
	
	public int getBonoTurno() {
		return bonoTurno;
	}

	public void setBonoTurno(int bonoTurno) {
		this.bonoTurno = bonoTurno;
	}

	@Override
	public String toString() {
		return "Arma [nombre=" + nombre + ", dano=" + dano + ", tipoAtaque1=" + tipoAtaque1 + ", tipoAtaque2="
				+ tipoAtaque2 + ", HabilidadAtaque=" + HabilidadAtaque + "]";
	}
	
}
