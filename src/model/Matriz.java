package model;

import java.util.Vector;

/**
 *
 * @author CARLOS SALAMANCA
 */
public class Matriz {
    private Casilla[][] Casillas;

    public Matriz(int numero) {
        this.Casillas = new Casilla[numero][numero];
    }

    public Casilla[][] getCasillas() {
        return Casillas;
    }

    public void setCasillas(Casilla[][] Casillas) {
        this.Casillas = Casillas;
    }
    
    
}
