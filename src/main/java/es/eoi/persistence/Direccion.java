package es.eoi.persistence;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Direccion implements Serializable {

    private String calle;
    private int numero;
    private String poblacion;

    public Direccion() {
    }

    public Direccion(String calle, int numero, String poblacion) {
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}
