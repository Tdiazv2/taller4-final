package uniandes.dpoo.taller4.vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import controlador.control;
import uniandes.dpoo.taller4.modelo.Tablero;


public class parte_arrriba extends JPanel {
	
	public JComboBox<String> box;
	String []caja = {"5X5", "6X6", "7X7"};
	public control contro;
	
	
	
	


	//JCOMBO BOX
	//JRADIO BUTTON
	public parte_arrriba(control contro){
		JLabel Tamanio = new JLabel("Tamaño");
		this.box = new JComboBox<>( caja);
		this.contro = contro;
		
		
		
		
		JLabel dif = new JLabel("Dificultad:");
		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton mid = new JRadioButton("Medium");
		JRadioButton hard = new JRadioButton("Hard");
		ButtonGroup difi = new ButtonGroup();
		difi.add(easy);
		difi.add(mid);
		difi.add(hard);
		this.add(Tamanio);
		this.add(box);
		this.add(dif);
		this.add(easy);
		this.add(mid);
		this.add(hard);
		this.setBackground(Color.LIGHT_GRAY);
		
		 easy.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int size = contro.getJuego().darSize();
	            	Tablero tablero = contro.creaTab(size, 1);
	            	contro.setDif(3);
	                contro.nuevo(tablero);
	            }
	        });
		 mid.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int size = contro.getJuego().darSize();
	            	Tablero tablero = contro.creaTab(size, 2);
	            	contro.setDif(6);
	                contro.nuevo(tablero);
	            }
	        });
		 hard.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int size = contro.getJuego().darSize();
	            	Tablero tablero = contro.creaTab(size, 3);
	            	contro.setDif(9);
	                contro.nuevo(tablero);
	            }
	        });
		 box.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String seleccion = (String) box.getSelectedItem();
	                if (seleccion.equals("5X5")) {
	                	int dif = contro.getJuego().getDificultad();
		            	Tablero tablero = contro.creaTab(5, dif);
		            	contro.setSize(5);
		                contro.nuevo(tablero);
	                }
	                else if (seleccion.equals("6X6")) {
	                	int dif = contro.getJuego().getDificultad();
		            	Tablero tablero = contro.creaTab(6, dif);
		            	contro.setSize(6);
		                contro.nuevo(tablero);
	                }
	                else if (seleccion.equals("7X7")) {
	                	int dif = contro.getJuego().getDificultad();
		            	Tablero tablero = contro.creaTab(7, dif);
		            	contro.setSize(7);
		                contro.nuevo(tablero);
	                }
	            }
	        });
		
		
	}
	public String darCombobox() {
	    String selectedItem = (String) box.getSelectedItem();
	    return selectedItem;
	}
	
	
}
