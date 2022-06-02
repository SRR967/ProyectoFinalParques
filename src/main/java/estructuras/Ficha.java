package estructuras;

import enumeraciones.Color;
import componentes.Tablero;

import java.util.ArrayList;

public class Ficha {
    public Casilla casilla;
    public Color color;

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public  String toString(){
        return "\u2659";
    }


}
