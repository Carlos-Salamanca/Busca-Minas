package model;

/**
 *
 * @author CARLOS SALAMANCA
 */
public class EstadoCasilla {
    private Mina mina;
    private int numero;
    private boolean bandera;

    public EstadoCasilla(Mina mina, int numero, boolean bandera) {
        this.mina = mina;
        this.numero = numero;
        this.bandera = bandera;
    }

    public Mina getMina() {
        return mina;
    }

    public void setMina(Mina mina) {
        this.mina = mina;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

}
