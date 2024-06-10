package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Main;
import modelo.Arma;
import modelo.Personaje;

public class Ventana extends JFrame implements ActionListener{
	public static final String AGREGAR = "agregar";
	public static final String INICIATIVA = "iniciativa";
	public static final String COMBATIR = "combatir";
	public static final String GUARDAR = "Guardar";


	private Main principal;
	private PanelIniciativas panelIniciativas;
	private PanelBotones panelBotones;
	public Ventana(Main principal) {
		this.principal = principal;
		setTitle("CreiAnima");
		setSize(700, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		setResizable(true);
		panelIniciativas = new PanelIniciativas(this);
		panelBotones = new PanelBotones(this);
		add(panelIniciativas);
		add(panelBotones);
		setVisible(true);
	}

	public void calularIniciativa(ArrayList<Integer> iniciativas) {
		panelIniciativas.calcularIniciativas(iniciativas);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(AGREGAR)) {
			String nombre = JOptionPane.showInputDialog(this, "Escriba el nombre");
			int turno = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba el turno"));
			int habilidadDefensiva = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba la habilidad defensiva del personaje"));
			int numeroArmas = Integer.parseInt(JOptionPane.showInputDialog(this, "Cuantas armas tiene el personaje?"));
			ArrayList<Arma> armas = new ArrayList<Arma>();
			for (int i = 0; i <= numeroArmas; i++) {
				if(i == 0) {
					int habilidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba la habilidad de ataque desarmado"));
					int danio = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba el daño del personaje sin armas"));
					armas.add(new Arma("Desarmado", danio, Arma.CON, habilidad, 0));
				} else {
					String nombreArma = JOptionPane.showInputDialog(this, "Escriba el nombre del arma");
					int habilidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba la habilidad de ataque con esta arma"));
					int danio = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba el daño con esta arma"));
					String tipoDanio = (String)JOptionPane.showInputDialog(this, "Eliga el tipo de daño", "Tipo daño", JOptionPane.QUESTION_MESSAGE, null, Arma.TIPOS_DE_DANIO, Arma.TIPOS_DE_DANIO[0]);
					int turnoArma = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba el bono de turno de esta arma"));
					armas.add(new Arma(nombreArma, danio, tipoDanio, habilidad, turnoArma));
				}
			}
			Personaje personaje = new Personaje(nombre, turno, habilidadDefensiva, armas);
			principal.agregarPersonaje(personaje);
			panelIniciativas.agregrarPersonaje(personaje);
		} else if (e.getActionCommand().equals(INICIATIVA)) {
			principal.calcularIniciativa();
		} else if (e.getActionCommand().equals(COMBATIR)) {
			String[] personajes = new String[principal.getPersonajes().size()];
			for (int i = 0; i < personajes.length; i++) {
				personajes[i] = principal.getPersonajes().get(i).getNombre();
			}
			String seleccionA  = (String)JOptionPane.showInputDialog(this, "Eliga personaje", "Atacante", JOptionPane.QUESTION_MESSAGE, null ,personajes, personajes[0]);
			Personaje atacante = principal.buscarPersonaje(seleccionA);
			String[] armas = new String[atacante.getArmas().size()];
			for (int i = 0; i < armas.length; i++) {
				armas[i] = atacante.getArmas().get(i).getNombre();
			}
			String nombreArma = (String)JOptionPane.showInputDialog(this, "Eliga arma", "Arma", JOptionPane.QUESTION_MESSAGE, null ,armas, armas[0]);
			int arma = atacante.buscarNumeroArma(nombreArma); 
			int dado1 = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba la tirada que saco el personaje"));
			String seleccionD = (String)JOptionPane.showInputDialog(this, "Eliga personaje", "Defensor", JOptionPane.QUESTION_MESSAGE, null ,personajes, personajes[0]);
			Personaje defensor = principal.buscarPersonaje(seleccionD);
			int dado2 = Integer.parseInt(JOptionPane.showInputDialog(this, "Escriba la tirada que saco el personaje."));
			JOptionPane.showMessageDialog(this, principal.combatir(atacante, defensor, dado1, dado2, arma));
		} else if (e.getSource() == panelBotones.btnEliminar) {
			String[] personajes = new String[principal.getPersonajes().size()];
			for (int i = 0; i < personajes.length; i++) {
				personajes[i] = principal.getPersonajes().get(i).getNombre();
			}
			String nombrePersonajeAEliminar = (String) JOptionPane.showInputDialog(this, "Seleccione el personaje a eliminar", "Eliminar", JOptionPane.QUESTION_MESSAGE, null, personajes, personajes[0]);
			principal.eliminarPersonaje(nombrePersonajeAEliminar);
			panelIniciativas.eliminarPersonaje(nombrePersonajeAEliminar);
		} else if (e.getSource() == panelBotones.btnVerPersonajes) {
			principal.entrarAVentanaPersonajes();
		} else if (e.getSource() == panelBotones.btnGuardar) {
			try {
				principal.guardar();
				JOptionPane.showMessageDialog(this, "Personajes guardados con exito.");
			} catch (Exception e2) {
				System.out.println("Ocurrio un error.");
			}
		} else if (e.getSource() == panelBotones.btnCargar) {
			try {
				principal.leer();
				panelIniciativas.leerPersonajes(principal.getPersonajes());
				this.revalidate();
				this.repaint();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "No cargo");
			}
		}

	}
}
