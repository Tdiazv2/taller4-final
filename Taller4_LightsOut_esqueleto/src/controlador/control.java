package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.vista.JFprincipal;
import uniandes.dpoo.taller4.vista.juego;
import uniandes.dpoo.taller4.vista.parte_abajo;
import uniandes.dpoo.taller4.vista.parte_arrriba;
import uniandes.dpoo.taller4.vista.parte_derecha;

public class control {
	private parte_derecha derecha;
	private Tablero tablero;
	private juego izq;
	private parte_arrriba arriba;
	private parte_abajo abajo;
	private int dif;
	private int size;
	JFprincipal jf;
	private Top10 top;
	
	
	public control (JFprincipal frame){
		this.jf = frame;
		this.derecha = new parte_derecha(this);
		this.tablero = new Tablero(5);
		this.izq = new juego(this, tablero,5,0);
		this.arriba =  new parte_arrriba(this);
		this.abajo = new parte_abajo();
		this.size = 5;
		this.dif = 0;
		this.top = new Top10();
		File archivo = new File("data/top10.csv");
		top.cargarRecords(archivo);
		
		
	}
	public void salvar() throws FileNotFoundException, UnsupportedEncodingException {
		File archivo2 = new File("data/top10.csv");
		top.salvarRecords(archivo2);
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

	public juego getJuego() {
		return izq;
		
	}
	public parte_arrriba partArriba() {
		return arriba;
		
	}
	
	public juego  nuevo  (Tablero tablero2) {
		
		this.tablero = tablero2;
		
		jf.getIzquierda().vuelvepinta(tablero2, size,dif);
		abajo.setJugadas("0");
		return izq;
		
	}
	public void jugar(int y, int x) {
		
		this.tablero.jugar(x, y);
		jf.getIzquierda().vuelvepinta(tablero, size,dif);
		abajo.setJugadas(String.valueOf(this.tablero.darJugadas()));
		if (tablero.tableroIluminado()) {
			int puntaje = tablero.calcularPuntaje();
			JOptionPane.showMessageDialog(jf, "Ganaste!, Tu puntaje es de: " + puntaje, "Felicidades",JOptionPane.INFORMATION_MESSAGE);
			
			if(abajo.getJugador().equals("")) {
				String userInput = JOptionPane.showInputDialog("Por favor, ingresa tu nombre:");

		        
		        if (userInput != null) {
		            abajo.setJugador(userInput);
		            
		        } 
				
			}
			if(top.esTop10(puntaje)) {
				JOptionPane.showMessageDialog(jf, "Entraste en el top 10", "Felicidades, TOP-10",JOptionPane.INFORMATION_MESSAGE);
				top.agregarRegistro(abajo.getJugador(), puntaje);
			}
			abajo.setJugadas("0");
		}
		
	}
	public void camJug() {
		String userInput = JOptionPane.showInputDialog("Por favor, ingresa tu nombre:");

        
        if (userInput != null) {
            abajo.setJugador(userInput);
            
        } 
	}
	public void mostrarTop() {
		Collection<RegistroTop10> lista = top.darRegistros();
		DefaultListModel<RegistroTop10> listModel = new DefaultListModel<>();
		for (RegistroTop10 indv: lista) {
			
			listModel.addElement( indv);
			
		
		}
		 JList<RegistroTop10> muestraTop = new JList<>(listModel);
		 DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
		        @Override
		        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		            
		            
		            if (index < 3) {
		                c.setBackground(Color.YELLOW); 
		              
		            } 
		            else if(index >= 3 && index < 6) {
		            	c.setBackground(Color.BLUE);
		            }
		            else if(index >= 6 && index < 9) {
		            	c.setBackground(Color.RED);
		            }
		            else {
		                c.setBackground(list.getBackground()); 
		            }
		            
		            return c;
		        }
		    };

		    muestraTop.setCellRenderer(renderer);
		    muestraTop.setFixedCellHeight(30);
		    muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
	     JFrame frame = new JFrame("Top 10 Jugadores");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setSize(250,250);

	     JScrollPane jScrollPane = new JScrollPane(muestraTop);
	     frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

	     frame.pack();
	     frame.setVisible(true);
	       
	     
	    }
		
	
	public int getDif() {
		return dif;
	}

	public void setDif(int dif) {
		this.dif = dif;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Tablero creaTab(int size, int dif) {
		
	    Tablero tablero = new Tablero(size);
	    
	    
	    tablero.desordenar(dif);
	    return tablero;
	}
}
