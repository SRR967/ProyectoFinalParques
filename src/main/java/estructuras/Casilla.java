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
    public int getId() {
        return id;
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


}
