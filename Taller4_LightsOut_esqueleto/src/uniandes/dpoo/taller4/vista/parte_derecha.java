package uniandes.dpoo.taller4.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.control;
import uniandes.dpoo.taller4.modelo.Tablero;

public class parte_derecha extends JPanel  {
	
	public final static String Nuevo="NUEVO";
	
	public final static String TOP="TOP-10";
	public final static String Cambiar_jug="CAMBIAR JUGADOR";
	public control contro;
	public JFprincipal jfprin;
	
	
	
	

	public parte_derecha(control contro){
		
		this.contro = contro;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
	    JButton top = new JButton ("TOP-10");
	    JButton nuevo = new JButton ("NUEVO");
	    JButton cambjug = new JButton ("CAMBIAR JUGADOR");
	    
	   
	    	
	    

	    this.add(Box.createVerticalGlue());
	    this.add(nuevo);
	    
	    this.add(top);
	    this.add(cambjug);
	    this.add(Box.createVerticalGlue());

	    this.setBackground(Color.LIGHT_GRAY);
	    	nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();			}
		});
	    	
	    	top.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							contro.mostrarTop();	}
			});
	    	cambjug.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							contro.camJug();}
			});
		
		
		
		
		
	}
	public void nuevo () {
		int size = contro.getSize();
		int dif = contro.getDif();
	    Tablero tablero = contro.creaTab(size, dif);
	    
	    contro.nuevo(tablero);
	    
	}
	public JFprincipal getJfprin() {
		return jfprin;
	}
	public void setJfprin(JFprincipal jfprin) {
		this.jfprin = jfprin;
	}
	
}
