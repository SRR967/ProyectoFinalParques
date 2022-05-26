package estructuras;

import enumeraciones.Color;

public class Casilla {
    public int id;
    public Casilla siguiente;
    public Casilla anterior;
    public Color color;
    public TipoCasilla tipo;
    public boolean estaOcupada;
    public boolean puedeComer = true;

}
