package model;

/**
 *
 * @author CARLOS SALAMANCA
 */
public class Casilla {
    private String color;
    private EstadoCasilla estadoCasilla;

    public Casilla(String color, EstadoCasilla estadoCasilla) {
        this.color = color;
        this.estadoCasilla = estadoCasilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EstadoCasilla getEstadoCasilla() {
        return estadoCasilla;
    }

    public void setEstadoCasilla(EstadoCasilla estadoCasilla) {
        this.estadoCasilla = estadoCasilla;
    }

}
