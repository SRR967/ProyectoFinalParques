package estructuras;

import enumeraciones.Color;

import java.util.ArrayList;

public class Casilla {
    private int id;
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Casilla siguiente;

    public Casilla anterior;

    public Casilla[] alterna = null;
    public Color color;

    public TipoCasilla tipo;

    private boolean estaOcupada;

    private boolean puedeComer = true;

    public Casilla(){

    }

    public Casilla(int id){
        this.id = id;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public boolean getIsEstaOcupada() {
        return estaOcupada;
    }

    public void setEstaOcupada(boolean estaOcupada) {
        this.estaOcupada = estaOcupada;
    }

    public boolean isEstaOcupada() {
        return estaOcupada;
    }

    public boolean isPuedeComer() {
        return puedeComer;
    }

    public void setPuedeComer(boolean puedeComer) {
        this.puedeComer = puedeComer;
    }
}
