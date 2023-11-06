package uniandes.dpoo.taller4.vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class parte_abajo extends JPanel{
	public JLabel jugadas;
	private JLabel jugador;
	public parte_abajo(){
		JLabel txtjugadas = new JLabel("Jugadas");
		JLabel txtjugador = new JLabel("Jugador");
		this.jugadas = new JLabel("0");
		this.jugador = new JLabel("");
		this.setLayout(new GridLayout(0,4,10,10));
		this.add(txtjugadas);
		this.add(jugadas);
		this.add(txtjugador);
		this.add(jugador);
		this.setBackground(Color.LIGHT_GRAY);
	
}
	public JLabel getJugadas() {
		return jugadas;
	}
	public void setJugadas(String txt) {
		jugadas.setText(txt);;
	}
	public String getJugador() {
		return jugador.getText();
		
	}
	public void setJugador(String txt) {
		jugador.setText(txt);;
	}
}

