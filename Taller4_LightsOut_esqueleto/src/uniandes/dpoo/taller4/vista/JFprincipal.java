package uniandes.dpoo.taller4.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.control;
import uniandes.dpoo.taller4.vista.parte_abajo;
import uniandes.dpoo.taller4.vista.parte_arrriba;
import uniandes.dpoo.taller4.vista.juego;
import uniandes.dpoo.taller4.vista.parte_derecha;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.vista.parte_derecha;
import uniandes.dpoo.taller4.vista.parte_arrriba;





public class JFprincipal extends JFrame  {
	
	private juego izquierda;
	private parte_arrriba arriba;
	private parte_abajo abajo;
	
	private parte_derecha derecha;
	
	private control con;
	
	
	
	
	
	
	
	public JFprincipal() {
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setTitle("Ligths Out");
		this.con = new control(this);
		this.derecha = con.getDerecha();
		
		this.arriba = con.partArriba();
		this.abajo = con.getAbajo();
		this.izquierda = con.getJuego();
		
		
		
		this.add(derecha, BorderLayout.EAST);
		this.add(arriba, BorderLayout.NORTH);
		this.add(abajo, BorderLayout.SOUTH);
		
		this.add(izquierda, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 
            	try {
					con.salvar();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		
		
		
		
		
	}


	public static void main(String[] args) {
		JFprincipal prin = new JFprincipal();
		
	}


	public juego getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(juego izquierda) {
		this.izquierda = izquierda;
		
	}


	public parte_arrriba getArriba() {
		return arriba;
	}


	public void setArriba(parte_arrriba arriba) {
		this.arriba = arriba;
	}


	public parte_abajo getAbajo() {
		return abajo;
	}


	public void setAbajo(parte_abajo abajo) {
		this.abajo = abajo;
	}


	public parte_derecha getDerecha() {
		return derecha;
	}


	public void setDerecha(parte_derecha derecha) {
		this.derecha = derecha;
	}


	public control getCon() {
		return con;
	}


	public void setCon(control con) {
		this.con = con;
	}
	
}
