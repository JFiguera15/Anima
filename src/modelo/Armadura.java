package modelo;

import java.util.Arrays;

public class Armadura {

	private String nombre, localizacion, tipo;
	private int penalizadorTurno, restriccionMovimiento, presencia, entereza, penalizadoPercepcion;
	private int[] ta;
	public static final int NUMERO_DANIOS = 7;
	
	public Armadura(String nombre, String localizacion, String tipo, int penalizadorTurno, int restriccionMovimiento,
			int presencia, int entereza, int penalizadoPercepcion, int[] ta) {
		super();
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.tipo = tipo;
		this.penalizadorTurno = penalizadorTurno;
		this.restriccionMovimiento = restriccionMovimiento;
		this.presencia = presencia;
		this.entereza = entereza;
		this.penalizadoPercepcion = penalizadoPercepcion;
		this.ta = ta;
	}

	public Armadura(String nombre, String localizacion, String tipo, int penalizadorTurno, int restriccionMovimiento,
			int presencia, int entereza, int penalizadoPercepcion) {
		super();
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.tipo = tipo;
		this.penalizadorTurno = penalizadorTurno;
		this.restriccionMovimiento = restriccionMovimiento;
		this.presencia = presencia;
		this.entereza = entereza;
		this.penalizadoPercepcion = penalizadoPercepcion;
		this.ta = new int[NUMERO_DANIOS];
		for (int i = 0; i < ta.length; i++) {
			ta[i] = 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPenalizadorTurno() {
		return penalizadorTurno;
	}

	public void setPenalizadorTurno(int penalizadorTurno) {
		this.penalizadorTurno = penalizadorTurno;
	}

	public int getRestriccionMovimiento() {
		return restriccionMovimiento;
	}

	public void setRestriccionMovimiento(int restriccionMovimiento) {
		this.restriccionMovimiento = restriccionMovimiento;
	}

	public int getPresencia() {
		return presencia;
	}

	public void setPresencia(int presencia) {
		this.presencia = presencia;
	}

	public int getEntereza() {
		return entereza;
	}

	public void setEntereza(int entereza) {
		this.entereza = entereza;
	}

	public int getPenalizadoPercepcion() {
		return penalizadoPercepcion;
	}

	public void setPenalizadoPercepcion(int penalizadoPercepcion) {
		this.penalizadoPercepcion = penalizadoPercepcion;
	}

	public int[] getTa() {
		return ta;
	}

	public void setTa(int[] ta) {
		this.ta = ta;
	}

	@Override
	public String toString() {
		return "Armadura [nombre=" + nombre + ", localizacion=" + localizacion + ", tipo=" + tipo
				+ ", penalizadorTurno=" + penalizadorTurno + ", restriccionMovimiento=" + restriccionMovimiento
				+ ", presencia=" + presencia + ", entereza=" + entereza + ", penalizadoPercepcion="
				+ penalizadoPercepcion + ", ta=" + Arrays.toString(ta) + "]";
	}
	
}
