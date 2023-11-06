package uniandes.dpoo.taller4.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlador.control;
import uniandes.dpoo.taller4.modelo.Tablero;

public class juego extends JPanel implements MouseListener {
	
	private int dificultad;
	private int size;
	private Tablero tablero;
	public control contro;
	
	
	
	
    public juego(control contro, Tablero tablero, int size, int dificultad) {
    	
    	this.size = size;
    	this.dificultad = dificultad;
    	this.tablero = tablero;
    	this.contro = contro;
    	
    	addMouseListener(this);
    	
        // Constructor
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        boolean [][] tablita = tablero.darTablero();
        
        
        
        Graphics2D g2d = (Graphics2D) g;
        int ancho = getWidth();
        int alto = getHeight();
        
        try {
			BufferedImage imagen = ImageIO.read(new File("data/luz.png"));
			int indAncho = (ancho/size);
	        int indAlto = (alto/size);
	        
	        for (int i =0;i<size;i++) {
	        	for (int j =  0; j<size; j++) {
	        		if (tablita[i][j]) {
	        			RoundRectangle2D.Double casilla = new RoundRectangle2D.Double(indAncho*i, indAlto*j, indAncho-size,indAlto-size, 8, 8);
	        			g2d.drawImage(imagen, (int)casilla.getX(), (int)casilla.getY(), (int)casilla.getWidth(), (int)casilla.getHeight(), null);
	            		g2d.setColor(Color.YELLOW); 
	                    g2d.fill(casilla); 
	                    g2d.setColor(Color.BLACK);
	        		}
	        		else {
	        			RoundRectangle2D.Double casilla = new RoundRectangle2D.Double(indAncho*i, indAlto*j, indAncho-size,indAlto-size, 8, 8);
	        			g2d.drawImage(imagen, (int)casilla.getX(), (int)casilla.getY(), (int)casilla.getWidth(), (int)casilla.getHeight(), null);
	            		g2d.fill(casilla);
	        		}
	        		
	        	}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        RoundRectangle2D.Double casilla2 = new RoundRectangle2D.Double(0, 0, ancho, alto, 8, 8);
        
        g2d.draw(casilla2);
        g2d.dispose();
        
    }
    
    public void vuelvepinta(Tablero tablero2, int size2, int dif2) {
    	this.tablero = tablero2;
    	this.size = size2;
    	this.dificultad = dif2;
    	
    	repaint();
    }
    public void mousePressed(MouseEvent e)
    {
    int click_x = e.getX();
    int click_y = e.getY();
    int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
    contro.jugar(casilla[0], casilla[1]);
    
    
    }
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    int ladoTablero = size;
    int altoPanelTablero = getHeight();
    int anchoPanelTablero = getWidth();
    int altoCasilla = (altoPanelTablero-size) / ladoTablero;
    int anchoCasilla = (anchoPanelTablero-size )/ ladoTablero;
    int fila = (int) (y / altoCasilla);
    int columna = (int) (x / anchoCasilla);
    return new int[] { fila, columna };
    }
    public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public int darSize() {
		return size;
		
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	



    
    
    
    
}

    

