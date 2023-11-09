package model;

/**
 *
 * @author CARLOS SALAMANCA
 */
public class Mina {
    private boolean estado;
    private String imagen;

    public Mina(boolean estado, String imagen) {
        this.estado = estado;
        this.imagen = imagen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
